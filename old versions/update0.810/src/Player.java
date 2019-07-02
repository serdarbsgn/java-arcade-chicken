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
	protected static BufferedImage chickenleft;
	protected static BufferedImage chickenright;
	
	
	Player()
	{
		score=0;
		health=200;
		playerX = 810;
		playerY=390;
		playerRight=true;
		try {                
	        chickenleft = ImageIO.read(new File("pictures\\chickenleft.png"));
	     } catch (IOException ex) {}
		try {                
	        chickenright = ImageIO.read(new File("pictures\\chickenright.png"));
	     } catch (IOException ex) {}
	}
	
	public void ResetPlayer()
	{
		score=0;
		health=200;
		playerX = 810;
		playerY=390;
		playerRight=true;
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
			health-=20;
		}
		if(playerY>1080)
		{
			playerY=playerY-1400;
			health-=20;
		}		
	}
	
	public void Moveright()
	{
		playerX+=8;
		playerRight=true;
	}
	
	public void Moveleft()
	{
		playerX-=8;
		playerRight=false;
	}
	
	public void Moveup()
	{
		playerY-=8;
	}
	
	public void Movedown()
	{
		playerY+=8;
	}

}
