package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;
    Socket socket;

    public Server() throws IOException {
        connect();
    }

    public void connect() throws IOException {

        serverSocket = new ServerSocket(1234);
        serverSocket.setReuseAddress(true);

        try {

            while (true) {

                socket = serverSocket.accept();
                System.out.println(serverSocket.getInetAddress().getHostAddress() + " connected");
                ClientHandler client = new ClientHandler(socket);

                new Thread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}