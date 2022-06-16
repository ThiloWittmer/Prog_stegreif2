
public class ThresholdFilter extends PixelFilter {
	
	private int schwellwert;
	private final int SCHWARZ = 0;
	private final int WEISS = 255;

	public ThresholdFilter(int wert) {
		this.schwellwert = wert;
	}

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
