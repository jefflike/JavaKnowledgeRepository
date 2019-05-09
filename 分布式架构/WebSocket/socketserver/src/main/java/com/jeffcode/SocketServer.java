package com.jeffcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: jefflike
 * @create: 2019/5/3
 * @describe:
 *  典型的BIO
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            Socket accept = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            System.out.println(bufferedReader.readLine());
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}
