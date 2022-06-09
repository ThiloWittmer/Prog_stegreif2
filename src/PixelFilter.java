
public abstract class PixelFilter implements Filter {

    int[] pixel;

    pixel = image.getRGB();
    image = new BufferdImage(width, height, BufferdImage.TYPE_INT_RGB);
    image.setRGB();

}
