import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MeteorYellow extends Meteor{
	
	protected static BufferedImage meteoryellow;
	
	public MeteorYellow()
	{
		try {                
	        meteoryellow = ImageIO.read(new File("pictures\\meteoryellow.png"));
	     } catch (IOException ex) { }
	}
}
