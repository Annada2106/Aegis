import 'package:flutter/material.dart';
import 'package:supabase_flutter/supabase_flutter.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();

  await Supabase.initialize(
    url: 'https://dmlnkznjoaihzgotgvyv.supabase.co',
    anonKey: 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImRtbG5rem5qb2FpaHpnb3Rndnl2Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzIyMTIyMjksImV4cCI6MjA4Nzc4ODIyOX0.MKDvSqxV3vvkA9Lq1Cv8DKMrVSv5nXbNgrKVepajIas',
  );

  runApp(const THH4App());
}
class THH4App extends StatelessWidget {
  const THH4App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'THH4',
      theme: ThemeData(
        primarySwatch: Colors.pink,
      ),
      home: const HomeScreen(),
    );
  }
}

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("THH4 Safety System"),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            print("Emergency Triggered");
          },
          child: const Text("TRIGGER EMERGENCY"),
        ),
      ),
    );
  }
}