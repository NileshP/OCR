package com.infy.ocr;

import java.io.File;
import java.io.IOException;



import net.sourceforge.tess4j.*;

public class TesseractExample {

    public static void main(String[] args) throws IOException {
        File imageFile = new File("eurotext.png");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
