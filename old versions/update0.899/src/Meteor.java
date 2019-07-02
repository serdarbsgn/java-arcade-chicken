import java.util.Random;

public class Meteor {
	
	protected int MeteorY;
	protected int MeteorX;
	protected int MeteorSpeedY;
	protected int MeteorSpeedX;
	
	
	
	public Meteor()
	{		
		Random rngY= new Random();
		int Y = 270*(rngY.nextInt(30)+8);
		MeteorY=-Y;
		MeteorX=2*Y;
		
		Random rngVY = new Random();
		int VY = 3*(rngVY.nextInt(13)+1);
		MeteorSpeedY= VY;
		MeteorSpeedX= 2*VY;
	}
	
	public void MeteorMovement()
	{
		MeteorY+=MeteorSpeedY;
		MeteorX-=MeteorSpeedX;
		
		if(MeteorY>=1620)
		{
			Random rngY= new Random();
			int Y = (rngY.nextInt(1380)+1080);
			MeteorY=-Y;
			
			Random rngX= new Random();
			int X =(rngX.nextInt(2220)+2220);
			MeteorX=X;
			
			Random rngVY = new Random();
			int VY = 3*(rngVY.nextInt(16)+1);
			MeteorSpeedY= VY;
			MeteorSpeedX= 2*VY;
		}
		
	}
}
