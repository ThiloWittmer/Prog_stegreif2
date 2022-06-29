import java.awt.image.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

import javax.imageio.ImageIO;

/**
 * Liest Argumente aus und wendet entsprechende Filter an
 * 
 * @author Thilo Wittmer, Aaron Stier, Muhanad Khatib
 */

public class Control {

	public static void main(String[] args) {
		BufferedImage image;
		BufferedImage tmpImage;
		BufferedImage maskImage = null;
		String input = "";
		String output = "";
		String mask = "";
		String filter = "";
		boolean test = false;
		final Color GREY1 = new Color(98, 98, 98);
		final Color GREY2 = new Color(160, 160, 160);
		ChainFilter warhol = new ChainFilter();
		

		//Hashmap mit allen vorgegebenen Filtern
		Map<String, Filter> filters = new HashMap<String, Filter>();

		filters.put("blur_3", new BlurFilter(3));
		filters.put("blur_5", new BlurFilter(5));
		filters.put("monochrom", new MonochromeFilter());
		filters.put("colorband_red", new ColorBandFilter(ColorBandFilterEnum.RED));
		filters.put("colorband_green", new ColorBandFilter(ColorBandFilterEnum.GREEN));
		filters.put("colorband_blue", new ColorBandFilter(ColorBandFilterEnum.BLUE));
		filters.put("threshhold_128", new ThresholdFilter(128));
		filters.put("threshhold_192", new ThresholdFilter(192));
		filters.put("multithreshold", new MultiTreshhold());
		filters.put("colorreplacement_98", new ColorReplacementFilter(GREY1));
		filters.put("colorreplacement_160", new ColorReplacementFilter(GREY2));
		filters.put("colorreplacement_255", new ColorReplacementFilter(Color.white));
		filters.put("pixel_20", new PixelGraphicFilter(20));
		filters.put("pixel_40", new PixelGraphicFilter(40));
		filters.put("pixel_60", new PixelGraphicFilter(60));
		filters.put("contrast_1.7", new ContrastFilter(1.7f));
		filters.put("contrast_1.0", new ContrastFilter(1.0f));
		filters.put("contrast_0.3", new ContrastFilter(0.3f));
		
		warhol.add(new MultiTreshhold());
		warhol.add(new ColorReplacementFilter(Color.black));
		warhol.add(filters.get("colorreplacement_98"));
		warhol.add(filters.get("colorreplacement_160"));
		warhol.add(filters.get("colorreplacement_255"));
		
		filters.put("warhol", warhol);


		//Args einlesen
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-m")) {
				mask = args[i+1];
			} else if (!args[i].contains(".") && !args[i].contains("-")) {
				switch(args[i]) {
					case "test": test = true;
					break;
					default: filter = args[i];
				}
			} else if (args[i].contains(".") && !args[i-1].contains("-")) {
				switch (input) {
					case "": 
						input = args[i];
						break;
					default:
						output = args[i];
				}
			}
		}

		//Bild und Maske einlesen
		image = read(input);
		if (!mask.equals("")) {
			maskImage = read(mask);
		}

		//filter anwenden
		if (!test) {
			try {
				image = filters.get(filter).process(image, maskImage);				
				//Bild ausgeben
				write(output, image);
			} catch (Exception e) {
				System.out.println("Dieser Filtername ist ungueltig");
				e.printStackTrace();
			}
		} else {
			//Testdurchlauf
			for (String  currKey : filters.keySet()) {
				tmpImage = filters.get(currKey).process(image, maskImage);
				output = filter + "_" + currKey + ".bmp";
				write(output, tmpImage);
			}
		}
	}

	/**
	 * Speichert ein Bild mit angegebenem Dateinamen ab
	 * @param fileName Dateiname
	 * @param image Bild
	 */
	private static void write(String fileName, BufferedImage image) {
		try {
			ImageIO.write(image, "bmp", new File(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gibt ein Bild mit angegebenem Dateinamen zurück
	 * @param fileName
	 * @return
	 */
	private static BufferedImage read(String fileName) {
		BufferedImage image = null; 
		try {
			image = ImageIO.read(new File(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}

}
