import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
 * Oberklasse für Filter
 * 
 * Methoden:
 * 
 * process-Methode 
 *      Methode mit variabler Parameteranzahl
 *      BufferedImage Java Klasse zur Bildberechnung
 *      
 * 
 */

public interface Filter {

}



public BufferedImage process(BufferedImage ... image){

    //Bilder laden/speichern

    BufferedImage image = null;

    try {
        image = ImageIO-read(new File("input_image.bmp"));

        ImageIO.write(image, "bmp", new File("output_image.bmp"));
    } catch (IOException e){
        //TODO Auto-generated
        e.printStackTrace();
    }
    
    
    //Beispiel wie man gesichert auf die Parameter zugreifen kann
    BufferedImage image1, image2;               //img1 = Bild img2= Maske

    image1 = (image.length > 0) ? image[0] : null;     
    image2 = (image.length > 1) ? image[1] : null;


}

public BufferdImage calculate(int pixelColor){

}