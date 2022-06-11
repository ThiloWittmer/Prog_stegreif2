import java.awt.image.*;

public abstract class PixelFilter implements Filter {

    public abstract int calculate(int pixelColor);

    public BufferedImage process (BufferedImage image1, BufferedImage image2){
        // TODO process() schreiben
    }
}
