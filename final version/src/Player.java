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
	
	
	Player(int x , int y)
	{
		score=0;
		health=200;
		playerX = x/3;
		playerY= y/3;
		playerRight=true;
		try {                
	        chickenleft = ImageIO.read(new File("pictures\\chickenleft.png"));
	     } catch (IOException ex) {}
		try {                
	        chickenright = ImageIO.read(new File("pictures\\chickenright.png"));
	     } catch (IOException ex) {}
	}
	
	
	public void PlayerMovement(int x , int y)
	{
		if(playerX<-(int)(x/6.4))
		{
			playerX=playerX+(int)(x+(x/6.4));
			health-=10;
		}
		if(playerX>x)
		{
			playerX=playerX-(int)(x+(x/6.4));
			health-=10;
		}	
		
		if(playerY<-(int)(x/6.4))
		{
			playerY=playerY+(int)(y+(x/6.4));
			health-=20;
		}
		if(playerY>1080)
		{
			playerY=playerY-(int)(y+(x/6.4));
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
