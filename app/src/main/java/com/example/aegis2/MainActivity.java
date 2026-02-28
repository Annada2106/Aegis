package com.example.aegis2;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;
import android.graphics.Color;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.os.Vibrator;
import android.os.VibrationEffect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.InputStream;
import java.util.UUID;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView statusText;

    BluetoothAdapter bluetoothAdapter;
    BluetoothSocket socket;
    InputStream inputStream;

    String espMac = "80:F3:DA:64:BF:6E";
    UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    private static final String CHANNEL_ID = "AEGIS_ALERTS";
    Vibrator vibrator;

    // ⭐ SMART STATE FLAGS
    private boolean intruderActive = false;
    private boolean safeAnnounced = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusText = findViewById(R.id.statusText);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        createNotificationChannel();
        updateStatus("🟡 Starting Aegis...");

        requestPermissions();

        new Thread(() -> {
            try {
                Thread.sleep(1200);
                connectBluetooth();
            } catch (Exception ignored) {}
        }).start();
    }

    void updateStatus(String msg) {
        runOnUiThread(() -> statusText.setText(msg));
    }

    void requestPermissions() {
        ActivityCompat.requestPermissions(
                this,
                new String[]{
                        Manifest.permission.BLUETOOTH_CONNECT,
                        Manifest.permission.BLUETOOTH_SCAN,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.POST_NOTIFICATIONS
                },
                1
        );
    }

    void connectBluetooth() {
        try {
            updateStatus("🟡 Connecting to Aegis...");

            if (bluetoothAdapter == null) {
                updateStatus("❌ Bluetooth not supported");
                return;
            }

            if (!bluetoothAdapter.isEnabled()) {
                updateStatus("❌ Enable Bluetooth first");
                return;
            }

            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.BLUETOOTH_CONNECT)
                    != PackageManager.PERMISSION_GRANTED) {
                updateStatus("❌ Bluetooth permission missing");
                return;
            }

            BluetoothDevice device =
                    bluetoothAdapter.getRemoteDevice(espMac);

            socket = device.createRfcommSocketToServiceRecord(uuid);
            socket.connect();

            inputStream = socket.getInputStream();

            runOnUiThread(() -> {
                statusText.setText("🟢 Connected to Aegis");
                statusText.setTextColor(Color.GREEN);
            });

            listenForData();

        } catch (Exception e) {
            e.printStackTrace();
            runOnUiThread(() -> {
                statusText.setText("🔴 Connection Failed");
                statusText.setTextColor(Color.RED);
            });
        }
    }

    private void listenForData() {
        new Thread(() -> {
            byte[] buffer = new byte[1024];
            int bytes;

            while (true) {
                try {
                    bytes = inputStream.read(buffer);
                    String message = new String(buffer, 0, bytes).trim();
                    Log.d("AEGIS_BT", "Received: " + message);
                    runOnUiThread(() -> handleMessage(message));
                } catch (IOException e) {
                    e.printStackTrace();
                    updateStatus("🔴 Disconnected");
                    break;
                }
            }
        }).start();
    }

    // ⭐ SMART MESSAGE HANDLER
    private void handleMessage(String message) {

        // 🚨 ALERT
        if (message.contains("ALERT")) {

            if (!intruderActive) {
                intruderActive = true;
                safeAnnounced = false;

                String time = getTimeStamp();
                statusText.setText("🚨 INTRUDER ALERT!\n" + time);
                statusText.setTextColor(Color.RED);

                showIntruderNotification();
                vibrateAlert();
            }
        }

        // ✅ SAFE / READY
        else if (message.contains("SAFE") || message.contains("READY")) {

            // ⭐ intruder just cleared
            if (intruderActive && !safeAnnounced) {
                intruderActive = false;
                safeAnnounced = true;

                statusText.setText("✅ AREA SAFE");
                statusText.setTextColor(Color.GREEN);

                showSafeNotification(); // ⭐ NEW LINE
            }

            // normal ready state
            else if (!intruderActive && message.contains("READY")) {
                statusText.setText("🔵 SYSTEM READY");
                statusText.setTextColor(Color.CYAN);
            }
        }

        // ⚫ DISARMED
        else if (message.contains("DISARMED")) {
            intruderActive = false;
            safeAnnounced = true;

            statusText.setText("⚫ SYSTEM DISARMED");
            statusText.setTextColor(Color.GRAY);
        }

        // 🆘 PANIC
        else if (message.contains("PANIC_ON") || message.contains("SOS_TRIGGER")) {
            statusText.setText("🆘 PANIC MODE ENABLED");
            statusText.setTextColor(Color.MAGENTA);
        }
    }

    private String getTimeStamp() {
        return new SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                .format(new Date());
    }

    private void vibrateAlert() {
        if (vibrator == null) return;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(
                    VibrationEffect.createOneShot(
                            500,
                            VibrationEffect.DEFAULT_AMPLITUDE
                    )
            );
        } else {
            vibrator.vibrate(500);
        }
    }

    private void showIntruderNotification() {

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.ic_dialog_alert)
                        .setContentTitle("🚨 Aegis Alert")
                        .setContentText("Intruder detected!")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setAutoCancel(true);

        NotificationManagerCompat.from(this)
                .notify(1001, builder.build());
    }

    private void showSafeNotification() {

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("✅ Aegis")
                        .setContentText("Area is safe again")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);

        NotificationManagerCompat.from(this)
                .notify(1002, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Aegis Alerts",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("Intruder alerts");

            NotificationManager manager =
                    getSystemService(NotificationManager.class);

            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }
}
