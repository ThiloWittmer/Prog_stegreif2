import java.awt.image.*;

/***
 * Interface um Filter zu erzeugen
 */
public interface Filter {
    public BufferedImage process(BufferedImage ... image);
}