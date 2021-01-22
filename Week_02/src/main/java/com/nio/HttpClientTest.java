package com.nio;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Copyright (C), 2021
 * FileName: HttpClientTest
 * Author:   xzw
 * Date:     2021/1/22 21:00
 * Description:
 */
public class HttpClientTest {
    private static final String URL = "http://localhost:8081";
    public static void main(String[] args) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(URL);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200){
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity,"utf-8");
                System.out.println("服务返回值："+result);
            }else {
                System.out.println(" 服务调用异常");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
