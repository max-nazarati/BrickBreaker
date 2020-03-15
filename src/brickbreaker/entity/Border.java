package brickbreaker.entity;

import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class Border {
	private Line2D.Double edge;
	public Border(int x1, int y1, int x2, int y2) {
		this.edge = new Line2D.Double(x1, y1, x2, y2);
	}
	public Line2D.Double getBounds() {
		return edge;
	}
}
