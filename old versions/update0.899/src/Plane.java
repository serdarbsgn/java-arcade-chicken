import java.util.Random;

public class Plane {
	
	protected int planeY;
	protected int planeX;
	protected int planeSpeedY;
	protected int planeSpeedX;
	
	public Plane()
	{		
		resetPlane();
	}
	
	public void resetPlane()
	{
		Random rngY= new Random();
		int Y = (rngY.nextInt(1380));
		planeY=Y;
		
		Random rngX= new Random();
		int X =(rngX.nextInt(200)+2220);
		planeX=X;
		
		Random rngVY = new Random();
		int VY = (rngVY.nextInt(5)+5);
		planeSpeedX= VY;
		planeSpeedY= VY/5;
	}
	
	public void PlaneMovement()
	{
		planeY+=planeSpeedY;
		planeX-=planeSpeedX;
		
		if(planeX>=2620)
		{
			resetPlane();
		}
		if(planeX<=-2620)
		{
			resetPlane();
		}
		
	}
}
