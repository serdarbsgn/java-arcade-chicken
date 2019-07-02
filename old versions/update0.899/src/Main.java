import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args,int resx,int resy) {
		JFrame m = new JFrame();
		Game gamePlay = new Game(resx,resy);	
		m.setBounds(0, 0, resx, resy);
		m.setTitle("Homework");
		m.setVisible(true);
		m.setResizable(true);
		m.setFocusableWindowState(true);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.add(gamePlay);
			
		
	}
}
