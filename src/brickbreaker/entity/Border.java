package brickbreaker.entity;

import java.awt.Rectangle;

public class Border {
	private Rectangle bounds;
	public Border(int x, int y, int width, int height) {
		this.bounds = new Rectangle(x, y, width, height);
	}
	public Rectangle getBounds() {
		return bounds;
	}
}
