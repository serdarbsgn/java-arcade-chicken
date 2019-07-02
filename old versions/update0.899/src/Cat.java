import java.awt.Rectangle;
import java.util.Random;

public class Cat {

	protected boolean catgoestoright=true;
	protected boolean catattack=false;
	protected int catYV;
	protected int catX;
	protected int catY;
	protected int resx,resy;
			
	protected static Sounds sounds = new Sounds();
	
	public Cat(int aresx,int aresy)
	{
		resx=aresx;
		resy=aresy;
		catY=(int)((resy*3)/2);
		Random generator = new Random();
		int i = generator.nextInt(resx);
		catX=i;
		catYV=3;
	}
	public void SetYV(int V)
	{
		catYV=V;
	}
	public void ResetCat()
	{
		catY=(int)((resy*3)/2);
		Random generator = new Random();
		int i = generator.nextInt(resx);
		catX=i;
	}
	
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
				health--;
				
			}
			
			
			if(catX>=playerX)
			{
				if(throwaegg==true&&new Rectangle(eggX, eggY, (int)(resx/64),(int)(resx/48)).intersects(new Rectangle(catX,catY,(int)(resx/12.8),(int)(resx/19.2))))
				{
					sounds.cathit();
					catX+=19;
				}
				
				else {catX-=10;}
			}
			else
			{
				if(throwaegg==true&&new Rectangle(eggX, eggY,(int)(resx/64),(int)(resx/48)).intersects(new Rectangle(catX,catY,(int)(resx/12.8),(int)(resx/19.2))))
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
