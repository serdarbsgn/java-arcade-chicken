import java.awt.Rectangle;
import java.util.Random;

public class Cat {

	protected boolean catgoestoright=true;
	protected boolean catattack=false;
	protected int catYV;
	protected int catX;
	protected int catY;
			
	protected static Sounds sounds = new Sounds();
	
	public Cat()
	{
		catY=1600;
		Random generator = new Random();
		int i = generator.nextInt(1600);
		catX=i;
		catYV=3;
	}
	public void SetYV(int V)
	{
		catYV=V;
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
			
			if(new Rectangle(catX, catY, 300, 300).intersects(new Rectangle(playerX,playerY,300,300)))
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
