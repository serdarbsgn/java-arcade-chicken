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
	Level1 l1 = new Level1();
	Level2 l2 = new Level2();
	Level3 l3 = new Level3();
	Level4 l4 = new Level4();
	LoseScreen lose = new LoseScreen();  
	Sounds sounds = new Sounds();
	int sum=1 ;
	
	protected boolean lost=false;
	protected boolean startgame= false;
	protected boolean play  = false;
	protected boolean quitgame= false;	
	
	private Timer timer;
	private int delay =	0;
	
	protected boolean up	=	false;
	protected boolean down	=	false;
	protected boolean right=	false;
	protected boolean left	=	false;
	protected boolean spacebar = false;
	
	
	
	public Game()
	{				
			addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);			
			timer = new Timer(delay,this);
			timer.start();
				
	}

	public void paint(Graphics g)
	{	final long start = System.nanoTime();
		
		if(startgame)
		{		
				if(m.level==1)
				{
					
					l1.paint(g);
					if(play==false)
					{
						Font f1 = new Font("Comic Sans MS",Font.BOLD,50);
						g.setFont(f1);
						g.setColor(Color.CYAN);
						g.drawString("GAME IS PAUSED PRESS ESC TO CONTINUE", 400 , 300 );
					}
					
					g.dispose();
				}
			
				if(m.level==2)
				{
					l2.paint(g);
					if(play==false)
					{
						Font f = new Font("Comic Sans MS",Font.BOLD,50);
						g.setFont(f);
						g.setColor(Color.BLACK);
						g.drawString("GAME IS PAUSED PRESS ESC TO CONTINUE", 400 , 300 );
					}
					
					g.dispose();
				}
				
				if(m.level==3)
				{
					l3.paint(g);
					if(play==false)
					{
						Font f = new Font("Comic Sans MS",Font.BOLD,50);
						g.setFont(f);
						g.setColor(Color.BLACK);
						g.drawString("GAME IS PAUSED PRESS ESC TO CONTINUE", 400 , 300 );
					}
					
					g.dispose();
				}
				
				if(m.level==4)
				{
					l4.paint(g);
					if(play==false)
					{
						Font f = new Font("Comic Sans MS",Font.BOLD,50);
						g.setFont(f);
						g.setColor(Color.BLACK);
						g.drawString("GAME IS PAUSED PRESS ESC TO CONTINUE", 400 , 300 );
					}
					g.dispose();
				}
		}
		
		else if(lost==false)
		{
			m.paint(g);
		}
		
		else 
		{
			m.menuselected=1;
			lose.paint(g);
		}
		
		final long end = System.nanoTime();
		sum =(int) ((end - start) / 1000000);
	
		if(sum<10){
			
			try {
				Thread.sleep(Math.abs(10-sum));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		timer.start();
	
		sounds.m2();
		if(quitgame)
		{
			System.exit(0);
		}
		
		
		if(play&&startgame)
		{
			if(m.level==1)
			{
				try {
					Thread.sleep(6);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				controls(l1.player1, l1.egg1);
				if(l1.player1.health<0)
				{
					sounds.lostsound();
					lose.score=l1.player1.score;
					lost=true;
					l1.resetL1();
					resetgame();
				}
				if(l1.player1.score>=1000)
				{
					m.level=2;
				}
				l1.level1();
			}
			if(m.level==2)
			{
				try {
					Thread.sleep(4);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				controls(l2.player1,l2.egg1);
				if(l2.player1.health<0)
				{
					sounds.lostsound();
					lose.score=l2.player1.score;
					lost=true;
					l2.resetL2();
					resetgame();
				}
				if(l2.player1.score>=1000)
				{
					m.level=3;
				}
				l2.level2();
			}
			if(m.level==3)
			{
				try {
					Thread.sleep(2);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				controls(l3.player1,l3.egg1);
				if(l3.player1.health<0)
				{
					sounds.lostsound();
					lose.score=l3.player1.score;
					lost=true;
					l3.resetL3();
					resetgame();
				}
				if(l3.player1.score>=1000)
				{
					m.level=4;
				}
				l3.level3();
			}
			if(m.level==4)
			{
				try {
					Thread.sleep(0);
				} catch (InterruptedException e1) {
					
					e1.printStackTrace();
				}
				controls(l4.player1,l4.egg1);
				if(l4.player1.health<0)
				{
					sounds.lostsound();
					lose.score=l4.player1.score;
					lost=true;
					l4.resetL4();
					resetgame();
				}
				l4.level4();
			}
			
		}		
		else
		{
			BackGround.Movement();
		}
		
		
				repaint();
				
			
	}
	
	void resetgame()
	{
		play=false;
		startgame=false;
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
			sounds.eggsound();
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public synchronized void keyPressed(KeyEvent e) 
	{
		
		if(e.getKeyCode()== KeyEvent.VK_UP||e.getKeyCode()== KeyEvent.VK_W)
		{
			up=true;
			m.menuselected-=1;
			if(m.menuselected==-1)
			{
				m.menuselected=2;
			}
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN||e.getKeyCode()== KeyEvent.VK_S)
		{
			down=true;
			m.menuselected+=1;
			if(m.menuselected==3)
			{
				m.menuselected=0;
			}
		}
		if(e.getKeyCode()== KeyEvent.VK_RIGHT||e.getKeyCode()== KeyEvent.VK_D) 
		{
			right=true;
		}
	
		if(e.getKeyCode()== KeyEvent.VK_LEFT||e.getKeyCode()== KeyEvent.VK_A) 
		{
			left=true;
		}
		if(e.getKeyCode()== KeyEvent.VK_SPACE) 
		{
			spacebar=true;
			lost=false;
			if(startgame==false)
			{
				if(m.showlevelsmenu==false)
				{
					if(m.menuselected==0)
					{
						startgame=true;
						m.level=1;
						BackGround.Refresh();
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
						m.level=1;
					}
					if(m.menuselected==1)
					{
						m.level=2;
					}
					if(m.menuselected==2)
					{		
						m.level=3;
					}
					BackGround.Refresh();
					startgame=true;
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
		
		if(e.getKeyCode()==KeyEvent.VK_4)
		{
			lost=false;
			if(startgame==false)
			{
				startgame=true;
				m.level=4;
			}
		}	
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode()== KeyEvent.VK_UP||e.getKeyCode()== KeyEvent.VK_W)
		{
			up=false;
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN||e.getKeyCode()== KeyEvent.VK_S)
		{
			down=false;
		}
		if(e.getKeyCode()== KeyEvent.VK_RIGHT||e.getKeyCode()== KeyEvent.VK_D) 
		{
			right=false;
		}
	
		if(e.getKeyCode()== KeyEvent.VK_LEFT||e.getKeyCode()== KeyEvent.VK_A) 
		{
			left=false;
		}
		if(e.getKeyCode()== KeyEvent.VK_SPACE) 
		{
			spacebar=false;
		}
		
	}
}
