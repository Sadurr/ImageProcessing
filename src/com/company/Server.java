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

//    public void send() throws IOException {
//        outputStream = socket.getOutputStream();
//        bufferedOutputStream = new BufferedOutputStream(outputStream);
//        graphics = bufferedImage.createGraphics();
//        graphics.drawImage(bufferedImage,0,0,null);
//        graphics.dispose();
//
//        ImageIO.write(bufferedImage,"jpg",bufferedOutputStream);
//        bufferedOutputStream.close();
//        socket.close();
//    }

}




































//    ArrayList<BufferedImage> bufferedImages = new ArrayList<>();
//    ImageProcessing imageProcessing;
//    BufferedImage bufferedImage= null;
//    //int height, width;
//    ServerSocket serverSocket;
//    Socket socket;
//
//
//    public Server() throws IOException {
//        connect();
//      //  height = imageProcessing.getHeight();
//      //  width = imageProcessing.getWidth();
//        makeFrame();
//    }
//
//    public void makeFrame() throws IOException {
//        JFrame frame = new JFrame("Server");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300, 500);
//
////        JLabel textLabel = new JLabel("Waiting...");
////        frame.add(textLabel, BorderLayout.SOUTH);
//
//
//        JLabel imageLabel = new JLabel(new ImageIcon(bufferedImage));
//       // textLabel.setText("Image recieved");
//        frame.add(imageLabel,BorderLayout.CENTER);
//        frame.setVisible(true);
//
//        InputStream inputStream = socket.getInputStream();
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//        BufferedImage bufferedImage = ImageIO.read(bufferedInputStream);
//        bufferedInputStream.close();
//        socket.close();
//    }
//
//    public void connect() throws IOException {
//
//         serverSocket = new ServerSocket(1234);
//         socket = serverSocket.accept();
//        System.out.println("Connected to client");
//
//
//
////        while(bufferedInputStream.read()!=-1) {
////            System.out.println("-");
////        } //-1 oznacza ze nic nie przychodzi
////        Image image = imageProcessing.image;
//
//
//
//       // ImageProcessing imageProcessing = new ImageProcessing(bufferedImage);
//
//    }
