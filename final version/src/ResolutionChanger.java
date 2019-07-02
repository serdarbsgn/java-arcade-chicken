import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResolutionChanger {

	private JFrame frmResolutionSelector;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResolutionChanger window = new ResolutionChanger();
					window.frmResolutionSelector.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResolutionChanger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmResolutionSelector = new JFrame();
		frmResolutionSelector.setTitle("Resolution Selector");
		frmResolutionSelector.setBounds(100, 100, 450, 300);
		frmResolutionSelector.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmResolutionSelector.getContentPane().setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		
		String[] ResolutionStrings = { "Default","1920x1080", "1440x900", "1280x720", "800x600", "640x480" };
		JComboBox<?> comboBox = new JComboBox<Object>(ResolutionStrings);
		comboBox.setBounds(150, 50, 150, 30);
		frmResolutionSelector.getContentPane().add(comboBox);
		
		JButton btnLaunchGame = new JButton("Launch Game");
		btnLaunchGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String value = (String)comboBox.getSelectedItem();
				
					if(value=="1920x1080")
					{
						Main.main(null, 1920,1080);
					}
					else if (value=="1440x900")
					{
						Main.main(null,1440, 900);
					}
					else if (value=="1280x720")
					{
						Main.main(null, 1280,720);
					}
					else if (value=="800x600")
					{
						Main.main(null,800, 600);
					}
					else if (value=="640x480")
					{
						Main.main(null, 640,480);
					}
					else if (value=="Default")
					{
						Main.main(null, width, height);
					}
					
				frmResolutionSelector.setVisible(false);
			}
		});
		btnLaunchGame.setBounds(150, 150, 150, 30);
		frmResolutionSelector.getContentPane().add(btnLaunchGame);
	}
}
