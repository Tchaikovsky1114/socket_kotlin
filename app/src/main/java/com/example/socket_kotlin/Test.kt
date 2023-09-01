package com.example.socket_kotlin

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {
    Thread {

            val port = 8080 //
            val server = ServerSocket(port) // low level.. listen.. blocking
            while (true){
                    val socket = server.accept()

                    // input -> output 일방통행
                    socket.getInputStream() // 클라이언트로부터 들어오는 스트림 == 클라이언트의 socket.outputStream
                    socket.getOutputStream() // 클라이언트에게 데이터를 내려주는 스트림 == 클라이언트의 socket.inputStream

                    // inputData는 read를 통해 버퍼로 읽어올 수 있음.
                    val reader = BufferedReader(InputStreamReader(socket.getInputStream()))

                    // 클라이언트로 내려주는 요청
                    val printer = PrintWriter(socket.getOutputStream())

                    var input: String? = "-1"

                    while (input != null && input != ""){
                            input = reader.readLine()
                    }

        //        Log.e("Server", "READ DATA $input")
                    println("Server READ DATA $input")

                    printer.println("HTTP/1.1 200 OK")
                    printer.println("Content-Type: text/html\r\n")
                    printer.println("<h1>Hello World!</h1>")
                    printer.println("\r\n")
                    printer.flush() // 잔여 버퍼 데이터 배출
                    printer.close()

                    reader.close()
                    socket.close()
            }



    }.start()

}