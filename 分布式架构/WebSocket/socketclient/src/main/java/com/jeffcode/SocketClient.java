package com.jeffcode;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jefflike
 * @create: 2019/5/4
 * @describe:
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.print("i am jefflike");
        writer.close();
        socket.close();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
