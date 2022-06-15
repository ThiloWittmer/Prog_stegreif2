import java.awt.Color;
import java.awt.image.BufferedImage;

public class ColorReplacmentFilter extends PixelFilter{
	private Color col1 = null;
	private Color col2 = null;
	private int c1 = 0;
	private int c2 = 0;
	
	public ColorReplacmentFilter(Color col1, Color col2) {
		this.col1 = col1;
		this.col2 = col2;
	}
	public ColorReplacmentFilter(int c1, int c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	public ColorReplacmentFilter(Color col1) {
		this.col1 = col1;
		int r = (int) (Math.random() * 10);
		int g = (int) (Math.random() * 10);
		int b = (int) (Math.random() * 10);
		this.col2 = new Color(r, g, b);
		
	}
	public ColorReplacmentFilter(int c1) {
		this.c1 = c1;
	}
	
    @Override
    public int calculate(int pixelColor) {
   	
        int b = pixelColor & 0xFF;
        

    }
    
}
