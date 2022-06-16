
public class BlurFilter extends AreaFilter {
    private int radius;

    public BlurFilter(int radius) {
        this.radius = radius;
    }

    @Override
    public int calculate(int[] pixel, int[] maskPixel, int index, int width, int height) throws IndexOutOfBoundsException {
        int avgR = 0;
        int avgG = 0;
        int avgB = 0;
        int tmpIndex = index;
        int tmpWidth = radius / 2;
        int count = 0;

        for (int i = 0; i < (radius/2+1); i++) {
            for (int j = 0; j < (tmpWidth*2 + 1); j++) {
                try {
                    avgR += (pixel[tmpIndex-tmpWidth + j] >> 16) & 0xFF;
                    avgG += (pixel[tmpIndex-tmpWidth + j] >> 8) & 0xFF;
                    avgB += pixel[tmpIndex-tmpWidth + j] & 0xFF;
                    count++;
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
            tmpIndex -= width; 
            tmpWidth--;
        }
        
        tmpIndex = index + width;
        tmpWidth = radius/2 - 1;
        
        for (int i = 0; i < (radius/2); i++) {
            for (int j = 0; j < (tmpWidth*2 + 1); j++) {
                try {
                    avgR += (pixel[tmpIndex-tmpWidth + j] >> 16) & 0xFF;
                    avgG += (pixel[tmpIndex-tmpWidth + j] >> 8) & 0xFF;
                    avgB += pixel[tmpIndex-tmpWidth + j] & 0xFF;
                    count++;
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
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
