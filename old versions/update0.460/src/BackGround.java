import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackGround {
	
	protected BufferedImage backgroundstar;
	protected BufferedImage backgroundcloud;
	protected BufferedImage moon;
	protected int moonY;
	protected int moondelayer;
	protected int backgroundY;
	protected int backgroundY2;
	protected int backgrounddelayer;

	public BackGround()
	{
		try {                
	        backgroundstar = ImageIO.read(new File("src\\star.jpg"));
	     } catch (IOException ex) {}
		try {                
	        backgroundcloud = ImageIO.read(new File("src\\cloud.jpg"));
	     } catch (IOException ex) {}
		try {                
	        moon = ImageIO.read(new File("src\\moon.png"));
	     } catch (IOException ex) {}
		
		moonY=500;
		moondelayer=0;
		backgroundY=0;
		backgroundY2=1080;
		backgrounddelayer=0;
		
	}
	
	
	public void Movement()
	{
		if(backgrounddelayer<3)
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
			moonY--;
			moondelayer=0;
		}
	}
}
