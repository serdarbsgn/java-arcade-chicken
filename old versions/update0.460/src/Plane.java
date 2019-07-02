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
		
		Random rngY= new Random();
		int Y = (rngY.nextInt(1080)+100);
		planeY=Y;
		Random rngX= new Random();
		int X = (rngX.nextInt(300)-600);
		planeX=X;
		
		Random rngVY = new Random();
		int VY = 2*(rngVY.nextInt(3)+1);
		planeSpeedX= VY;
		planeSpeedY= VY%10;
	}
	
	public void PlaneMovement()
	{
		planeY+=planeSpeedY;
		planeX-=planeSpeedX;
		
		if(planeX>=2220)
		{
			Random rngY= new Random();
			int Y = (rngY.nextInt(1380));
			planeY=Y;
			
			Random rngX= new Random();
			int X =(rngX.nextInt(2220)+2220);
			planeX=X;
			
			Random rngVY = new Random();
			int VY = 3*(rngVY.nextInt(16)+1);
			planeSpeedX= VY;
			planeSpeedY= VY%16;
		}
		if(planeX<=-330)
		{
			Random rngY= new Random();
			int Y = (rngY.nextInt(1380));
			planeY=Y;
			
			Random rngX= new Random();
			int X =(rngX.nextInt(2220)+2220);
			planeX=X;
			
			Random rngVY = new Random();
			int VY = 3*(rngVY.nextInt(16)+1);
			planeSpeedX= VY;
			planeSpeedY= VY%16;
		}
		
	}
}
