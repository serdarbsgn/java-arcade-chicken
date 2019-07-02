import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	
	protected int score;
	protected int health;
	protected int playerX;
	protected int playerY;
	protected boolean playerRight;
	protected BufferedImage chickenleft;
	protected BufferedImage chickenright;
	
	
	Player()
	{
		score=0;
		health=200;
		playerX = 810;
		playerY=390;
		playerRight=true;
		try {                
	        chickenleft = ImageIO.read(new File("src\\chickenleft.png"));
	     } catch (IOException ex) {}
		try {                
	        chickenright = ImageIO.read(new File("src\\chickenright.png"));
	     } catch (IOException ex) {}
	}
	
	public void PlayerMovement()
	{
		if(playerX<-300)
		{
			playerX=playerX+2220;
			health-=10;
		}
		if(playerX>1920)
		{
			playerX=playerX-2220;
			health-=10;
		}	
		
		if(playerY<-320)
		{
			playerY=playerY+1400;
		}
		if(playerY>1080)
		{
			playerY=playerY-1400;
		}		
	}
	
	public void Moveright()
	{
		playerX+=10;
		playerRight=true;
	}
	
	public void Moveleft()
	{
		playerX-=10;
		playerRight=false;
	}
	
	public void Moveup()
	{
		playerY-=10;
	}
	
	public void Movedown()
	{
		playerY+=10;
	}

}
