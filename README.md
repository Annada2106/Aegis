# 🛡️ AEGIS

AEGIS is a wearable-based personal safety system designed to provide immediate assistance during emergency situations. The system consists of an ESP32-powered wearable device connected to a mobile application via Bluetooth. When the user activates panic mode, the wearable instantly communicates with the mobile app, triggering emergency protocols and alerting trusted contacts.

---

## 👥 Team Information

**Team Name:** Error 404  

**Member 1:** Francisa Thankachan – Govt. Model Engineering College, Thrikkakkara  
**Member 2:** Annada S – Govt. Model Engineering College, Thrikkakkara  

---

## 📌 Project Description

AEGIS is a smart wearable safety system that connects an ESP32-based device to a mobile application via Bluetooth. With a dedicated panic trigger, the system allows users to instantly activate emergency protocols and notify trusted contacts during critical situations.

The wearable includes an arm-and-trigger mechanism along with visual and audio indicators for system status. Designed for reliability and quick response, AEGIS combines embedded hardware and mobile technology to create a practical personal safety solution.

---

## ❗ Problem Statement

In emergency situations, individuals often struggle to quickly alert trusted contacts or seek help due to panic, physical restraint, or limited access to their phones. Existing safety solutions may be slow, complex, or dependent on manually operating a mobile device during high-stress moments.

There is a need for a reliable, fast, and easy-to-use personal safety system that allows users to trigger emergency alerts instantly through a dedicated wearable device.

---

## 💡 Solution

AEGIS introduces a smart wearable safety device integrated with a mobile application through Bluetooth connectivity.

- Instant panic trigger on wearable
- No need to unlock or operate phone manually
- Immediate alert execution via mobile app
- Visual and audio status feedback
- Fast and reliable emergency response mechanism

---

# ⚙️ Technical Details

## 🖥️ Software

**Language:** Java  
**Framework:** Android SDK  

### Libraries Used
- `android.bluetooth` – ESP32 communication  
- `LocationManager` – GPS retrieval  
- `SmsManager` – Emergency SMS  
- `NotificationCompat` – Alerts  
- `Vibrator API` – Vibration feedback  

### Tools Used
- Android Studio  
- VS Code  
- GitHub  

---

## 🔌 Hardware

### Main Components
- ESP32  
- HC-SR04 Ultrasonic Sensor  
- RGB LED  
- Buzzer  
- Push Button  
- Switch  
- Resistors  
- Breadboard & Jumper Wires  

### Specifications
- **ESP32:** 240 MHz dual-core, 3.3V logic, built-in Bluetooth  
- **HC-SR04:** 2–400 cm detection range, 5V operation  
- **RGB LED:** Common cathode  
- **Buzzer:** 3.3V/5V active buzzer  

---

# ✨ Features

- 🔴 **Instant Panic Activation** – One press emergency trigger  
- 📶 **Bluetooth Wearable Integration** – Real-time ESP32 to Android communication  
- 📍 **Trusted Contact Alerts** – Automatic SMS notification  
- 🔔 **Real-Time Indicators** – RGB LED + buzzer status feedback  

---

# 🛠️ Implementation

## 📱 Software Setup

### Installation
1. Clone the repository:
```bash
git clone https://github.com/Annada2106/Aegis.git
```
###Project Documentation
##For Software:
Screenshots  
<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/9737a1cd-d712-4495-82d7-817e7e14d495" />  
Panic Mode Activation Screen – Displays a clear visual confirmation when the emergency trigger is activated, indicating that AEGIS has successfully entered panic mode and initiated alert protocols.  
<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/2094a9b1-9a11-4b2a-9095-8956972a7f7b" />  
Notification panel displaying intruder detection alert followed by a confirmation message indicating the area is safe.  
<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/a9878ba5-d340-4baa-a8e7-88939c8e132a" />
Intruder Alert screen showing real-time detection notification with timestamp confirmation.

#Diagrams
System Architecture:
<img width="1024" height="559" alt="image" src="https://github.com/user-attachments/assets/fd5fba46-4bdb-48d7-be6d-53bc678369f3" />

##For Hardware:
Schematic & Circuit
<img width="1024" height="559" alt="image" src="https://github.com/user-attachments/assets/658b0d21-5aab-4ef3-81d0-0c7dd807edb0" />

###Build Photos
<img width="1600" height="900" alt="image" src="https://github.com/user-attachments/assets/639b2002-766a-4194-9fc8-dfd500410973" />
<img width="1600" height="900" alt="image" src="https://github.com/user-attachments/assets/e43f12c3-8f95-46ed-9af0-516b234f7bfd" />

##DEMO VIDEO LINK

https://drive.google.com/drive/folders/1xXoBWmGMHk5pMfjwYbx8jIeCzp8Mgykw 