package brickbreaker.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.BrickBreaker;

public class Ball {
	
	private enum ColSide {
		right, left, bottom, top
	}
	private static final int width = 30, height = 30;
	private float x = 50, y = 50;
	private BrickBreaker game;
	private float dx = 0.5f;
	private float dy = 0.5f;
	private Board board;
	private Border leftBorder;
	private Border topBorder;
	private Border rightBorder;
	public Ball(BrickBreaker game) {
		this.game = game;
	}
	
	public void update() {
		x += dx;
		y += dy;
		checkCollision();
	}
	
	private void checkCollision() {
		leftBorder = game.getPanel().getLeftBorder();
		topBorder = game.getPanel().getTopBorder();
		rightBorder = game.getPanel().getRightBorder();
		board = game.getPanel().getBoard();
		if (board.getBounds().intersects(getBounds()))
			changeDy(-1);
		if (leftBorder.getBounds().intersects(getBounds()))
			changeDx(-1);
		if (topBorder.getBounds().intersects(getBounds()))
			changeDy(-1);
		if (rightBorder.getBounds().intersects(getBounds()))
			changeDx(-1);
	}
	
	public void changeDx(int factor) {
		dx *= factor;
	}
	
	public void changeDy(int factor) {
		dy *= factor;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(Math.round(x), Math.round(y), width, height);
	}
	public void paint(Graphics g) {
		g.fillRect(Math.round(x), Math.round(y), width, height);
	}
}
