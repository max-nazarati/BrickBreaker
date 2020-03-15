package brickbreaker.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import main.BrickBreaker;

public class Ball {
	
	private enum ColSide {
		right, left, bottom, top
	}
	private static final int width = 10, height = 10;
	private float x = 10, y = 10;
	private BrickBreaker game;
	private float dx = 0.5f;
	private float dy = 0.5f;
	private Board board;
	private Border leftBorder;
	private Border topBorder;
	private Border rightBorder;
	private List<Block> blocks;
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
		blocks = game.getPanel().getBlocks();

		if (board.getBounds().intersects(getBounds()))
			changeDy(-1);
		if (leftBorder.getBounds().intersects(getBounds()))
			changeDx(-1);
		if (topBorder.getBounds().intersects(getBounds()))
			changeDy(-1);
		if (rightBorder.getBounds().intersects(getBounds()))
			changeDx(-1);
		
		for (Block block : blocks) {
			if (block.getTopEdge().intersects(getBounds())) {
				changeDy(-1);
			}
			else if (block.getRightEdge().intersects(getBounds())){
				changeDx(-1);
			}
			else if (block.getBottomEdge().intersects(getBounds())) {
				changeDy(-1);
			}
			else if (block.getLeftEdge().intersects(getBounds())) {
				changeDx(-1);
			}
		}
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
