import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class CatBoss extends Cat{
	
	protected static BufferedImage bosscatright;
	protected static BufferedImage bosscatleft;
	protected static BufferedImage bosscatrightattack;
	protected static BufferedImage bosscatleftattack;
	
	
	CatBoss()
	{
		try {                
	        bosscatright = ImageIO.read(new File("pictures\\bosscatright.png"));
	     } catch (IOException ex) { }
		try {                           
	        bosscatrightattack = ImageIO.read(new File("pictures\\bosscatrightattack.png"));
	     } catch (IOException ex) { }
		try {                
	        bosscatleft = ImageIO.read(new File("pictures\\bosscatleft.png"));
	     } catch (IOException ex) { }
		try {                
	        bosscatleftattack = ImageIO.read(new File("pictures\\bosscatleftattack.png"));
	     } catch (IOException ex) { }
	}
	@Override
	public int CatMovement(int playerY, int playerX , int eggY , int eggX,int health ,boolean throwaegg)
	{		
		catY-=catYV;
		if(catY<=-1080)
		{
			catY=1080;
			Random generator = new Random();
			int i = generator.nextInt(1600);
			catX=i;
		}
		if(catX>=playerX)
		{
			catgoestoright=false;
		}
		else
		{
			catgoestoright=true;
		}
		
		if(catY<=playerY+250&&catY>=playerY-100)
		{
			catattack=true;
			
			if(new Rectangle(catX, catY, 400, 330).intersects(new Rectangle(playerX,playerY,300,300)))
			{
				health-=2;
				
			}
			
			
			if(catX>=playerX)
			{
				if(throwaegg==true&&new Rectangle(eggX, eggY, 20, 30).intersects(new Rectangle(catX,catY,150,100)))
				{
					sounds.cathit();
					catX+=19;
				}
				
				else {catX-=20;}
			}
			else
			{
				if(throwaegg==true&&new Rectangle(eggX, eggY, 20, 30).intersects(new Rectangle(catX,catY,150,100)))
				{
					sounds.cathit();
					catX-=19;
				}
				
				else {catX+=20;}
			}
			
		}
		else
		{
			catattack=false;
		}
				
		return health;
	}
}
