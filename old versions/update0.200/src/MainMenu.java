import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainMenu extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2264702928814939L;
	
	public Rectangle playButton = new Rectangle(760,200,400,200);
	public Rectangle optionsButton = new Rectangle(760,500,400,200);
	public Rectangle quitButton = new Rectangle(760,800,400,200);
	
	Font myFont = new Font ("Arial Bold", 1, 78);
	protected int menuselected = 0;
	protected boolean select = false;
	private Timer timer;
	private int delay =	0;
	private BufferedImage background;
	private int backgroundY=0;
	private int backgrounddelayer=0;
	private int backgroundY2=1080;
	public MainMenu()
	{
		try {                
	        background = ImageIO.read(new File("src\\star.jpg"));
	     } catch (IOException ex) {}
		setVisible(true);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
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
		
		repaint();
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(background, 0, backgroundY, 1920, 1080, null);
		g.drawImage(background, 0, backgroundY2, 1920, 1080, null);
		
		Graphics2D g2d = (Graphics2D) g;
		Font f = new Font("Arial",Font.BOLD,100);
		g.setFont(f);
		g.setColor(Color.WHITE);
		g.drawString("Chick", 760, 150);
		
		Font f1 = new Font("Arial",Font.BOLD,50);
		g.setFont(f1);
		if(menuselected%3==0)
		{
			g.setColor(Color.BLUE);
			g.drawString("PLAY!!!", 800, 250);
			g2d.draw(playButton);
		}
		else
		{
			g.setColor(Color.WHITE);
			g.drawString("PLAY!!!", 800, 250);
			g2d.draw(playButton);
		}
		
		if(menuselected%3==1)
		{
			g.setColor(Color.BLUE);
			g.drawString("LUL", 800, 550);
			g2d.draw(optionsButton);
		}
		else
		{
			g.setColor(Color.WHITE);
			g.drawString("LUL", 800, 550);
			g2d.draw(optionsButton);
		}
		if(menuselected%3==2)
		{
			g.setColor(Color.BLUE);
			g.drawString("QUIT", 800, 850);
			g2d.draw(quitButton);
		}
		else
		{
			g.setColor(Color.WHITE);
			g.drawString("QUIT", 800, 850);
			g2d.draw(quitButton);
		}
	}

	
	public boolean startgame()
	{
			return select;	
	}
}
