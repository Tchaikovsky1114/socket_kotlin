package com.example.socket_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val port = 8080
        val server = ServerSocket(port) // listen.. blocking

        val socket = server.accept()



        // input -> output 일방통행
        socket.getInputStream() // 클라이언트로부터 들어오는 스트림 == 클라이언트의 socket.outputStream
        socket.getOutputStream() // 클라이언트에게 데이터를 내려주는 스트림 == 클라이언트의 socket.inputStream

        // inputData는 read를 통해 버퍼로 읽어올 수 있음.

        val reader = BufferedReader(InputStreamReader(socket.getInputStream()))

        val printer = PrintWriter(socket.getOutputStream())

        var input: String = ""
        input = reader.readLine()




    }
}