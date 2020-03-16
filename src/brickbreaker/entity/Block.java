package brickbreaker.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;

import main.BrickBreaker;

public class Block {
	private BrickBreaker game;
	public static final int width = 100, height = 30, gap = 0;
	private Rectangle bounds;
	private int x, y;
	private Line2D.Double topEdge, rightEdge, bottomEdge, leftEdge;
	public Block(int x, int y) {
		this.x = x;
		this.y = y;
		topEdge = new Line2D.Double(x, y, x + width + gap, y+ gap);
		rightEdge = new Line2D.Double(x + width, y, x + width+ gap, y + height+ gap);
		bottomEdge = new Line2D.Double(x, y + height, x + width+ gap, y + height+ gap);
		leftEdge = new Line2D.Double(x, y, x+ gap, y + height+ gap);
		bounds = new Rectangle(x, y, width+ gap, height+ gap);
	}
	
	public Line2D.Double getBottomEdge() {
		return bottomEdge;
	}

	public Line2D.Double getTopEdge() {
		return topEdge;
	}

	public Line2D.Double getRightEdge() {
		return rightEdge;
	}

	public Line2D.Double getLeftEdge() {
		return leftEdge;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void paint(Graphics g) {
		g.fillRect(x, y, width, height);
	}

}
