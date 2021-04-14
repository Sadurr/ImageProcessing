package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable  {

    JFrame frame = new JFrame();
    JLabel textLabel = new JLabel();

    Socket socket;

    InputStream inputStream;
    BufferedInputStream bufferedInputStream;
    BufferedImage bufferedImage;

    public ClientHandler(Socket socket) {

     this.socket = socket;
    }

    @Override
    public void run() {

        try {
            frame = new JFrame("SERVER");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 500);

            textLabel = new JLabel("Waiting...");
            frame.add(textLabel, BorderLayout.SOUTH);
            frame.setVisible(true);

            inputStream = socket.getInputStream();
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedImage = ImageIO.read(bufferedInputStream);
            bufferedInputStream.close();
            socket.close();

            JLabel imageLabel = new JLabel(new ImageIcon(bufferedImage));
            textLabel.setText("Image recieved");
            frame.add(imageLabel, BorderLayout.CENTER);

            ImageProcessing x = new ImageProcessing(bufferedImage);
            x.greenSaturation();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}