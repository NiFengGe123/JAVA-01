package com.nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (C), 2021
 * FileName: HttpServer02
 * Author:   xzw
 * Date:     2021/1/22 20:11
 * Description:
 */
public class HttpServer02 {
    public static void main(String[] args) {
        try {
            ExecutorService service = Executors.newFixedThreadPool(40);
            ServerSocket serverSocket = new ServerSocket(8081);
            while (true){
                Socket socket = serverSocket.accept();
                service.execute(()-> sendResponse(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendResponse(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("HTTP/1.1 200 Ok");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String content = " hello socket 2 哈哈哈哈 !";
            printWriter.println("Content-length:"+content.getBytes().length);
            printWriter.println();
            printWriter.write(content);
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
