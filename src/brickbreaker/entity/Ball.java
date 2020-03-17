package brickbreaker.entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.List;
import java.util.Random;

import main.BrickBreaker;

public class Ball {
	
	private enum ColSide {
		right, left, bottom, top
	}
	private static final int width = 15, height = 15;
	private float x, y = 200;
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
		x = new Random().nextInt(game.getWidth() - 300) + 100;
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
		if (y >= game.getHeight()) {
			game.getPanel().getBlocks().clear();
		}
		checkBlockCollision();
	}
	
	private void checkBlockCollision() {
		Block b = null;
		for (Block block : blocks) {
			if (block.getTopEdge().intersects(getBounds())) {
				changeDy(-1);
				b = block;
			}
			else if (block.getRightEdge().intersects(getBounds())){
				b = block;
				changeDx(-1);
			}
			else if (block.getBottomEdge().intersects(getBounds())) {
				b = block;
				changeDy(-1);
			}
			else if (block.getLeftEdge().intersects(getBounds())) {
				b = block;
				changeDx(-1);
			}
		}
		if (b != null)
			game.getPanel().getBlocks().remove(b);
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
		((Graphics2D)g).fill(new Ellipse2D.Double(x, y, width, height));
	}
}
