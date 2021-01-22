package com.nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Copyright (C), 2021
 * FileName: HttpServer03
 * Author:   xzw
 * Date:     2021/1/22 20:36
 * Description:
 */
public class HttpServer03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8082);
            while (true){
                Socket socket = serverSocket.accept();
                new Thread(()-> sendResponse(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendResponse(Socket socket){
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello socket 3 !";
            printWriter.println("content-length:"+body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
