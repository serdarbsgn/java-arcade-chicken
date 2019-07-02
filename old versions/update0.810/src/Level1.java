import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Level1 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1512291303273547128L;
	
	protected Player player1 = new Player() ;
	protected CatYellow cat1 = new CatYellow();
	protected Egg egg1 = new Egg(player1.playerX,player1.playerY);
	protected ObjectsToHit obj1 = new ObjectsToHit();
	protected BackGround stars = new BackGround();
	protected MeteorBlue meteor1 = new MeteorBlue();
	protected MeteorBlue meteor2 = new MeteorBlue();
	protected MeteorYellow meteor3 = new MeteorYellow();
	protected MeteorYellow meteor4 = new MeteorYellow();
	protected Sounds sounds = new Sounds();
	
	public Level1()
	{
		setVisible(true);
	}
	
	public void resetL1()
	{
		player1 = new Player() ;
		cat1 = new CatYellow();
		egg1 = new Egg(player1.playerX,player1.playerY);
		obj1 = new ObjectsToHit();
		BackGround.Refresh();
		meteor1 = new MeteorBlue();
		meteor2 = new MeteorBlue();
		meteor3 = new MeteorYellow();
		meteor4 = new MeteorYellow();
	}
	public void paint(Graphics g)
	{
		//looping stars
		g.drawImage(BackGround.backgroundstar, 0, BackGround.backgroundY, 1920, 1080, null);
		g.drawImage(BackGround.backgroundstar, 0, BackGround.backgroundY2, 1920, 1080, null);
		
		//moon
		g.drawImage(BackGround.moon, 200, BackGround.moonY, 383, 383, null);
		g.drawImage(BackGround.iss, 500, BackGround.issY, 383, 153, null);
		//blue meteors
		g.drawImage(MeteorBlue.meteorblue,	meteor1.MeteorX, meteor1.MeteorY,300,300, null);
		g.drawImage(MeteorBlue.meteorblue,	-meteor2.MeteorX, meteor2.MeteorY,-300,300, null);

		//yellow meteors
		g.drawImage(MeteorYellow.meteoryellow, meteor3.MeteorX, meteor3.MeteorY,300,300, null);
		g.drawImage(MeteorYellow.meteoryellow, -meteor4.MeteorX, meteor4.MeteorY,-300,300, null);
				
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
		
		g.setColor(Color.WHITE);
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
		
		Font f = new Font("Comic Sans MS",Font.BOLD,50);
		g.setFont (f);
		g.drawString("Score = " + String.valueOf(player1.score) +  "        Health = " + String.valueOf(player1.health), 675, 40);
		
	}
	
	public void level1()
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
		meteor1.MeteorMovement();
		meteor2.MeteorMovement();
		meteor3.MeteorMovement();
		meteor4.MeteorMovement();
		obj1.ObjectY-=obj1.ObjectSpeed;
		player1.PlayerMovement();
		//code about egg movement
		egg1.EggMovement(player1.playerX, player1.playerY, player1.playerRight);
				
		//code about cat
		player1.health=cat1.CatMovement(player1.playerY, player1.playerX, egg1.eggY, egg1.eggX,player1.health, egg1.throwaegg);
		//code about background
		BackGround.Movement();
	}
}
