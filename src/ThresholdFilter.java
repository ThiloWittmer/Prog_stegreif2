import java.awt.image.BufferedImage;

public class ThresholdFilter extends PixelFilter {
	
	protected int schwellwert;

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
    		average = 255; 
    	}else {
    		average = 0;
    	}
    	
    	
    	pixelColor |= average << 16;
    	pixelColor |= average << 8;
    	pixelColor |= average;
    	
    	
        return pixelColor;
    }
    
}
