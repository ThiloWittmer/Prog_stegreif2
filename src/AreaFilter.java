import java.awt.image.*;

public abstract class AreaFilter implements Filter {
 
    public abstract int calculate(int[] pixel, int[] maskPixel, int index, int width, int height);

    public BufferedImage process(BufferedImage image1, BufferedImage image2) {
		return image1;
        // TODO process() schreiben
    }

}
