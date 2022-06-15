import java.awt.Color;
import java.io.IOException;

public class ColorReplacementFilter extends PixelFilter {
	private Color col1 = null;
	private Color col2 = null;
	private int c1 = 0;
	private int c2 = 0;
	
	public ColorReplacementFilter(Color col1, Color col2) {
		this.col1 = col1;
		this.col2 = col2;
	}
	public ColorReplacementFilter(int c1, int c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	public ColorReplacementFilter(Color col1) {
		this.col1 = col1;
		float r = (float) Math.random();
		float g = (float) Math.random();
		float b = (float) Math.random();
		this.col2 = new Color(r, g, b);
	}
	public ColorReplacementFilter(int c1) {
		this(new Color(c1));
	}
	
    @Override
    public int calculate(int pixelColor) throws IOException {
		if (col1 == null && c1 == 0) {
			throw new IOException("no color set");
		}
		if (col1.getRGB() == pixelColor) {
			return col2.getRGB();
		} else if (c1 == pixelColor) {
			return c2;
		} else return pixelColor;
	}
}
