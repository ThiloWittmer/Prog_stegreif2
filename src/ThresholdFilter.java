import java.awt.image.BufferedImage;

public class ThresholdFilter extends PixelFilter {

    public int calculate(int pixelColor) {

        int rot =(pixelColor >>16) & 0xff;
        int gruen =(pixelColor >>8) & 0xff;
        int blau =pixelColor & 0xff ;
    
        int Grautoene = (rot + gruen + blau) / 3; //für die reduzierung der Helligkeit
         
        int Graustufe= 128;

            if(Grautoene>= Graustufe){
                Grautoene=255;
            }else{
                Grautoene=0;
            }
            pixelColor = 0;
            
            pixelColor |=  (Grautoene << 16);
            pixelColor |= (Grautoene << 8);
            pixelColor |= Grautoene;
            return pixelColor;
    
    
        }
    
}
