import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackGround {
	
	protected static BufferedImage backgroundstar;
	protected static BufferedImage backgroundcloud;
	protected static BufferedImage moon;
	protected static BufferedImage iss;
	protected static int issY;
	protected static int moonY;
	protected static int moondelayer;
	protected static int backgroundY;
	protected static int backgroundY2;
	protected static int backgrounddelayer;

	public BackGround()
	{
		try {                
	        iss = ImageIO.read(new File("pictures\\iss.png"));
	     } catch (IOException ex) {}
		try {                
	        backgroundstar = ImageIO.read(new File("pictures\\star.jpg"));
	     } catch (IOException ex) {}
		try {                
	        backgroundcloud = ImageIO.read(new File("pictures\\cloud.jpg"));
	     } catch (IOException ex) {}
		try {                
	        moon = ImageIO.read(new File("pictures\\moon.png"));
	     } catch (IOException ex) {}
		
		issY=1500;
		moonY=500;
		moondelayer=0;
		backgroundY=0;
		backgroundY2=1080;
		backgrounddelayer=0;
		
	}
	public static void Refresh()
	{
		issY=1500;
		moonY=500;
		moondelayer=0;
		backgroundY=0;
		backgroundY2=1080;
		backgrounddelayer=0;
	}
	
	public static void Movement()
	{
		if(backgrounddelayer<1)
		{
			backgrounddelayer++;
		}
		else
		{	
			backgroundY--;
			backgroundY2--;
			backgrounddelayer=0;
		}	
		if(backgroundY<=-1080)
		{
			backgroundY=1080;
		}
		if(backgroundY2<=-1080)
		{
			backgroundY2=1080;
		}
		
		if(moondelayer<8)
		{
			moondelayer++;
		}
		else
		{
			issY--;
			moonY--;
			moondelayer=0;
		}
	}
}
