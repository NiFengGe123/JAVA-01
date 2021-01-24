package com.nio.work3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (C), 2021
 * FileName: Httpserver02
 * Author:   xzw
 * Date:     2021/1/24 23:34
 * Description:
 */
public class Httpserver02 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        try {
            ServerSocket serverSocket = new ServerSocket(8084);
            while (true) {
                Socket socket = serverSocket.accept();
                service.execute(() -> sendResponse(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendResponse(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            String content = "这是从第 二个socket服务器返回的响应值！";
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-length:" + content.getBytes("utf-8").length);
            printWriter.println("Content-Type:text/html;charset=utf-8");
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
