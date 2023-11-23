package com.example.socket

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.BroadcastReceiver
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbDeviceConnection
import android.hardware.usb.UsbEndpoint
import android.hardware.usb.UsbInterface
import android.hardware.usb.UsbManager
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity : FlutterActivity() {
    private val CHANNEL = "usb_communication"
    private val ACTION_USB_PERMISSION = "com.example.socket.USB_PERMISSION" // Replace your_package_name

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL)
            .setMethodCallHandler { call, result ->
                if (call.method == "communicateWithUSB") {
                    communicateWithUSB(result)
                } else {
                    result.notImplemented()
                }
            }
    }


    private fun communicateWithUSB(result: MethodChannel.Result) {
        // USB communication logic
        val usbManager = getSystemService(Context.USB_SERVICE) as UsbManager
        val deviceList: Map<String, UsbDevice> = usbManager.deviceList

        for (device in deviceList.values) {
            println("Found USB device: ${device.deviceName}")
        }

        val device: UsbDevice = deviceList.values.firstOrNull() ?: run {
            result.error("NO_DEVICE", "No USB device found", null)
            return
        }

        // Continue with the rest of the logic...
    }
}
