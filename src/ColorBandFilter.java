/**
 * ColorBand-Filter.
 */

public class ColorBandFilter extends PixelFilter {
        private String color;

    public ColorBandFilter(String color) {
        this.color = color;
    }

    @Override
    public int calculate(int pixelColor) {

        int rot =(pixelColor >>16) & 0xff;
        int gruen =(pixelColor >>8) & 0xff;
        int blau =pixelColor & 0xff ;

        
        // Farbe ersetzen
        switch(color){
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
            }
        
        pixelColor = 0;
        
        pixelColor |=  (rot << 16);
        pixelColor |= (gruen << 8);
        pixelColor |= blau;
		return pixelColor;
    }
    
}
