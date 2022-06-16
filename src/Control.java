import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MonochromeFilter test = new MonochromeFilter();
		
		BufferedImage  img = null;
		
		try {
			img = ImageIO.read(new File("./src/bilder/test_image.bmp"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		img = test.process();
		
		try {
			ImageIO.write(img, "bmp", new File("./src/bilder/output_image.bmp"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
