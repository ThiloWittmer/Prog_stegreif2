import java.awt.image.*;

public abstract class AreaFilter implements Filter {
 
    public abstract int calculate(int[] pixel, int[] maskPixel, int index, int width, int height);

    public BufferedImage process(BufferedImage ... image) {
		int width = image[0].getWidth();
        int height = image[0].getHeight();

        int[] img = (image.length > 0) ? image[0].getRGB(0, 0, width, height, null, 0, width) : null;
        int[] mask = (image.length > 1) ? image[1].getRGB(0, 0, width, height, null, 0, width) : null;

        for (int i = 0; i < img.length; i++) {
            if (mask == null || mask[i] > 0xFF000000) {
                img[i] = calculate(img, mask, i, width, height);
            }
        }
        
        image[0].setRGB(0, 0, width, height, img, 0, width);
        return image[0];
    }

}
