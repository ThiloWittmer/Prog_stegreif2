import java.awt.image.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public abstract class PixelFilter implements Filter {
	

    public abstract BufferedImage calculate(BufferedImage image);
    
    
    public BufferedImage process() {
    
	BufferedImage image = null;

    try{
        image = ImageIO.read(new File("input_image.bmp"));
        
        calculate(image);
        
   
        ImageIO.write(image, "bmp", new File ("output_image.bmp"));
    } catch(IOException e){
        //TODO Auto-generated
        e.printStackTrace();
    }
	return image;
    }
}
