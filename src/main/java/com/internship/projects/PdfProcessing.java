package com.internship.projects;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.io.File;
import java.io.IOException;

public class PdfProcessing
{
    public static void addSignatureToPdf(String pdfFilePath, String imagePathName)
    {
        try {

            PDDocument document = new PDDocument();

            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            PDImageXObject image = PDImageXObject.createFromFile(imagePathName, document);

            contentStream.drawImage(image, 40, 600);
            contentStream.close();


            try {
                File file = new File(pdfFilePath);

                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
                document.save(pdfFilePath);
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            document.close();

            System.out.println("PDF with image created successfully.");


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
