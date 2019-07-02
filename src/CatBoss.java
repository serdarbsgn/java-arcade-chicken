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
	
	CatBoss(int resx, int resy)
	{
		super(resx,resy);
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
		catYV=7;
	}
	@Override
	public int CatMovement(int playerY, int playerX , int eggY , int eggX,int health ,boolean throwaegg)
	{		
		catY-=catYV;
		if(catY<=-resy)
		{
			catY=resy;
			Random generator = new Random();
			int i = generator.nextInt(resx);
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
		
		if(catY<=playerY+(int)(resx/7.8)&&catY>=playerY-(int)(resx/19.2))
		{
			catattack=true;
			
			if(new Rectangle(catX, catY, (int)(resx/6.4), (int)(resx/6.4)).intersects(new Rectangle(playerX,playerY,(int)(resx/6.4),(int)(resx/6.4))))
			{
				health-=2;
				
			}
			
			
			if(catX>=playerX)
			{
				if(throwaegg==true&&new Rectangle(eggX, eggY, (int)(resx/64),(int)(resx/48)).intersects(new Rectangle(catX,catY,(int)(resx/12.8),(int)(resx/19.2))))
				{
					sounds.cathit();
					catX+=19;
				}
				
				else {catX-=20;}
			}
			else
			{
				if(throwaegg==true&&new Rectangle(eggX, eggY,(int)(resx/64),(int)(resx/48)).intersects(new Rectangle(catX,catY,(int)(resx/12.8),(int)(resx/19.2))))
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
