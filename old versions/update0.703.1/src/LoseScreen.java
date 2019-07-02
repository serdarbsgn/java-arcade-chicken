import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LoseScreen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7937584540431536194L;
	
	protected int score;
	protected BufferedImage lose;
	
	public LoseScreen()
	{
		score=0;
		try {                
		       lose = ImageIO.read(new File("src\\lose.jpg"));
		     } catch (IOException ex) { }
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		g.drawImage(lose, 0, 0, 1920, 1080, null);
		Font f = new Font("Comic Sans MS",Font.BOLD,100);
		g.setFont(f);
		g.setColor(Color.BLACK);
		g.drawString("YOU LOST!!!", 625, 150);
		g.drawString("YOUR SCORE IS    " + score, 550, 900);
		
	}
}
