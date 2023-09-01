package com.example.socket_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.HttpURLConnection
import java.net.ServerSocket
import java.net.Socket
import java.net.URL
import java.net.URLConnection

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // myip: ifconfig:: 192.168.0.86

        Thread {
            val socket = Socket("10.0.0.2", 8080)
            val printer = PrintWriter(socket.getOutputStream())
            var reader = BufferedReader(InputStreamReader(socket.getInputStream()))

        }.start()


    }
}