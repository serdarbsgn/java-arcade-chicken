import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Egg {
	
	protected int eggX;
	protected int eggY;
	protected boolean eggRight=true;
	protected boolean throwaegg=false;
	protected BufferedImage egg;
	
	Egg(int playerX,int playerY)
	{
		try {                
		       egg = ImageIO.read(new File("pictures\\egg.png"));
		     } catch (IOException ex) { }
		eggX=playerX+50;
		eggY=playerY+50;
	}
	
	public void EggMovement(int playerX , int playerY , boolean playerRight,int x,int y)
	{
		if(throwaegg==false)
		{
			if(playerRight)
			{
				eggX=playerX+(int)(x/6.4);
				eggRight=true;
			}
			
			else
			{
				eggX=playerX+(int)(x/38.4);
				eggRight=false;
			}
			
		eggY=playerY+(int)(x/38.4);
		}
		else
		{ 
			if(eggRight)
			{
				eggX+=25;
				if(eggX>=1920)
				{
					throwaegg=false;
				}
			}
			else
			{
				eggX-=25;
				if(eggX<=0)
				{
					throwaegg=false;
				}
			}
		}
	}
	
}
