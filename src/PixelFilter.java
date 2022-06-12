import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.image.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public abstract class PixelFilter implements Filter {
	
	private static JFrame frame;
	private static JLabel label;
	

    public abstract int calculate(int pixelColor);
    
    
    public BufferedImage process (BufferedImage image1){
        // TODO process() schreiben
    	
        BufferedImage image = null;

        try{
            image = ImageIO.read(new File("input_image.bmp"));
            
            ImageIO.write(image, "bmp", new File ("output_image.bmp"));
        } catch(IOException e){
            //TODO Auto-generated
            e.printStackTrace();
        }
         
        return image;
    }
    
    public static void display(BufferedImage image) {
    	if(frame == null) {
    	JFrame frame = new JFrame();
    	JLabel label = new JLabel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        label.setIcon(new ImageIcon(image));
        frame.getContentPane().add(label,BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
    	frame.pack();
    	frame.setVisible(true);
    	}else label.setIcon(new ImageIcon(image));
    	
    }
    
}
