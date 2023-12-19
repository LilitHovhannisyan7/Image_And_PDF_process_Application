package com.internship.projects;
import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter short signature (2 or 3 characters): ");
        String signature = scanner.nextLine();
        System.out.print("Enter the location of the PDF file: ");
        String pdfFilePath = scanner.nextLine();


        ImagePlus image = IJ.openImage("src/main/resources/stamp2.png");
        ImageProcessor processor = image.getProcessor();
        ImageProcessing.overlaySignature(processor, signature);

        String imagePath = "src/main/resources/temp.png";
        IJ.save(image, imagePath);

        PdfProcessing.addSignatureToPdf(pdfFilePath, imagePath);
        System.out.println("Processing completed successfully.");

    }
}