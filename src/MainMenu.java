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
	
	protected Rectangle playButton;
	protected Rectangle levelButton;
	protected Rectangle quitButton;
	
	protected int level=0;
	protected boolean showlevelsmenu= false;
	protected int resolutionx,resolutiony;
	
	protected int menuselected = 0;
	BackGround main;
	protected MainMenu(int resx,int resy)
	{
		resolutionx=resx;
		resolutiony=resy;
		playButton = new Rectangle((int)(resx/2.5),(int)((0.25)*resy),(int)(resx/(4.8)),(int)(resy/(5.4)));
		levelButton = new Rectangle((int)(resx/2.5),(int)((0.45)*resy),(int)(resx/(4.8)),(int)(resy/(5.4)));
		quitButton = new Rectangle((int)(resx/2.5),(int)((0.65)*resy),(int)(resx/(4.8)),(int)(resy/(5.4)));
		main = new BackGround(resolutionx,resolutiony);
		setVisible(true);	
	} 
	
		
	public void paint(Graphics g)
	{
		if(level==0||level==1)
		{
			g.drawImage(BackGround.backgroundstar, 0, BackGround.backgroundY, resolutionx, resolutiony, null);
			g.drawImage(BackGround.backgroundstar, 0, BackGround.backgroundY2, resolutionx, resolutiony, null);
		}
		if(level==2||level==3||level==4)
		{
			g.drawImage(BackGround.backgroundcloud, 0, BackGround.backgroundY,resolutionx, resolutiony, null);
			g.drawImage(BackGround.backgroundcloud, 0, BackGround.backgroundY2,resolutionx, resolutiony, null);
		}
		if(showlevelsmenu==false)
		{
			
			Graphics2D g2d = (Graphics2D) g;
			Font f = new Font("Comic Sans MS",Font.BOLD,(int)(resolutionx/19.2));
			g.setFont(f);
			g.setColor(Color.WHITE);
			g.drawString("Chicken Game", (int)((resolutionx/3)),(int)(resolutiony/10));
			
			Font f1 = new Font("Comic Sans MS",Font.BOLD,(int)(resolutionx/38.4));
			g.setFont(f1);
			if(menuselected%3==0)
			{
				g.setColor(Color.BLUE);
				g.drawString("PLAY!!!", (int)(resolutionx/2.25),(int)((0.35)*resolutiony));
				g2d.draw(playButton);
			}
			else
			{
				g.setColor(Color.WHITE);
				g.drawString("PLAY!!!", (int)(resolutionx/2.25),(int)((0.35)*resolutiony));
				g2d.draw(playButton);
			}
			
			if(menuselected%3==1)
			{
				g.setColor(Color.BLUE);
				g.drawString("LEVELS", (int)(resolutionx/2.25),(int)((0.55)*resolutiony));
				g2d.draw(levelButton);
			}
			else
			{
				g.setColor(Color.WHITE);
				g.drawString("LEVELS", (int)(resolutionx/2.25),(int)((0.55)*resolutiony));
				g2d.draw(levelButton);
			}
			if(menuselected%3==2)
			{
				g.setColor(Color.BLUE);
				g.drawString("QUIT :(", (int)(resolutionx/2.25),(int)((0.75)*resolutiony));
				g2d.draw(quitButton);
			}
			else
			{
				g.setColor(Color.WHITE);
				g.drawString("QUIT :( ", (int)(resolutionx/2.25),(int)((0.75)*resolutiony));
				g2d.draw(quitButton);
			}
			g.setColor(Color.WHITE);
			g.drawString("Space = Select", (int)(resolutionx/1.5),(int)((0.55)*resolutiony));
			
			g.dispose();
			g2d.dispose();
		}
		
		if(showlevelsmenu)
		{
			Graphics2D g2d = (Graphics2D) g;
			Font f = new Font("Comic Sans MS",Font.BOLD,(int)(resolutionx/19.2));
			g.setFont(f);
			g.setColor(Color.WHITE);
			g.drawString("SELECT LEVEL", (int)((resolutionx/3)), (int)(resolutiony/10));
			Font f1 = new Font("Arial",Font.BOLD,(int)(resolutionx/38.4));
			g.setFont(f1);
			
			if(menuselected%3==0)
			{
				g.setColor(Color.BLUE);
				g.drawString("LEVEL 1", (int)(resolutionx/2.25),(int)((0.35)*resolutiony));
				g2d.draw(playButton);
			}
			else
			{
				g.setColor(Color.WHITE);
				g.drawString("LEVEL 1", (int)(resolutionx/2.25),(int)((0.35)*resolutiony));
				g2d.draw(playButton);
			}
			
			if(menuselected%3==1)
			{
				g.setColor(Color.BLUE);
				g.drawString("LEVEL 2",(int)(resolutionx/2.25),(int)((0.55)*resolutiony));
				g2d.draw(levelButton);
			}
			else
			{
				g.setColor(Color.WHITE);
				g.drawString("LEVEL 2", (int)(resolutionx/2.25),(int)((0.55)*resolutiony));
				g2d.draw(levelButton);
			}
			if(menuselected%3==2)
			{
				g.setColor(Color.BLUE);
				g.drawString("LEVEL 3", (int)(resolutionx/2.25),(int)((0.75)*resolutiony));
				g2d.draw(quitButton);
			}
			else
			{
				g.setColor(Color.WHITE);
				g.drawString("LEVEL 3", (int)(resolutionx/2.25),(int)((0.75)*resolutiony));
				g2d.draw(quitButton);
			}
			g.setColor(Color.WHITE);
			g.drawString("Backspace = back", (int)(resolutionx/1.5),(int)((0.55)*resolutiony));
			
			g.dispose();
			g2d.dispose();
		}
	}
}
