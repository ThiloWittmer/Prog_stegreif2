import java.awt.image.BufferedImage;

public class ThresholdFilter extends PixelFilter {

	public ThresholdFilter() {
		
	}

    @Override
    public int calculate(int pixelColor) {
       
    	int r = (pixelColor >> 16) & 0xFF;
    	int g = (pixelColor >> 8) & 0xFF;
    	int b = pixelColor >> 0xFF;
    	
    	pixelColor = 0;
    	
    	int average = (r + g + b) / 3;
    	
    	int threshold_white_black = 128;
    	int threshold_white = 64;
    	int threshold_grey = 128;
    	int threshold_black = 192;
    	
    	if (average >= threshold_white_black) {
    		average = 255; 
    	}else {
    		average = 0;
    	}
    	
    	
    	
    	
    	
    	
    	
        return 0;
    }
    
}
