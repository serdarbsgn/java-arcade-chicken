import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Level2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1512291303273547128L;
	
	protected Player player1 = new Player() ;
	protected Cat cat1 = new Cat();
	protected Cat cat2 = new Cat()	;
	protected Egg egg1 = new Egg(player1.playerX,player1.playerY);
	protected ObjectsToHit obj1 = new ObjectsToHit();
	protected BackGround clouds = new BackGround();
	protected Plane plane1 = new Plane();
	protected Plane plane2 = new Plane();
	protected Plane plane3 = new Plane();
	protected Plane plane4 = new Plane();
	
	public Level2()
	{
		setVisible(true);
		cat1.catYV=4;
	}
	
	public void resetL2()
	{
		player1 = new Player() ;
		cat1 = new Cat();
		cat1.catYV=3;
		cat2 = new Cat();
		cat2.catYV=4;
		egg1 = new Egg(player1.playerX,player1.playerY);
		obj1 = new ObjectsToHit();
		clouds = new BackGround();
	}
	public void paint(Graphics g)
	{
		//looping stars
		g.drawImage(clouds.backgroundcloud, 0, clouds.backgroundY, 1920, 1080, null);
		g.drawImage(clouds.backgroundcloud, 0, clouds.backgroundY2, 1920, 1080, null);
				
		//changing chicken pictures
		if(player1.playerRight)
		{	
		g.drawImage(player1.chickenright, player1.playerX, player1.playerY,300,320, null);
		}
		else
		{
		g.drawImage(player1.chickenleft, player1.playerX, player1.playerY,300,320, null);
		}
		g.drawImage(plane1.planeleft, plane1.planeX, plane1.planeY,328,199, null);
		g.drawImage(plane2.planeright, plane2.planeX, plane2.planeY,-400,134, null);
		g.drawImage(plane3.planeleft, -plane3.planeX, plane3.planeY,-328,199, null);
		g.drawImage(plane4.planeright, -plane4.planeX, plane4.planeY,400,134, null);
		
		//throwing egg
		if(egg1.throwaegg)
		{
		g.setColor(Color.YELLOW);
		g.fillOval(egg1.eggX, egg1.eggY, 20, 30);
		}
		
		g.setColor(Color.BLACK);
		g.fillRect(obj1.ObjectX, obj1.ObjectY, obj1.ObjectWidth, obj1.ObjectHeight);
		
		
		//changing cat pictures
		if(cat1.catgoestoright)
		{
			if(cat1.catattack)
			{
				g.drawImage(cat1.catrightattack, cat1.catX, cat1.catY,300 ,300,null);
			}
			else
			{
				g.drawImage(cat1.catright, cat1.catX, cat1.catY,300 ,300,null);
			}
		}
		else
		{
			if(cat1.catattack)
			{
				g.drawImage(cat1.catleftattack, cat1.catX, cat1.catY,300 ,300,null);
			}
			else
			{
				g.drawImage(cat1.catleft, cat1.catX, cat1.catY,300 ,300,null);
			}	
		}
		if(cat2.catgoestoright)
		{
			if(cat2.catattack)
			{
				g.drawImage(cat2.blackcatrightattack, cat2.catX, cat2.catY,250 ,250,null);
			}
			else
			{
				g.drawImage(cat2.blackcatright, cat2.catX, cat2.catY,250 ,250,null);
			}
		}
		else
		{
			if(cat2.catattack)
			{
				g.drawImage(cat2.blackcatleftattack, cat2.catX, cat2.catY,250 ,250,null);
			}
			else
			{
				g.drawImage(cat2.blackcatleft, cat2.catX, cat2.catY,250 ,250,null);
			}	
		}
		
		
		Font f = new Font("Arial",Font.BOLD,50);
		g.setFont (f);
		g.drawString("Score = " + String.valueOf(player1.score) +  "        Health = " + String.valueOf(player1.health), 750, 40);
		
	}
	
	public void level2()
	{
	
		if(obj1.ObjectY<-300)
		{
			player1.score=player1.score-11+obj1.ObjectSpeed;
			obj1 = new ObjectsToHit();
		}
		if((obj1.ObjectY<=egg1.eggY&&obj1.ObjectY+obj1.ObjectHeight>egg1.eggY
				&&obj1.ObjectX<=egg1.eggX&&obj1.ObjectX+obj1.ObjectWidth>egg1.eggX)||
				(obj1.ObjectY<=egg1.eggY+50&&obj1.ObjectY+obj1.ObjectHeight>egg1.eggY+50
				&&obj1.ObjectX<=egg1.eggX&&obj1.ObjectX+obj1.ObjectWidth>egg1.eggX))
			{
				player1.score=player1.score + 10*(obj1.ObjectSpeed);
				obj1 = new ObjectsToHit() ;                                                             
			}
		plane1.PlaneMovement();
		plane2.PlaneMovement();
		plane3.PlaneMovement();
		plane4.PlaneMovement();
		obj1.ObjectY-=obj1.ObjectSpeed;
		player1.PlayerMovement();
		//code about egg movement
		egg1.EggMovement(player1.playerX, player1.playerY, player1.playerRight);
				
		//code about cat
		player1.health=cat1.CatMovement(player1.playerY, player1.playerX, egg1.eggY, egg1.eggX,player1.health, egg1.throwaegg);
		player1.health=cat2.CatMovement(player1.playerY, player1.playerX, egg1.eggY, egg1.eggX,player1.health, egg1.throwaegg);
		//code about background
		clouds.Movement();
	}
}
