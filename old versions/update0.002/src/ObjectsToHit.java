import java.util.Random;

import javax.swing.JPanel;

public class ObjectsToHit extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7229310448599421401L;
	public int ObjectY;
	public int ObjectX;
	public int ObjectSpeed;
	public int ObjectWidth;
	public int ObjectHeight;
	
	public boolean ObjectHit=false;
	
	public ObjectsToHit()
	{
		Random rngY= new Random();
		int Y = 270*(rngY.nextInt(5)+5);
		ObjectY=Y;
		
		Random rngX=new Random();
		int X = 1800*(rngX.nextInt(2))+50;
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
