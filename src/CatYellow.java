import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CatYellow extends Cat{
	
	protected static BufferedImage catright;
	protected static BufferedImage catleft;
	protected static BufferedImage catrightattack;
	protected static BufferedImage catleftattack;


	CatYellow(int resx, int resy)
	{
		super(resx,resy);
		try {                
			catright = ImageIO.read(new File("pictures\\catright.png"));
		} catch (IOException ex) { }
		try {                           
			catrightattack = ImageIO.read(new File("pictures\\catrightattack.png"));
     	} catch (IOException ex) { }
		try {                
			catleft = ImageIO.read(new File("pictures\\catleft.png"));
		} catch (IOException ex) { }
		try {                
			catleftattack = ImageIO.read(new File("pictures\\catleftattack.png"));
		} catch (IOException ex) { }
	}

}
