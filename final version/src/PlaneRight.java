import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlaneRight extends Plane {
	protected static BufferedImage planeright;
	
	public PlaneRight()
	{
		try {                
	       planeright = ImageIO.read(new File("pictures\\planeright.png"));
	     } catch (IOException ex) { }		
		resetPlane();
	}
}
