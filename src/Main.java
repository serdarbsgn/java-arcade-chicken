import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args, int resx,int resy) {
		JFrame m = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		Game gamePlay = new Game(resx,resy);
		if(resx==width&&resy==height)
		{
			m.setUndecorated(true);
		}
		
		m.setBounds(0, 0, resx, resy);
		m.setTitle("Homework");
		m.setVisible(true);
		m.setResizable(false);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.add(gamePlay);
			
		
	}
}
