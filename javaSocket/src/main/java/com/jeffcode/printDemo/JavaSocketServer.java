package com.jeffcode.printDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaSocketServer {
    private static final Logger logger = LoggerFactory.getLogger(JavaSocketServer.class);
    public static void main(String[] args) throws IOException {

        // 监听指定的端口
        int port = 8080;
        ServerSocket server = new ServerSocket(port);
        logger.info("服务端ip：{}，服务端端口port:{}", server.getInetAddress(), server.getLocalPort());

        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");
        while (true) {
            Socket socket = server.accept();
            // 客户端异步线程
            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();
        }

        
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        ClientHandler (Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            logger.info("新端ip：{}，服务端端口port:{}", socket.getInetAddress(), socket.getPort());

            try {
                // 获取socket的输出流，转换成打印流
                OutputStream outputStream = socket.getOutputStream();
                PrintStream printStream = new PrintStream(outputStream);

                // 获取socket的输入流,可以获得服务端的流信息
                InputStream inputStream = socket.getInputStream();
                BufferedReader socketbf = new BufferedReader(new InputStreamReader(inputStream));

                while (true) {

                    // 从服务器读数据
                    String s1 = socketbf.readLine();

                    if ("q".equals(s1)) {
                        break;
                    } else {
                        logger.info("client say ：{}", s1);
                        printStream.println("客户端传过来字数:"+ s1.length());
                    }
                }
                printStream.close();
                socketbf.close();

            } catch (Exception e) {
                logger.info("连接异常");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
