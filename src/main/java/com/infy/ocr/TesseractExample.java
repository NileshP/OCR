package com.infy.ocr;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.*;

public class TesseractExample {

    public static void main(String[] args) throws IOException {
        File imageFile = new File("picture2.png");
        
        BufferedImage bufferedImage = ImageIO.read(imageFile);
        
        BufferedImage newImage = bufferedImage.getSubimage(64, 280, 320-64 ,15);
                
        ImageIO.write(newImage, "png",new File("subimage2.png"));
        
        File imageFile2 = new File("subimage2.png");
        
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping

        try {
            String result = instance.doOCR(imageFile2);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
