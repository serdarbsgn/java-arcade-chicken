import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Cat {

	protected boolean catgoestoright=true;
	protected boolean catattack=false;
	protected int catYV=2;
	protected int catX;
	protected int catY;
	
	protected BufferedImage catright;
	protected BufferedImage catleft;
	protected BufferedImage catrightattack;
	protected BufferedImage catleftattack;
	
	protected BufferedImage blackcatright;
	protected BufferedImage blackcatleft;
	protected BufferedImage blackcatrightattack;
	protected BufferedImage blackcatleftattack;
	
	protected BufferedImage bosscatright;
	protected BufferedImage bosscatleft;
	protected BufferedImage bosscatrightattack;
	protected BufferedImage bosscatleftattack;
	
	protected Sounds sounds = new Sounds();
	
	Cat()
	{
		catY=1600;
		Random generator = new Random();
		int i = generator.nextInt(1600);
		catX=i;
		try {                
	        catright = ImageIO.read(new File("src\\catright.png"));
	     } catch (IOException ex) { }
		try {                           
	        catrightattack = ImageIO.read(new File("src\\catrightattack.png"));
	     } catch (IOException ex) { }
		try {                
	        catleft = ImageIO.read(new File("src\\catleft.png"));
	     } catch (IOException ex) { }
		try {                
	        catleftattack = ImageIO.read(new File("src\\catleftattack.png"));
	     } catch (IOException ex) { }
		try {                
	        blackcatright = ImageIO.read(new File("src\\blackcatright.png"));
	     } catch (IOException ex) { }
		try {                           
	        blackcatrightattack = ImageIO.read(new File("src\\blackcatrightattack.png"));
	     } catch (IOException ex) { }
		try {                
	        blackcatleft = ImageIO.read(new File("src\\blackcatleft.png"));
	     } catch (IOException ex) { }
		try {                
	        blackcatleftattack = ImageIO.read(new File("src\\blackcatleftattack.png"));
	     } catch (IOException ex) { }
		try {                
	        blackcatright = ImageIO.read(new File("src\\bosscatright.png"));
	     } catch (IOException ex) { }
		try {                           
	        blackcatrightattack = ImageIO.read(new File("src\\bosscatrightattack.png"));
	     } catch (IOException ex) { }
		try {                
	        blackcatleft = ImageIO.read(new File("src\\bosscatleft.png"));
	     } catch (IOException ex) { }
		try {                
	        blackcatleftattack = ImageIO.read(new File("src\\bosscatleftattack.png"));
	     } catch (IOException ex) { }
	}
	public void ResetCat()
	{
		catY=1600;
		Random generator = new Random();
		int i = generator.nextInt(1600);
		catX=i;
	}
	
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
			
			if(catX<=playerX+280&&catX>playerX-20)
			{
				health--;
				
			}
			
			
			if(catX>=playerX)
			{
				if(throwaegg==true&&new Rectangle(eggX, eggY, 20, 30).intersects(new Rectangle(catX,catY,150,100)))
				{
					sounds.cathit();
					catX+=19;
				}
				
				else {catX-=10;}
			}
			else
			{
				if(throwaegg==true&&new Rectangle(eggX, eggY, 20, 30).intersects(new Rectangle(catX,catY,150,100)))
				{
					sounds.cathit();
					catX-=19;
				}
				
				else {catX+=10;}
			}
			
		}
		else
		{
			catattack=false;
		}
				
		return health;
	}
	
}
