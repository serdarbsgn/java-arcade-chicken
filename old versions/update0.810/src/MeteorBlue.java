import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MeteorBlue extends Meteor{
	
	protected static BufferedImage meteorblue;
	
	public MeteorBlue() 
	{
		try {                
	        meteorblue = ImageIO.read(new File("pictures\\meteorblue.png"));
	     } catch (IOException ex) { }
	}
}
