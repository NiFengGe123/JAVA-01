package com.study;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 2、作业
 * 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内
 * 容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件群里提供。
 *
 * Copyright (C), 2021
 * FileName: HelloClassLoader
 * Author:   xzw
 * Date:     2021/1/6 22:46
 * Description:
 */
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class  aClass = new HelloClassLoader().findClass("file:///F:/IDEA/project/geek-study/JAVA-01/Week_01/G20210579020308-20210106/src/resources/Hello.xlass");
            Method[] methods = aClass.getDeclaredMethods();
            Object object = aClass.newInstance();
            for (Method method:methods){
                method.invoke(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name){
        Path path ;
        byte[] bytes = null;
        try {
            path = Paths.get(new URI(name));
            bytes = Files.readAllBytes(path);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bytes == null || bytes.length <1){
            throw new RuntimeException("未读取到文件数据!!!");
        }
        for (int i= 0;i<bytes.length;i++){
            bytes[i] = (byte) (255-bytes[i]);
        }
        return defineClass("Hello",bytes,0,bytes.length);
    }
}
