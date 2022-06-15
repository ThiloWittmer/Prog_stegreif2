import java.awt.image.*;
import java.io.File;
import java.awt.Color;

import javax.imageio.ImageIO;
public class Control {

	public static void main(String[] args) {
		// nur ein Testlauf:
		BufferedImage image = null;
		Color c = new Color(0xb5cbd9);
		ColorReplacementFilter filter = new ColorReplacementFilter(c);

		try {
			image = ImageIO.read(new File("./bilder/test_image.bmp"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		image = filter.process(image);
		
		try {
			ImageIO.write(image, "bmp", new File("./bilder/output.bmp"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
