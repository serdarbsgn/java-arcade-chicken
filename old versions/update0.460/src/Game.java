import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener,KeyListener{
	
	private static final long serialVersionUID = -4487284821118762902L;
	
	MainMenu m = new MainMenu();
	
	Level2 l2 = new Level2();
	
	Player player = new Player();
	
	Egg egg = new Egg(player.playerX,player.playerY);
	
	ObjectsToHit objects = new ObjectsToHit();
	
	Cat cat = new Cat();
	
	Meteor meteor = new Meteor();
	Meteor meteor2 = new Meteor();
	Meteor meteor3 = new Meteor();
	Meteor meteor4 = new Meteor();
	
	Font myFont = new Font ("Courier New", 1, 34);
	
	BackGround stars = new BackGround();
	
	public boolean startgame= false;
	public boolean play  = false;
	public boolean quitgame= false;	
	
	private Timer timer;
	private int delay =	0;
	
	public boolean up	=	false;
	public boolean down	=	false;
	public boolean right=	false;
	public boolean left	=	false;
	public boolean spacebar = false;
	
	
	
	public Game()
	{				
			addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
			timer = new Timer(delay,this);
			timer.start();
				
	}

	public void paint(Graphics g)
	{
		if(startgame)
		{		
				if(m.level==1)
				{

					//looping stars
					g.drawImage(stars.backgroundstar, 0, stars.backgroundY, 1920, 1080, null);
					g.drawImage(stars.backgroundstar, 0, stars.backgroundY2, 1920, 1080, null);
			
					//moon
					g.drawImage(stars.moon, 200, stars.moonY, 768, 768, null);
			
					//blue meteors
					g.drawImage(meteor.meteorblue,	meteor.MeteorX, meteor.MeteorY,300,300, null);
					g.drawImage(meteor.meteorblue,	-meteor2.MeteorX, meteor2.MeteorY,-300,300, null);
			
					//yellow meteors
					g.drawImage(meteor.meteoryellow, meteor3.MeteorX, meteor3.MeteorY,300,300, null);
					g.drawImage(meteor.meteoryellow, -meteor4.MeteorX, meteor4.MeteorY,-300,300, null);
			
			
					//changing chicken pictures
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
			
			
					//changing cat pictures
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
					if(play==false)
					{
						Font f = new Font("Arial",Font.BOLD,50);
						g.setFont(f);
						g.setColor(Color.CYAN);
						g.drawString("GAME IS PAUSED PRESS ESC", 560 , 500 );
					}
			g.dispose();
				}
			
				if(m.level==2)
				{
					l2.paint(g);
					if(play==false)
					{
						Font f = new Font("Arial",Font.BOLD,50);
						g.setFont(f);
						g.setColor(Color.BLACK);
						g.drawString("GAME IS PAUSED PRESS ESC", 560 , 500 );
					}
				}
		}
		
		else
		{
			m.paint(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(quitgame)
		{
			System.exit(0);
		}
		
		
		if(play&&startgame)
		{
			if(m.level==1)
			{
				controls(player, egg);
				if(player.health<0)
				{
					resetgame();
				}
				level1();
			}
			if(m.level==2)
			{
				controls(l2.player1,l2.egg1);
				if(l2.player1.health<0)
				{
					l2.resetL2();
					resetgame();
				}
				l2.level2();
			}
			
		}		
		else
		{
			m.main.Movement();
		}
				repaint();
	}
	
	void resetgame()
	{
		play=false;
		startgame=false;
		player.ResetPlayer();
		cat.ResetCat();
		objects = new ObjectsToHit();
	}
	public void controls(Player player , Egg egg)
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
	}
			
	public void level1()
	{
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
				
		//code about meteors
		meteor.MeteorMovement();
		meteor2.MeteorMovement();
		meteor3.MeteorMovement();
		meteor4.MeteorMovement();
		//code about cat
		player.health=cat.CatMovement(player.playerY, player.playerX, egg.eggY, egg.eggX,player.health, egg.throwaegg);
		
		//code about background
		stars.Movement();
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
			m.menuselected-=1;
			if(m.menuselected==-1)
			{
				m.menuselected=2;
			}
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN)
		{
			down=true;
			m.menuselected+=1;
			if(m.menuselected==3)
			{
				m.menuselected=0;
			}
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
			if(startgame==false)
			{
				if(m.showlevelsmenu==false)
				{
					if(m.menuselected==0)
					{
						startgame=true;
						m.level=1;
					}
					if(m.menuselected==1)
					{
						m.showlevelsmenu=true;
						m.menuselected=0;
					}
					if(m.menuselected==2)
					{
						quitgame=true;
					}
				}
				else
				{
					if(m.menuselected==0)
					{
						startgame=true;
						m.level=1;
					}
					if(m.menuselected==1)
					{
						startgame=true;
						m.level=2;
					}
					if(m.menuselected==2)
					{
						startgame=true;
						m.level=3;
					}
				}
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
			if(startgame)
			{
				if(play==true)
				{
				play=false;
				}
				else play=true;
			}
		}	
		
		if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
		{
			m.showlevelsmenu=false;
			if(startgame&&play==false)
			{
				resetgame();
				startgame=false;
			}
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
