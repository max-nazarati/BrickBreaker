package main;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BrickBreaker extends JFrame {
	private final static int WIDTH = 700, HEIGHT = 450;
	private BrickBreakerPanel panel;
	
	public BrickBreaker() {
		setSize(WIDTH, HEIGHT);
		setTitle("Brick Breaker");
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new BrickBreakerPanel(this);
		add(panel);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
	          public void run() {
	        	  new BrickBreaker();
	          }
	      });
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight(){
		return HEIGHT;
	}
}
