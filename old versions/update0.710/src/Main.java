import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		JFrame m = new JFrame();
		Game gamePlay = new Game();	
		m.setBounds(0, 0, 1920, 1080);
		m.setTitle("Homework");
		m.setVisible(true);
		m.setResizable(false);
		m.setFocusableWindowState(true);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.add(gamePlay);
			
		
	}
}
