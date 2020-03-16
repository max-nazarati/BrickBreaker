package brickbreaker.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

import main.BrickBreaker;

public class Board extends JComponent {
	private static final int width = 80, height = 10;
	private int x = 290, y = 390;
	private int xd = 0;
	private BrickBreaker game;
	private int speed = 1;

	public Board(BrickBreaker game, int left, int right, int width) {
		this.game = game;
	}
	
	public void update() {
		if (x > 0 && x < game.getWidth() - width) {
			x += xd;
		}
		else if (x == 0) {
			x++;
		}
		else if (x == game.getWidth() - width) {
			x--;
		}
	}
	
	public void pressed(int keyCode) {
		if (keyCode == KeyEvent.VK_RIGHT) {
			xd = speed;
		} else if (keyCode == KeyEvent.VK_LEFT) {
			xd = -speed;
		}
	}
	
	public void released(int keyCode) {
		if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT) {
			xd = 0;
		}
	}
	
	public void paint(Graphics g) {
		g.fillRect(x, y, width, height);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
}
