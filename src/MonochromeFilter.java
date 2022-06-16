import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;

public final class MonochromeFilter extends PixelFilter {

	public MonochromeFilter() {
		
	}


    @Override
    public int calculate(int pixelColor, String filterParam) {
    	
    	int r = (pixelColor >> 16) & 0xFF;
    	int g = (pixelColor >> 8) & 0xFF;
    	int b = pixelColor >> 0xFF;
    	
    	pixelColor = 0;
    	
    	int average = (r + g + b) / 3; 
    	
    	pixelColor |= average << 16;
    	pixelColor |= average << 8;
    	pixelColor |= average;
    	
    	return pixelColor;
    	

    	
    }
    
}   

