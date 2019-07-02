import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Level1 extends JPanel implements ActionListener,KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4487284821118762902L;
	
	ObjectsToHit objects = new ObjectsToHit();
	Font myFont = new Font ("Courier New", 1, 34);
	
	private BufferedImage background;
	private int backgroundY=0;
	private int backgrounddelayer=0;
	private int backgroundY2=1080;
	
	private BufferedImage moon;
	private int moonY=500;
	private int moondelayer=0;
	
	Cat cat = new Cat();
	
	
	Meteor meteor = new Meteor();
	Meteor meteor2 = new Meteor();
	Meteor meteor3 = new Meteor();
	Meteor meteor4 = new Meteor();
	
	private boolean play  = true;
	private Timer timer;
	private int delay =	0;
	
	Player player = new Player();
	Egg egg = new Egg(player.playerX,player.playerY);
	
	public boolean up	=	false;
	public boolean down	=	false;
	public boolean right=	false;
	public boolean left	=	false;
	public boolean spacebar = false;
	
	
	
	public Level1()
	{
		
		try {                
	        background = ImageIO.read(new File("src\\star.jpg"));
	     } catch (IOException ex) {}
		try {                
	        moon = ImageIO.read(new File("src\\moon.png"));
	     } catch (IOException ex) {}
		
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		
	}

	public void paint(Graphics g)
	{
		//looping stars
		g.drawImage(background, 0, backgroundY, 1920, 1080, null);
		g.drawImage(background, 0, backgroundY2, 1920, 1080, null);
		
		//moon
		g.drawImage(moon, 200, moonY, 768, 768, null);
		
		//meteors from right
		g.drawImage(meteor.meteorblue,	meteor.MeteorX, meteor.MeteorY,300,300, null);
		g.drawImage(meteor.meteorblue,	-meteor2.MeteorX, meteor2.MeteorY,-300,300, null);
		
		//meteors from left
		g.drawImage(meteor.meteoryellow, meteor3.MeteorX, meteor3.MeteorY,300,300, null);
		g.drawImage(meteor.meteoryellow, -meteor4.MeteorX, meteor4.MeteorY,-300,300, null);
		
		
		//chicken pictures
		if(player.playerRight)
		{	
		g.drawImage(player.chickenright, player.playerX, player.playerY,300,320, null);
		}
		else
		{
		g.drawImage(player.chickenleft, player.playerX, player.playerY,300,320, null);
		}
		
		
		//throwing egg
		if(egg.throwaegg)
		{
		g.setColor(Color.YELLOW);
		g.fillOval(egg.eggX, egg.eggY, 20, 30);
		}
		
		g.setColor(Color.WHITE);
		g.fillRect(objects.ObjectX, objects.ObjectY, objects.ObjectWidth, objects.ObjectHeight);
		
		
		//cat pictures
		if(cat.catgoestoright)
		{
			if(cat.catattack)
			{
				g.drawImage(cat.catrightattack, cat.catX, cat.catY,300 ,300,null);
			}
			else
			{
				g.drawImage(cat.catright, cat.catX, cat.catY,300 ,300,null);
			}
		}
		else
		{
			if(cat.catattack)
			{
				g.drawImage(cat.catleftattack, cat.catX, cat.catY,300 ,300,null);
			}
			else
			{
				g.drawImage(cat.catleft, cat.catX, cat.catY,300 ,300,null);
			}	
		}
		g.setFont (myFont);
		g.drawString("Score = " + String.valueOf(player.score) +  "        Health = " + String.valueOf(player.health), 750, 40);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play)
		{
			if(up)
			{
				player.Moveup();
			}
			if(down)
			{
				player.Movedown();
			}
			if(left)
			{
				player.Moveleft();
			}
			if(right)
			{
				player.Moveright();
			}
			if(spacebar)
			{
				egg.throwaegg=true;
			}
			if(objects.ObjectY<-300)
			{
				player.score=player.score-11+objects.ObjectSpeed;
				objects = new ObjectsToHit();
			}
			
			if((objects.ObjectY<=egg.eggY&&objects.ObjectY+objects.ObjectHeight>egg.eggY
				&&objects.ObjectX<=egg.eggX&&objects.ObjectX+objects.ObjectWidth>egg.eggX)||
				(objects.ObjectY<=egg.eggY+50&&objects.ObjectY+objects.ObjectHeight>egg.eggY+50
				&&objects.ObjectX<=egg.eggX&&objects.ObjectX+objects.ObjectWidth>egg.eggX))
			{
				player.score=player.score + 10*(objects.ObjectSpeed);
				objects = new ObjectsToHit() ;                                                             
			}
			objects.ObjectY-=objects.ObjectSpeed;
			player.PlayerMovement();
			//code about egg movement
			egg.EggMovement(player.playerX, player.playerY, player.playerRight);
			//code about background
			if(backgrounddelayer<3)
			{
				backgrounddelayer++;
			}
			else
			{	
				backgroundY--;
				backgroundY2--;
				backgrounddelayer=0;
			}	
			if(backgroundY<=-1080)
			{
				backgroundY=1080;
			}
			if(backgroundY2<=-1080)
			{
				backgroundY2=1080;
			}
			if(moondelayer<8)
			{
				moondelayer++;
			}
			else
			{
				moonY--;
				moondelayer=0;
			}
		
			//code about meteors
			meteor.MeteorMovement();
			meteor2.MeteorMovement();
			meteor3.MeteorMovement();
			meteor4.MeteorMovement();
			//code about cat
			player.health=cat.CatMovement(player.playerY, player.playerX, egg.eggY, egg.eggX,player.health, egg.throwaegg);
			
		}		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public synchronized void keyPressed(KeyEvent e) 
	{
		
		if(e.getKeyCode()== KeyEvent.VK_UP)
		{
			up=true;
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN)
		{
			down=true;
		}
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) 
		{
			right=true;
		}
	
		if(e.getKeyCode()== KeyEvent.VK_LEFT) 
		{
			left=true;
		}
		if(e.getKeyCode()== KeyEvent.VK_SPACE) 
		{
			spacebar=true;
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode()== KeyEvent.VK_UP)
		{
			up=false;
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN)
		{
			down=false;
		}
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) 
		{
			right=false;
		}
	
		if(e.getKeyCode()== KeyEvent.VK_LEFT) 
		{
			left=false;
		}
		if(e.getKeyCode()== KeyEvent.VK_SPACE) 
		{
			spacebar=false;
		}
		
	}
}
