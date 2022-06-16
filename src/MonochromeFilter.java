
public final class MonochromeFilter extends PixelFilter {

    @Override
    public int calculate(int pixelColor) {
    	
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

