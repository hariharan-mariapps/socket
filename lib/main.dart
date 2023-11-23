import 'package:libserialport/libserialport.dart';
import 'package:flutter/material.dart';


void main() => runApp(MyApp());


class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  // final port = SerialPort('/dev/cu.usbmodemRZCW819R6PK2');
  @override
  Widget build(BuildContext context) {
    print("Available ports ${SerialPort.availablePorts}");
    return Scaffold(
      appBar: AppBar(),
      body: Center(
        child: Text("Click me"),
      ),
    );
  }
}

