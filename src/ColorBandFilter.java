import java.awt.image.BufferedImage;

public class ColorBandFilter extends PixelFilter {

    @Override
    public int calculate(int pixelColor,String filterParam ) {
        int dSchnitt;

        int rot =(pixelColor >>16) & 0xff;
        int gruen =(pixelColor >>8) & 0xff;
        int blau =pixelColor & 0xff ;

       dSchnitt = (rot+gruen+blau) /3;

        switch(filterParam){
            case "RED":
                gruen = 0;
                blau = 0;
                break;
            case "BLUE":
                rot = 0;
                gruen = 0;
                break;
            case "GREEN":
                rot = 0;
                blau = 0;
                break;
            }
        
        pixelColor =  (rot << 16) | (gruen << 8) | blau;
		return pixelColor;
    }
    
}
