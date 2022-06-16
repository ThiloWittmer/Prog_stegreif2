
public class ThresholdFilter extends PixelFilter {
	
	/***
	 * @param schwellwert = definiert ab wann die Pixel in weiß und schwarz unterschiden werden
	 * @ SCHWARZ = Integer Zahlenwert für schwarz
	 * @ WEISS = Integer Zahlenwert für weiss
	 */
	private int schwellwert;
	private final int SCHWARZ = 0;
	private final int WEISS = 255;

	/***
	 * 
	 * @param wert = Konstruktor für Filter mit Uebergabe des Schwellwertes
	 */
	public ThresholdFilter(int wert) {
		this.schwellwert = wert;
	}

	/***
	 * Methode calculate Threshold
	 * @param pixelColor Bekommt von PixelFilter immer einen Pixel übergeben
	 *  
	 * Berrechnet anhand von der Helligkeit des Pixels ob dieser schwarz oder weiß wird
	 * 
	 */
    @Override
    public int calculate(int pixelColor) {
       
    	int r = (pixelColor >> 16) & 0xFF;
    	int g = (pixelColor >> 8) & 0xFF;
    	int b = pixelColor >> 0xFF;
    	
    	pixelColor = 0;
    	
    	int average = (r + g + b) / 3;
    	

    	if (average >= schwellwert) {
    		average = WEISS; 
    	}else {
    		average = SCHWARZ;
    	}
    	
    	
    	pixelColor |= average << 16;
    	pixelColor |= average << 8;
    	pixelColor |= average;
    	
    	
        return pixelColor;
    }
    
}
