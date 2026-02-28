# AEGIS
AEGIS is a wearable-based personal safety system designed to provide immediate assistance during emergency situations.
The system consists of an ESP32-powered wearable device connected to a mobile application via Bluetooth. When the user activates panic mode, the wearable instantly communicates with the mobile app, triggering emergency protocols and alerting trusted contacts.

Team Name: [Error 404]

Team Members

Member 1: [Francisa Thankachan] - [Govt. Model Engineering College, Thrikkakkara]

Member 2: [Annada S] - [Govt. Model Engineering College, Thrikkakkara]

# Hosted Project Link
[mention your project hosted link here]

# Project Description
AEGIS is a smart wearable safety system that connects an ESP32-based device to a mobile application via Bluetooth. With a dedicated panic trigger, the system allows users to instantly activate emergency protocols and notify trusted contacts during critical situations.  
The wearable includes a simple arm-and-trigger mechanism along with visual and audio indicators for system status. Designed for reliability and quick response, AEGIS combines embedded hardware and mobile technology to create a practical personal safety solution.

# The Problem statement
In emergency situations, individuals often struggle to quickly alert trusted contacts or seek help due to panic, physical restraint, or limited access to their phones. Existing safety solutions may be slow, complex, or dependent on manually operating a mobile device during high-stress moments.  
There is a need for a reliable, fast, and easy-to-use personal safety system that allows users to trigger emergency alerts instantly through a dedicated wearable device, ensuring immediate communication and support when it matters most.

# The Solution
AEGIS addresses this problem by introducing a smart wearable safety device integrated with a mobile application through Bluetooth connectivity. The system allows users to activate emergency protocols instantly using a dedicated panic trigger on the wearable, eliminating the need to manually operate a phone during stressful situations.  
Once activated, the mobile application immediately executes predefined alert mechanisms to notify trusted contacts. The device also provides clear visual and audio feedback, ensuring the user is aware of the system’s status at all times.  
By combining embedded hardware and mobile technology, AEGIS delivers a fast, reliable, and user-friendly personal safety solution designed for real-world emergency scenarios.

# Technical Details
Technologies/Components Used

For Software:  
Languages used: Java  
Frameworks used: Android SDK  
Libraries used:   
Bluetooth API (android.bluetooth) – For ESP32 communication  
LocationManager API – For GPS location retrieval   
SmsManager – For sending emergency SMS  
NotificationCompat – For intruder & safe alerts  
Vibrator API – For alert vibration    
Tools used: VS CODE, GITHUB, ANDROID STUDIO  

For Hardware:  
Main components: ESP32, HC-SR04, RGB, BUZZER
Specifications: [Technical specifications]  
Tools required: [List tools needed]

# Features
List the key features of your project:

Feature 1: Instant Panic Activation: A dedicated hardware panic trigger allows users to activate emergency protocols immediately with a single press.  
Feature 2: Bluetooth-Based Wearable Integration: Seamless wireless communication between the ESP32 wearable and the mobile application ensures fast and reliable signal transmission.  
Feature 3: Trusted Contact Notification System: Upon activation, the system automatically alerts pre-configured trusted contacts to ensure rapid assistance.  
Feature 4: Real-Time System Status Indicators: Built-in visual (RGB LEDs) and audio indicators provide clear feedback on whether the device is disarmed, armed, or in panic mode.

# Implementation
For Software:
Installation
[Installation commands - e.g., npm install, pip install -r requirements.txt]
Run
[Run commands - e.g., npm start, python app.py]

For Hardware:

Components Required

-ESP 32
-Resistors
-LED
-HRO4 Sensor
-Switch
-Press Button
-Buzzer
-Resistors
-Connecting Wires and Breadboard

Circuit Setup  
The circuit is set up by connecting the ESP32 microcontroller, the HC-SR04 ultrasonic sensor, and a buzzer on a breadboard using jumper wires. First, the HC-SR04 sensor is powered by connecting its VCC pin to the 5V pin of the ESP32 and its GND pin to the ESP32 ground. The Trig pin of the sensor is connected to a digital output pin of the ESP32 (for example, GPIO 5), and the Echo pin is connected to a digital input pin (such as GPIO 18). Since the Echo pin outputs 5V and the ESP32 operates at 3.3V logic, a voltage divider using resistors is recommended between the Echo pin and the ESP32 input pin to protect the board. The buzzer is connected by attaching its positive terminal to another digital GPIO pin (for example, GPIO 23) and its negative terminal to ground. Once powered through a USB cable, the ESP32 sends trigger pulses to the ultrasonic sensor, calculates the distance based on the returning echo signal, and activates the buzzer or sends alerts via Bluetooth if an object is detected within a predefined range.

