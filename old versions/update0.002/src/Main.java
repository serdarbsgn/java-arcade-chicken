import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame mainwindow = new JFrame();
		Gameplay gamePlay = new Gameplay();
		mainwindow.setBounds(0, 0, 1920, 1080);
		mainwindow.setTitle("Homework");
		mainwindow.setVisible(true);
		mainwindow.setResizable(false);
		mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainwindow.add(gamePlay);
	}

}
