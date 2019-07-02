import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Plane {
	
	protected int planeY;
	protected int planeX;
	protected int planeSpeedY;
	protected int planeSpeedX;
	protected BufferedImage planeleft;
	protected BufferedImage planeright;
	
	public Plane()
	{
		try {                
	       planeright = ImageIO.read(new File("src\\planeright.png"));
	     } catch (IOException ex) { }
		try {                
	       planeleft = ImageIO.read(new File("src\\planeleft.png"));
	     } catch (IOException ex) { }
		
		resetPlane();
	}
	
	public void resetPlane()
	{
		Random rngY= new Random();
		int Y = (rngY.nextInt(1380));
		planeY=Y;
		
		Random rngX= new Random();
		int X =(rngX.nextInt(200)+2220);
		planeX=X;
		
		Random rngVY = new Random();
		int VY = (rngVY.nextInt(5)+5);
		planeSpeedX= VY;
		planeSpeedY= VY/5;
	}
	
	public void PlaneMovement()
	{
		planeY+=planeSpeedY;
		planeX-=planeSpeedX;
		
		if(planeX>=2620)
		{
			resetPlane();
		}
		if(planeX<=-2620)
		{
			resetPlane();
		}
		
	}
}
