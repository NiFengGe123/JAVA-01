package com.nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Copyright (C), 2021
 * FileName: HttpServer01
 * Author:   xzw
 * Date:     2021/1/21 23:46
 * Description:
 */
public class HttpServer01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true){
                Socket socket = serverSocket.accept();
                sendResponse(socket);
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendResponse(Socket socket) throws Exception{
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("HTTP/1.1 200 OK");
        printWriter.println("Content-Type:text/html;charset=utf-8");
        String responseBody = "hello socket !";
        printWriter.println("Content-length:"+responseBody.getBytes().length);
        printWriter.println();
        printWriter.write(responseBody);
        printWriter.close();
    }
}
