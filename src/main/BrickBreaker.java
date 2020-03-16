package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class BrickBreaker extends JFrame implements ActionListener{
	private final static int WIDTH = 700, HEIGHT = 450;
	private boolean over = false;
	BrickBreakerPanel gamePanel;
	GameOverPanel gameOverPanel;
	BrickBreaker() {
		setSize(WIDTH, HEIGHT);
		setTitle("Brick Breaker");
		setBackground(Color.LIGHT_GRAY);
		gamePanel = new BrickBreakerPanel(this);
		gameOverPanel = new GameOverPanel(this);
		add(gamePanel);
		add(new MenuPanel(this), BorderLayout.SOUTH);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Timer timer = new Timer(200, this);
		timer.start();
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

	private void update() {
		if (gamePanel.getBlocks().isEmpty() && !over) {
			over = true;
			remove(gamePanel);
			add(gameOverPanel);
			revalidate();
			repaint();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		
	}
}
