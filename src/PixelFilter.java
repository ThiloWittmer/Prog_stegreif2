import java.awt.image.*;


public abstract class PixelFilter implements Filter {
	

    public abstract int calculate(int pixelColor) throws Exception;
    
    
    public BufferedImage process(BufferedImage ... image) {
        int width = image[0].getWidth();
        int heigth = image[0].getHeight();

        int[] img = (image.length > 0) ? image[0].getRGB(0, 0, width, heigth, null, 0, width) : null;
        int[] mask = (image.length > 1) ? image[1].getRGB(0, 0, width, heigth, null, 0, width) : null;

        for (int i = 0; i < img.length; i++) {
            if (mask == null || mask[i] > 0xFF000000) {
                try {
                    img[i] = calculate(img[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        image[0] .setRGB(0, 0, width, heigth, img, 0, width);
        return image[0];
    }
}
