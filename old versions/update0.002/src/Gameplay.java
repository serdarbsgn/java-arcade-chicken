import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements ActionListener,KeyListener{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ObjectsToHit objects = new ObjectsToHit();
	private int score=0;
	private BufferedImage background;
	private int backgroundY=0;
	private int backgrounddelayer=0;
	private int backgroundY2=1080;
	private BufferedImage moon;
	private int moonY=500;
	private int moondelayer=0;
	
	private BufferedImage catright;
	private BufferedImage catleft;
	private BufferedImage catrightattack;
	private BufferedImage catleftattack;
	private boolean catgoestoright=true;
	private boolean catattack=false;
	private int catX=0;
	private int catY=1620;
	
	private BufferedImage meteoryellow;
	private BufferedImage meteorblue;
	private int meteorX=0;
	private int meteorY=0;
	private int meteorX2=0;
	private int meteorY2=0;
	private int meteorX3=0;
	private int meteorY3=0;
	
	private boolean play  = true;
	private Timer timer;
	private int delay =	0;

	private BufferedImage chickenleft;
	private BufferedImage chickenright;
	private boolean throwaegg=false;
	private int playerX = 810;
	private int playerY=390;
	private boolean playerRight=true;
	private int eggX=playerX+50;
	private int eggY=playerY+50;
	private boolean eggRight=true;
	
	
	
	public Gameplay()
	{
		try {                
	        catright = ImageIO.read(new File("src\\catright.png"));
	     } catch (IOException ex) { }
		try {                           
	        catrightattack = ImageIO.read(new File("src\\catrightattack.png"));
	     } catch (IOException ex) { }
		try {                
	        catleft = ImageIO.read(new File("src\\catleft.png"));
	     } catch (IOException ex) { }
		try {                
	        catleftattack = ImageIO.read(new File("src\\catleftattack.png"));
	     } catch (IOException ex) { }
		try {                
	        meteoryellow = ImageIO.read(new File("src\\meteoryellow.png"));
	     } catch (IOException ex) { }
		try {                
	        meteorblue = ImageIO.read(new File("src\\meteorblue.png"));
	     } catch (IOException ex) { }
		try {                
	        chickenleft = ImageIO.read(new File("src\\chickenleft.png"));
	     } catch (IOException ex) {}
		try {                
	        chickenright = ImageIO.read(new File("src\\chickenright.png"));
	     } catch (IOException ex) {}
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
		g.drawImage(meteoryellow, meteorX, meteorY,300,300, null);
		g.drawImage(meteorblue,	meteorX2+500, meteorY2,300,300, null);
		//meteors from left
		g.drawImage(meteoryellow, -meteorX3+1080, meteorY3,-300,300, null);
		g.drawImage(meteorblue, -meteorX2+1580, meteorY,-300,300, null);
		//chicken pictures
		if(playerRight)
		{	
		g.drawImage(chickenright, playerX, playerY,300,300, null);
		}
		else
		{
		g.drawImage(chickenleft, playerX, playerY,300,300, null);
		}
		
		//throwing egg
		if(throwaegg)
		{
		g.setColor(Color.YELLOW);
		g.fillOval(eggX, eggY, 20, 30);
		}
		
		g.setColor(Color.WHITE);
		g.fillRect(objects.ObjectX, objects.ObjectY, objects.ObjectWidth, objects.ObjectHeight);
		
		
		//cat pictures
		if(catgoestoright)
		{
			if(catattack)
			{
				g.drawImage(catrightattack, catX, catY,300 ,300,null);
			}
			else
			{
				g.drawImage(catright, catX, catY,300 ,300,null);
			}
		}
		else
		{
			if(catattack)
			{
				g.drawImage(catleftattack, catX, catY,300 ,300,null);
			}
			else
			{
				g.drawImage(catleft, catX, catY,300 ,300,null);
			}	
		}
		g.drawString("Score = " + String.valueOf(score), 960, 10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play)
		{
			if(objects.ObjectY<-300)
			{
				score=score-11+objects.ObjectSpeed;
				objects = new ObjectsToHit();
			}
			
			if(objects.ObjectY<=eggY&&objects.ObjectY+objects.ObjectHeight>eggY&&objects.ObjectX<=eggX&&objects.ObjectX+objects.ObjectWidth>eggX)
			{
				score=score + 10*(objects.ObjectSpeed);
				objects = new ObjectsToHit() ;                                                             
			}
			objects.ObjectY-=objects.ObjectSpeed;
			//code about egg movement
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
			meteorY+=9;
			meteorX-=16;
			meteorY2+=18;
			meteorX2-=32;
			meteorY3+=5;
			meteorX3-=8;
			if(meteorY>=2160)
			{
				Random generator = new Random();
				int i = 270*(generator.nextInt(11)+5);
				meteorY=-i;
				Random generator2 = new Random();
				int i2 = 480*(generator2.nextInt(11)+5);
				meteorX=i2;
			}			
			if(meteorY2>=2160)
			{
				Random generator = new Random();
				int i = 270*(generator.nextInt(11)+5);
				meteorY2=-i;
				Random generator2 = new Random();
				int i2 = 480*(generator2.nextInt(11)+5);
				meteorX2=i2;
			}	
			if(meteorY3>=2160)
			{
				Random generator = new Random();
				int i = 270*(generator.nextInt(11)+5);
				meteorY3=-i;
				Random generator2 = new Random();
				int i2 = 480*(generator2.nextInt(11)+5);
				meteorX3=i2;
			}
			//code about cat
			catY-=2;
			if(catY<=-1080)
			{
				catY=1080;
				Random generator = new Random();
				int i = generator.nextInt(1600);
				catX=i;
			}
			if(catX>=playerX)
			{
				catgoestoright=false;
			}
			else
			{
				catgoestoright=true;
			}
			
			if(catY<=playerY+300&&catY>=playerY-100)
			{
				catattack=true;
				if(catX<=playerX+200&&catX>playerX)
				{
					score--;
				}
				
				
				if(catX>=playerX)
				{
					if(throwaegg==true&&catY+50<=eggY&&catY+150>=eggY&&catX+290<=eggX&&catX+390>=eggX)
					{
						catX+=19;
					}
					
					else {catX-=10;}
				}
				else
				{
					if(throwaegg==true&&catY+50<=eggY&&catY+150>=eggY&&catX+110<=eggX&&catX+210>=eggX)
					{
						catX-=19;
					}
					
					else {catX+=10;}
				}
				
			}
			else
			{
				catattack=false;
			}
			
			
		}		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		if(e.getKeyCode()== KeyEvent.VK_UP)
		{
			playerY-=20;
		}
		else if(e.getKeyCode()== KeyEvent.VK_DOWN)
		{
			playerY+=20;
		}
		else if(e.getKeyCode()== KeyEvent.VK_RIGHT) 
		{
			playerX+=20;
			playerRight=true;
		}
	
		else if(e.getKeyCode()== KeyEvent.VK_LEFT) 
		{
			playerX-=20;
			playerRight=false;
		}
		else if(e.getKeyCode()== KeyEvent.VK_SPACE) 
		{
			throwaegg=true;
		}
		
	}
	
	public void resetEgg() {
		eggX=playerX+50;
		eggY=playerY+50;
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
