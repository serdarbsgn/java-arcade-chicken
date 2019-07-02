import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Level2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1512291303273547128L;
	
	protected Player player1 = new Player() ;
	protected CatYellow cat1 = new CatYellow();
	protected CatBlack cat2 = new CatBlack()	;
	protected Egg egg1 = new Egg(player1.playerX,player1.playerY);
	protected ObjectsToHit obj1 = new ObjectsToHit();
	protected BackGround clouds = new BackGround();
	protected Plane plane1 = new Plane();
	protected Plane plane2 = new Plane();
	protected Plane plane3 = new Plane();
	protected Plane plane4 = new Plane();
	protected Sounds sounds = new Sounds();
	
	public Level2()
	{
		setVisible(true);
		cat2.SetYV(4);
	}
	
	public void resetL2()
	{
		player1 = new Player() ;
		cat1 = new CatYellow();
		cat2 = new CatBlack();
		cat2.SetYV(4);
		egg1 = new Egg(player1.playerX,player1.playerY);
		obj1 = new ObjectsToHit();
		BackGround.Refresh();
		plane1 = new Plane();
		plane2 = new Plane();
		plane3 = new Plane();
		plane4 = new Plane();
	}
	public void paint(Graphics g)
	{
		//looping background
		g.drawImage(BackGround.backgroundcloud, 0, BackGround.backgroundY, 1920, 1080, null);
		g.drawImage(BackGround.backgroundcloud, 0, BackGround.backgroundY2, 1920, 1080, null);
		g.drawImage(PlaneLeft.planeleft, plane1.planeX, plane1.planeY,246,150, null);
		g.drawImage(PlaneRight.planeright, plane2.planeX, plane2.planeY,-300,90, null);
		g.drawImage(PlaneLeft.planeleft, -plane3.planeX, plane3.planeY,-246,150, null);
		g.drawImage(PlaneRight.planeright, -plane4.planeX, plane4.planeY,300,90, null);
		
		//changing chicken pictures
		if(player1.playerRight)
		{	
		g.drawImage(Player.chickenright, player1.playerX, player1.playerY,300,320, null);
		}
		else
		{
		g.drawImage(Player.chickenleft, player1.playerX, player1.playerY,300,320, null);
		}
		
		//throwing egg
		if(egg1.throwaegg)
		{
		g.drawImage(egg1.egg, egg1.eggX, egg1.eggY,30,40, null);
		}
		
		g.setColor(Color.BLACK);
		g.fillRect(obj1.ObjectX, obj1.ObjectY, obj1.ObjectWidth, obj1.ObjectHeight);
		
		
		//changing cat pictures
		if(cat1.catgoestoright)
		{
			if(cat1.catattack)
			{
				g.drawImage(CatYellow.catrightattack, cat1.catX, cat1.catY,300 ,300,null);
			}
			else
			{
				g.drawImage(CatYellow.catright, cat1.catX, cat1.catY,300 ,300,null);
			}
		}
		else
		{
			if(cat1.catattack)
			{
				g.drawImage(CatYellow.catleftattack, cat1.catX, cat1.catY,300 ,300,null);
			}
			else
			{
				g.drawImage(CatYellow.catleft, cat1.catX, cat1.catY,300 ,300,null);
			}	
		}
		if(cat2.catgoestoright)
		{
			if(cat2.catattack)
			{
				g.drawImage(CatBlack.blackcatrightattack, cat2.catX, cat2.catY,250 ,250,null);
			}
			else
			{
				g.drawImage(CatBlack.blackcatright, cat2.catX, cat2.catY,250 ,250,null);
			}
		}
		else
		{
			if(cat2.catattack)
			{
				g.drawImage(CatBlack.blackcatleftattack, cat2.catX, cat2.catY,250 ,250,null);
			}
			else
			{
				g.drawImage(CatBlack.blackcatleft, cat2.catX, cat2.catY,250 ,250,null);
			}	
		}
		
		
		Font f = new Font("Comic Sans MS",Font.BOLD,50);
		g.setFont (f);
		g.drawString("Score = " + String.valueOf(player1.score) +  "        Health = " + String.valueOf(player1.health),675, 40);
		
		
	}
	
	public void level2()
	{
	
		if(obj1.ObjectY<-300)
		{
			player1.score=player1.score-11+obj1.ObjectSpeed;
			obj1 = new ObjectsToHit();
		}
		if(new Rectangle(egg1.eggX, egg1.eggY, 30, 40).intersects(new Rectangle(obj1.ObjectX,obj1.ObjectY,obj1.ObjectWidth,obj1.ObjectHeight)))
			{
				sounds.score();
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
		BackGround.Movement();
	}
}