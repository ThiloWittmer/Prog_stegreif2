
public class PixelGraphicFilter extends AreaFilter {
    private int pixelSize;

    public PixelGraphicFilter(int pixelSize) {
        this.pixelSize =  pixelSize;
    }

    @Override
    public int calculate(int[] pixel, int[] maskPixel, int index, int width, int height) {
        int widthPointer = index % width;
        int heightPointer = index / width;

        if (index == 0) {
            pixel[index] = calcColor(pixel, index, width);
            return pixel[index];
        }

        if (widthPointer % pixelSize != 0) {
            return pixel[index -1];
        } else if(heightPointer % pixelSize != 0) {
            return pixel[index + width];
        } else {
            pixel[index] = calcColor(pixel, index, width);
            return pixel[index];
        }

    }

    private int calcColor(int[] pixel, int index, int width) {
        int avg = 0;

        for (int i = 0; i < pixelSize; i++) {
            for (int j = 0; j < pixelSize; j++) {
                avg += pixel[index + j];
            }
            index += width;
        }

        avg = avg/(pixelSize * pixelSize);

        return avg;
    }
    
    public void setPixelSize(int pixelSize) {
        this.pixelSize = pixelSize;
    }
}
