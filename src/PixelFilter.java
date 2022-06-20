import java.awt.image.*;

/***
 * 
 * Pixelfilter Ueberklasse um die richtigen Parameter an die process Methode zu uebergeben
 * Geht durch jedes Pixel und ruft die Methode calculate zur Pixelberechnung auf
 */
public abstract class PixelFilter implements Filter {
	

    public abstract int calculate(int pixelColor);
    
    
    public BufferedImage process(BufferedImage ... image) {
        int width = image[0].getWidth();
        int height = image[0].getHeight();
        BufferedImage output = new BufferedImage(width, height, image[0].getType());

        int[] img = (image.length > 0 && image[0] != null) ? image[0].getRGB(0, 0, width, height, null, 0, width) : null;
        int[] mask = (image.length > 1 && image[1] != null) ? image[1].getRGB(0, 0, width, height, null, 0, width) : null;

        for (int i = 0; i < img.length; i++) {
            if (mask == null || mask[i] > 0xFF000000) {
                try {
                    img[i] = calculate(img[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        output.setRGB(0, 0, width, height, img, 0, width);
        return output;
    }
}
