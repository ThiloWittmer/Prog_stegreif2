import java.awt.image.*;

public abstract class AreaFilter implements Filter {
 
    public abstract int calculate(int[] pixel, int[] maskPixel, int index, int width, int height);

    public BufferedImage process(String filterParam, BufferedImage ... image) {
		int width = image[0].getWidth();
        int heigth = image[0].getHeight();

        int[] img = (image.length > 0) ? image[0].getRGB(0, 0, width, heigth, null, 0, width) : null;
        int[] mask = (image.length > 1) ? image[1].getRGB(0, 0, width, heigth, null, 0, width) : null;

        int radius = Integer.valueOf(filterParam);

        // TODO processing Area-Filter
        
        image[0] .setRGB(0, 0, width, heigth, img, 0, width);
        return image[0];
    }

}
