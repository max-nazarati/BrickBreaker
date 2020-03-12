package brickbreaker.entity;

import java.awt.Graphics;

import main.BrickBreaker;

public class Ball {
	private static final int width = 30, height = 30;
	private int x = 50, y = 50, xa = 2, ya = 2;
	private BrickBreaker game;
	public Ball(BrickBreaker game) {
		this.game = game;
	}
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		g.fillRect(x, y, width, height);
	}
}