Project Documentation
For Software:
Screenshots (Add at least 3)
![Screenshot1](Add screenshot 1 here with proper name) Add caption explaining what this shows

![Screenshot2](Add screenshot 2 here with proper name) Add caption explaining what this shows

![Screenshot3](Add screenshot 3 here with proper name) Add caption explaining what this shows

Diagrams
System Architecture:

Architecture Diagram Explain your system architecture - components, data flow, tech stack interaction

Application Workflow:

Workflow Add caption explaining your workflow

For Hardware:
Schematic & Circuit
![Circuit](Add your circuit diagram here) Add caption explaining connections

![Schematic](Add your schematic diagram here) Add caption explaining the schematic

Build Photos
![Team](Add photo of your team here)

![Components](Add photo of your components here) List out all components shown

![Build](Add photos of build process here) Explain the build steps

![Final](Add photo of final product here) Explain the final build


For Mobile Apps:
App Flow Diagram
App Flow Explain the user flow through your application

Installation Guide
For Android (APK):
Download the APK from [Release Link]
Enable "Install from Unknown Sources" in your device settings:
Go to Settings > Security
Enable "Unknown Sources"
Open the downloaded APK file
Follow the installation prompts
Open the app and enjoy!
For iOS (IPA) - TestFlight:

Download TestFlight from the App Store
Open this TestFlight link: [Your TestFlight Link]
Click "Install" or "Accept"
Wait for the app to install
Open the app from your home screen
Building from Source:

# For Android
flutter build apk
# or
./gradlew assembleDebug

# For iOS
flutter build ios
# or
xcodebuild -workspace App.xcworkspace -scheme App -configuration Debug
For Hardware Projects:
Bill of Materials (BOM)
Component	Quantity	Specifications	Price	Link/Source
Arduino Uno	1	ATmega328P, 16MHz	₹450	[Link]
LED	5	Red, 5mm, 20mA	₹5 each	[Link]
Resistor	5	220Ω, 1/4W	₹1 each	[Link]
Breadboard	1	830 points	₹100	[Link]
Jumper Wires	20	Male-to-Male	₹50	[Link]
[Add more...]				
Total Estimated Cost: ₹[Amount]

Assembly Instructions
Step 1: Prepare Components

Gather all components listed in the BOM
Check component specifications
Prepare your workspace Step 1 Caption: All components laid out
Step 2: Build the Power Supply

Connect the power rails on the breadboard
Connect Arduino 5V to breadboard positive rail
Connect Arduino GND to breadboard negative rail Step 2 Caption: Power connections completed
Step 3: Add Components

Place LEDs on breadboard
Connect resistors in series with LEDs
Connect LED cathodes to GND
Connect LED anodes to Arduino digital pins (2-6) Step 3 Caption: LED circuit assembled
Step 4: [Continue for all steps...]

Final Assembly: Final Build Caption: Completed project ready for testing

For Scripts/CLI Tools:
Command Reference
Basic Usage:

python script.py [options] [arguments]
Available Commands:

command1 [args] - Description of what command1 does
command2 [args] - Description of what command2 does
command3 [args] - Description of what command3 does
Options:

-h, --help - Show help message and exit
-v, --verbose - Enable verbose output
-o, --output FILE - Specify output file path
-c, --config FILE - Specify configuration file
--version - Show version information
Examples:

# Example 1: Basic usage
python script.py input.txt

# Example 2: With verbose output
python script.py -v input.txt

# Example 3: Specify output file
python script.py -o output.txt input.txt

# Example 4: Using configuration
python script.py -c config.json --verbose input.txt
Demo Output
Example 1: Basic Processing

Input:

This is a sample input file
with multiple lines of text
for demonstration purposes
Command:

python script.py sample.txt
Output:

Processing: sample.txt
Lines processed: 3
Characters counted: 86
Status: Success
Output saved to: output.txt
Example 2: Advanced Usage

Input:

{
  "name": "test",
  "value": 123
}
Command:

python script.py -v --format json data.json
Output:

[VERBOSE] Loading configuration...
[VERBOSE] Parsing JSON input...
[VERBOSE] Processing data...
{
  "status": "success",
  "processed": true,
  "result": {
    "name": "test",
    "value": 123,
    "timestamp": "2024-02-07T10:30:00"
  }
}
[VERBOSE] Operation completed in 0.23s
Project Demo
Video
[Add your demo video link here - YouTube, Google Drive, etc.]

