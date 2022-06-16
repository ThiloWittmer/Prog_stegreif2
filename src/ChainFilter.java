import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ChainFilter implements Filter{


    //Liste von Filter die alle zur Verfuegung stehen
    private ArrayList<Filter> filters = new ArrayList<Filter>();

    /***
     * Nimmt sich das ubermittelte Bild und falls auch die Maske und wendet auf diese alle ausgewaehlten Filter an
     */
    @Override
    public BufferedImage process(BufferedImage... image) {

        BufferedImage img = (image.length > 0) ? image[0] : null;
        BufferedImage mask = (image.length > 1) ? image[1] : null;

        for (int i = 0; i < filters.size(); i++) {
            img = filters.get(i).process(img, mask);
        }

        return img;
    }

    public void add(Filter filter) {
        filters.add(filter);
    }
}