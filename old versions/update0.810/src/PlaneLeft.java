import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlaneLeft extends Plane{
	protected static BufferedImage planeleft;
	
	public PlaneLeft()
	{
		try {                
	       planeleft = ImageIO.read(new File("pictures\\planeleft.png"));
	     } catch (IOException ex) { }
		resetPlane();
	}
}
