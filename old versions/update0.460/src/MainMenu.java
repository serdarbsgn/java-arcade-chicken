import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class MainMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2264702928814939L;
	
	public Rectangle playButton = new Rectangle(760,200,400,200);
	public Rectangle levelButton = new Rectangle(760,500,400,200);
	public Rectangle quitButton = new Rectangle(760,800,400,200);
	
	public int level=0;
	public boolean showlevelsmenu= false;
	
	Font myFont = new Font ("Arial Bold", 1, 78);
	protected int menuselected = 0;
	BackGround main = new BackGround();
	public MainMenu()
	{
		setVisible(true);	
	} 
	
		
	public void paint(Graphics g)
	{
		if(level==0||level==1)
		{
			g.drawImage(main.backgroundstar, 0, main.backgroundY, 1920, 1080, null);
			g.drawImage(main.backgroundstar, 0, main.backgroundY2, 1920, 1080, null);
		}
		if(level==2)
		{
			g.drawImage(main.backgroundcloud, 0, main.backgroundY, 1920, 1080, null);
			g.drawImage(main.backgroundcloud, 0, main.backgroundY2, 1920, 1080, null);
		}
		if(showlevelsmenu==false)
		{
			
			Graphics2D g2d = (Graphics2D) g;
			Font f = new Font("Arial",Font.BOLD,100);
			g.setFont(f);
			g.setColor(Color.WHITE);
			g.drawString("Chicken Game", 625, 150);
			
			Font f1 = new Font("Arial",Font.BOLD,50);
			g.setFont(f1);
			if(menuselected%3==0)
			{
				g.setColor(Color.BLUE);
				g.drawString("PLAY!!!", 875, 315);
				g2d.draw(playButton);
			}
			else
			{
				g.setColor(Color.WHITE);
				g.drawString("PLAY!!!", 875, 315);
				g2d.draw(playButton);
			}
			
			if(menuselected%3==1)
			{
				g.setColor(Color.BLUE);
				g.drawString("LEVELS", 870, 615);
				g2d.draw(levelButton);
			}
			else
			{
				g.setColor(Color.WHITE);
				g.drawString("LEVELS", 870, 615);
				g2d.draw(levelButton);
			}
			if(menuselected%3==2)
			{
				g.setColor(Color.BLUE);
				g.drawString("QUIT :(", 875, 915);
				g2d.draw(quitButton);
			}
			else
			{
				g.setColor(Color.WHITE);
				g.drawString("QUIT :( ", 875, 915);
				g2d.draw(quitButton);
			}
			g.dispose();
			g2d.dispose();
		}
		
		if(showlevelsmenu)
		{
			Graphics2D g2d = (Graphics2D) g;
			Font f = new Font("Arial",Font.BOLD,100);
			g.setFont(f);
			g.setColor(Color.WHITE);
			g.drawString("SELECT LEVEL", 600 , 150);
			Font f1 = new Font("Arial",Font.BOLD,50);
			g.setFont(f1);
			
			if(menuselected%3==0)
			{
				g.setColor(Color.BLUE);
				g.drawString("LEVEL 1", 870, 315);
				g2d.draw(playButton);
			}
			else
			{
				g.setColor(Color.WHITE);
				g.drawString("LEVEL 1", 870, 315);
				g2d.draw(playButton);
			}
			
			if(menuselected%3==1)
			{
				g.setColor(Color.BLUE);
				g.drawString("LEVEL 2", 870, 615);
				g2d.draw(levelButton);
			}
			else
			{
				g.setColor(Color.WHITE);
				g.drawString("LEVEL 2", 870, 615);
				g2d.draw(levelButton);
			}
			if(menuselected%3==2)
			{
				g.setColor(Color.BLUE);
				g.drawString("LEVEL 3", 870, 915);
				g2d.draw(quitButton);
			}
			else
			{
				g.setColor(Color.WHITE);
				g.drawString("LEVEL 3", 870, 915);
				g2d.draw(quitButton);
			}
			g.setColor(Color.WHITE);
			g.drawString("Backspace = back", 1300 , 800);
			
			g.dispose();
			g2d.dispose();
		}
	}
}
