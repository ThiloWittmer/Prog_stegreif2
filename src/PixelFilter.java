import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class PixelFilter implements Filter {

    public abstract int calculate(int pixelColor);

    public BufferedImage process (BufferedImage image1, BufferedImage image2){
        // TODO process() schreiben
        
        BufferedImage image = null;

        try{
            image = ImageIO.read(new File("input_image.bmp"));
            
            ImageIO.write(image, "bmp", new File ("output_image.bmp"));
        } catch(IOException e){
            //TODO Auto-generated
            e.printStackTrace();
        }
        
        //test test test
//        hshdhasd
        
    }
}
