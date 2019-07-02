import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CatBlack extends Cat {

	protected static BufferedImage blackcatright;
	protected static BufferedImage blackcatleft;
	protected static BufferedImage blackcatrightattack;
	protected static BufferedImage blackcatleftattack;
	
	CatBlack(int resx, int resy)
		{
			super(resx,resy);
			try {                
		        blackcatright = ImageIO.read(new File("pictures\\blackcatright.png"));
		     } catch (IOException ex) { }
			try {                           
		        blackcatrightattack = ImageIO.read(new File("pictures\\blackcatrightattack.png"));
		     } catch (IOException ex) { }
			try {                
		        blackcatleft = ImageIO.read(new File("pictures\\blackcatleft.png"));
		     } catch (IOException ex) { }
			try {                
		        blackcatleftattack = ImageIO.read(new File("pictures\\blackcatleftattack.png"));
		     } catch (IOException ex) { }
			catYV=4;
		}
	
	
}
