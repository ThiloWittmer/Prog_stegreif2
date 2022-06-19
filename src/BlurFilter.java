
/**
 * BlurFilter(Weichzeichnungsfilter)
 * 
 * 
 * Auslösung der Konturen des Bildes mit einem angegebenen Radius 
 */

public class BlurFilter extends AreaFilter {
    private int radius;

    public BlurFilter(int radius) {
        this.radius = radius;

    }
    // geht das Bild durch und ruft der Calculate-Methode auf
     
    // Berechnung der Pixeln von dem Bild
    @Override
    public int calculate(int[] pixel, int[] mask, int index, int width) {
        int avgR = 0;
        int avgG = 0;
        int avgB = 0;
        int tmpIndex = index;
        int tmpWidth = radius / 2;
        int count = 0;
        int currIndex;

        for (int i = 0; i < (radius/2+1); i++) {
            for (int j = 0; j < (tmpWidth*2 + 1); j++) {
            	currIndex = tmpIndex-tmpWidth + j;
            	if (currIndex >= 0 && currIndex < pixel.length) {
            		if (mask == null || mask[currIndex] > 0xFF000000) {
	                    avgR += (pixel[currIndex] >> 16) & 0xFF;
	                    avgG += (pixel[currIndex] >> 8) & 0xFF;
	                    avgB += pixel[currIndex] & 0xFF;
	                    count++;
            		}
            	}
            }
            tmpIndex -= width; 
            tmpWidth--;
        }
        
        tmpIndex = index + width;
        tmpWidth = radius/2 - 1;
        
        for (int i = 0; i < (radius/2); i++) {
            for (int j = 0; j < (tmpWidth*2 + 1); j++) {
            	currIndex = tmpIndex-tmpWidth + j;
            	if (currIndex >= 0 && currIndex < pixel.length) {
            		if (mask == null || mask[currIndex] > 0xFF000000) {
	                    avgR += (pixel[currIndex] >> 16) & 0xFF;
	                    avgG += (pixel[currIndex] >> 8) & 0xFF;
	                    avgB += pixel[currIndex] & 0xFF;
	                    count++;
            		}
            	}
            }
            tmpIndex += width;
            tmpWidth--;
        }

        avgR = Math.round((float) avgR / count);
        avgG = Math.round((float) avgG / count);
        avgB = Math.round((float) avgB / count);

        pixel[index] = 0;

        pixel[index] |= avgR << 16;
        pixel[index] |= avgG << 8;
        pixel[index] |= avgB;

        return pixel[index];
    }
    
}
