import java.awt.image.*;

public interface Filter {
    public BufferedImage process(BufferedImage ... image);
}