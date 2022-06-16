
public class PixelGraphicFilter extends AreaFilter {
    private int pixelSize;

    /**
     * 
     * @param pixelSize Uebergabe wie groß der verpixelte neue Pixel werden soll
     */
    public PixelGraphicFilter(int pixelSize) {
        this.pixelSize =  pixelSize;
    }

   /***
    * 
    * Berechnet die Kooridanten des aktuellen Pixels und setzt die richtige Farbe 
    * 
    */
    @Override
    public int calculate(int[] pixel, int index, int width) {
        int widthPointer = index % width;
        int heightPointer = index / width;

        if (index == 0) {
            pixel[index] = calcColor(pixel, index, width);
            return pixel[index];
        }

        if (widthPointer % pixelSize != 0) {
            return pixel[index -1];
        } else if(heightPointer % pixelSize != 0) {
            return pixel[index - width];
        } else {
            pixel[index] = calcColor(pixel, index, width);
            return pixel[index];
        }

    }

    /**
     * 
     * Gibt die Durchschnittsfarbe von allen Pixeln die betrachtet werden aus
     * 
     * @param pixel Array aller Pixel 
     * @param index Stelle im Array
     * @param width 
     * @return
     */
    private int calcColor(int[] pixel, int index, int width) {
        int avgR = 0;
        int avgG = 0;
        int avgB = 0;
        int tmpIndex = index;

        for (int i = 0; i < pixelSize; i++) {
            for (int j = 0; j < pixelSize; j++) {
            	try {
	                avgR += (pixel[tmpIndex + j] >> 16) & 0xFF;
	                avgG += (pixel[tmpIndex + j] >> 8) & 0xFF;
	                avgB += pixel[tmpIndex + j] & 0xFF;
            	} catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
            tmpIndex += width;
        }

        avgR = Math.round((float) avgR / (pixelSize * pixelSize));
        avgG = Math.round((float) avgG / (pixelSize * pixelSize));
        avgB = Math.round((float) avgB / (pixelSize * pixelSize));

        pixel[index] = 0;

        pixel[index] |= avgR << 16;
        pixel[index] |= avgG << 8;
        pixel[index] |= avgB;

        return pixel[index];
    }
    
}
