package main;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BrickBreaker extends JFrame {
	private final static int WIDTH = 700, HEIGHT = 450;
	BrickBreakerPanel gamePanel;
	
	BrickBreaker() {
		setSize(WIDTH, HEIGHT);
		setTitle("Brick Breaker");
		setBackground(Color.LIGHT_GRAY);
		gamePanel = new BrickBreakerPanel(this);
		add(gamePanel);
		add(new MenuPanel(this), BorderLayout.SOUTH);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
	
	public BrickBreakerPanel getPanel() {
		return gamePanel;
	}
}
