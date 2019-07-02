import java.util.Random;

public class ObjectsToHit {
	
	protected int ObjectY;
	protected int ObjectX;
	protected int ObjectSpeed;
	protected int ObjectWidth;
	protected int ObjectHeight;
	protected boolean ObjectHit=false;
	
	public ObjectsToHit()
	{
		Random rngY= new Random();
		int Y = 270*(rngY.nextInt(5)+5);
		ObjectY=Y;
		
		Random rngX=new Random();
		int X = 1*(rngX.nextInt(2))+50;
		ObjectX=X;
		
		Random rngV = new Random();
		int V = rngV.nextInt(10)+1;
		ObjectSpeed=V;
		
		Random rngW = new Random();
		int W = rngW.nextInt(50)+30;
		ObjectWidth=W;
		
		Random rngH = new Random();
		int H = rngH.nextInt(50)+30;
		ObjectHeight=H;
	}
	
	
}
