package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImageProcessing {

    BufferedImage image;
    WritableRaster raster;

    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ImageProcessing(BufferedImage image) {
        this.image = image;
        raster = image.getRaster();
        height = image.getHeight();
        width = image.getWidth();
    }

    public void save(String type, String filename) throws IOException {
        ImageIO.write(image, type, new File(filename));
    }

    public void redSaturation() {
        for(int i = 0; i < height; i++) {
            for(int j=0; j < width; j++) {
                int rgb = image.getRGB(j,i); //int zapisywany na 32bitach
                image.setRGB(j,i,((rgb >> 16) << 16));
            }
        }
    }

    public void greenSaturation() {
        for(int i=0; i < height; i++) {
            for(int j=0; j < width; j++) {
                int rgb = image.getRGB(j,i);
                image.setRGB(j,i,(rgb >> 8) << 8);
            }
        }
    }

    public void blueSaturation() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int rgb = image.getRGB(j, i);
                //0xff usuwa(gasi) wartosci na pozostalych bitach, zostawie tylko na ostatnim
                image.setRGB(j, i, (rgb & 0xff));
            }
        }
    }
}