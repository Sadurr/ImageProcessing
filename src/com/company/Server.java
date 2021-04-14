package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    //add multi-threading

    JFrame frame;
    JLabel textLabel;

    ServerSocket serverSocket;
    Socket socket;

    InputStream inputStream;
    BufferedInputStream bufferedInputStream;
    BufferedImage bufferedImage;

    JLabel imageLabel;
    ImageProcessing imageProcessing;

    OutputStream outputStream;
    BufferedOutputStream bufferedOutputStream;
    Image image;
    BufferedImage sendBufferedImage;
    Graphics graphics;

    public Server() throws IOException {
        makeFrame();
        connect();
        process();
        //send();
    }

    public void makeFrame() {

        frame = new JFrame("SERVER");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);

        textLabel = new JLabel("Waiting...");
        frame.add(textLabel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void connect() throws IOException {

        serverSocket = new ServerSocket(1234);
        socket = serverSocket.accept();

        inputStream = socket.getInputStream();
        bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedImage = ImageIO.read(bufferedInputStream);
        bufferedInputStream.close();
        socket.close();

        JLabel imageLabel = new JLabel(new ImageIcon(bufferedImage));
        textLabel.setText("Image recieved");
        frame.add(imageLabel, BorderLayout.CENTER);
    }

    public void process()  {
        ImageProcessing x = new ImageProcessing(bufferedImage);
        x.greenSaturation();
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
