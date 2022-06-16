import java.awt.image.*;
import java.io.File;
import java.awt.Color;

import javax.imageio.ImageIO;
public class Control {

	public static void main(String[] args) {
		// nur ein Testlauf:
		BufferedImage image = null;
		BufferedImage mask = null;
		Color c = new Color(0xb5cbd9);
		ColorReplacementFilter filter = new ColorReplacementFilter(c);
		PixelGraphicFilter filter2 = new PixelGraphicFilter(5);

		try {
			image = ImageIO.read(new File("./bilder/test_image.bmp"));
			mask = ImageIO.read(new File("./bilder/mask.bmp"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		image = filter2.process(image);
		
		try {
			ImageIO.write(image, "bmp", new File("./bilder/output.bmp"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
