import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;

public final class MonochromeFilter extends PixelFilter {

	
	@Override
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

    @Override
    public BufferedImage calculate(BufferedImage img) {
    	
    	img = process();
    	
    	int[] pixel;
    	
    	
    	
    	return img;
		
        // TODO Auto-generated method stub
    
    }
}   

