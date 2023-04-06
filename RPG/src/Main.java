import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public void makeFrameFullSize(JFrame aFrame) {
		aFrame.setSize(screenSize.width, screenSize.height);
	}
	
	//changes
	
	public Main () {
		super("BLOONS");
		//setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);
		
		Color RoyalBlue = new Color(70,125,51);
		
		setBackground(Color.black);
		
		getContentPane().add(play);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
		
		addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("CLOSING");
				play.writeToFile();
				System.exit(-1);
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				play.createFile();
				play.readFile();
			}});
			
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	

	public static void main(String[] args) {
		Main run = new Main();
		

	}


}