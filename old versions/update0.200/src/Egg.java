
public class Egg {
	
	protected int eggX;
	protected int eggY;
	protected boolean eggRight=true;
	protected boolean throwaegg=false;
	
	Egg(int playerX,int playerY)
	{
		eggX=playerX+50;
		eggY=playerY+50;
	}
	
	public void EggMovement(int playerX , int playerY , boolean playerRight)
	{
		if(throwaegg==false)
		{
			if(playerRight)
			{
				eggX=playerX+250;
				eggRight=true;
			}
			
			else
			{
				eggX=playerX+50;
				eggRight=false;
			}
			
		eggY=playerY+50;
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
