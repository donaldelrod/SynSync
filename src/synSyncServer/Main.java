package synSyncServer;

import javax.swing.JFrame;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(600,600);
		add(new base());
	}
	
	
	
	
	public static void main(String[] args) {
		new Main();
	}
	
	
}