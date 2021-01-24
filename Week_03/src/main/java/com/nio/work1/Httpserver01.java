package com.nio.work1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Copyright (C), 2021
 * FileName: Httpserver01
 * Author:   xzw
 * Date:     2021/1/24 18:09
 * Description:
 */
public class Httpserver01 {
    private static final int PORT = 8081;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                sendResponse(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendResponse(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            String content = "这是从第一个socket服务器返回的响应值！";
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            printWriter.println("Content-length:" + content.getBytes("utf-8").length);
            printWriter.println();
            printWriter.write(content);
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
