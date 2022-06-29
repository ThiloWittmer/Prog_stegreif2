
public class ContrastFilter extends PixelFilter{
	private float value;
	
	public ContrastFilter(float value) {
		this.value = value;
	}

	@Override
	public int calculate(int pixelColor) {
		
		int r = (pixelColor >> 16) & 0xFF;
    	int g = (pixelColor >> 8) & 0xFF;
    	int b = pixelColor & 0xFF;
    	
    	r = Math.round(value * (r - 128) + 128);
    	g = Math.round(value * (g - 128) + 128);
    	b = Math.round(value * (b - 128) + 128);
    	
    	r = Math.max(r, 0);
    	g = Math.max(g, 0);
    	b = Math.max(b, 0);
    	
    	r = Math.min(r, 255);
    	g = Math.min(g, 255);
    	b = Math.min(b, 255);
    	
    	pixelColor = 0;
    	
    	pixelColor |= r << 16;
    	pixelColor |= g << 8;
    	pixelColor |= b;
    	
    	return pixelColor;
	}
	
}
