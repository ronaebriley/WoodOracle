package controller;
//package pdfbox;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.IOException;
//import org.apache.pdfbox.pdmodel;

//pdfbox

/**
 * @author Ronae Briley
 *
 */

public class HardwoodSeller extends model.WoodItem {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        model.WoodItem wood = new model.WoodItem();
        //Creating PDF document object
        //PDDocument document = new PDDocument();

        //Saving the document
        //document.save("C:/PdfBox_Examples/my_doc.pdf");

        //https://pdfbox.apache.org/1.8/cookbook/documentcreation.html
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage( page );
        System.out.println("PDF created");
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.showText("Hello World");
        wood.getType();
        wood.getDaseDeliveryTime();
        wood.getPrice();
        contentStream.endText();
        contentStream.close();


        //Closing the document
        //document.close();

    }

    /**
    * Method for reading the input file to be processed by the Hardwood Seller
     **/
    public void readInputFile(String inputFilePath){
        try {
            model.WoodItem wood = new model.WoodItem();
            //File file = new File("woodInvoice_" + wood.getInvoiceID() + ".txt");
            //https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
            File file = new File("info.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Method that computes the delivery ETA
     **/
    public Double deliveryTime() {
        Double deliveryETA = 0.0;
        model.WoodItem wood = new model.WoodItem();
        wood.getType();
        if (wood.getType() == "Cherry") {
            deliveryETA = 2.5 * wood.getDaseDeliveryTime();
        } else if (wood.getType() == "Curly Maple") {
            deliveryETA = 1.5 * wood.getDaseDeliveryTime();
        } else if (wood.getType() == "Genuine Mahogany") {
            deliveryETA = 3.0 * wood.getDaseDeliveryTime();
        } else if (wood.getType() == "Wenge") {
            deliveryETA = 5.0 * wood.getDaseDeliveryTime();
        } else if (wood.getType() == "White Oak") {
            deliveryETA = 2.3 * wood.getDaseDeliveryTime();
        } else if (wood.getType() == "Sawdust") {
            deliveryETA = 1.0 * wood.getDaseDeliveryTime();
        } else {
            deliveryETA = 0.0;
        }
        return deliveryETA;
    }

}