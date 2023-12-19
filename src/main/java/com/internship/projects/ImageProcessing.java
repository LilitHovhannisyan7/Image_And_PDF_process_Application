package com.internship.projects;
import ij.process.ImageProcessor;
import java.awt.Color;
import java.awt.Font;

public class ImageProcessing
{
    public static void overlaySignature(ImageProcessor processor, String signature)
    {

        Font font = new Font("Arial", Font.BOLD, 30);
        Color color = Color.BLACK;

        processor.setFont(font);
        processor.setColor(color);

        int x = 69;
        int y = processor.getHeight() - 70;

        processor.drawString(signature, x, y);
    }
}