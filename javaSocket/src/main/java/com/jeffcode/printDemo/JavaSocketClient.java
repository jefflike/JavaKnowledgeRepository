package com.jeffcode.printDemo;

import java.io.*;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaSocketClient {
    private static final String host = "127.0.0.1";
    private static final int port = 8080;

    // 引入slf4j，打印日志
    private static final Logger logger = LoggerFactory.getLogger(JavaSocketClient.class);
    public static void main(String[] args) throws IOException {
        // 创建socket对象
        Socket socket = new Socket(host, port);
        socket.setSoTimeout(3000);

        logger.info("客户端开始连接");
        logger.info("客户端ip：{}，客户端端口port:{}", socket.getLocalAddress(), socket.getLocalPort());
        logger.info("服务端ip：{}", socket.getInetAddress());

        try {
            send(socket);
        } catch (Exception e){
            logger.error("socket异常，客户端发送失败");
        } finally {
            socket.close();
        }

    }

    // 客户端发送消息的方法
    private static void send(Socket client) throws IOException {
        // 键盘输入流
        InputStream in = System.in;
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));

        // 获取socket的输出流，转换成打印流
        OutputStream outputStream = client.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        // 获取socket的输入流,可以获得服务端的流信息
        InputStream inputStream = client.getInputStream();
        BufferedReader socketbf = new BufferedReader(new InputStreamReader(inputStream));

        while (true) {
            // 读取键盘输入信息
            String s = bf.readLine();
            // 发送到服务器
            printStream.println(s);

            // 从服务器读数据
            String s1 = socketbf.readLine();

            if ("q".equals(s1)) {
                break;
            } else {
                logger.info("client say ：{}", s1);
            }
        }

        // 完事关闭服务端的输入输出流
        printStream.close();
        socketbf.close();
    }
}
