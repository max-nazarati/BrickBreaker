package brickbreaker.entity;

import java.awt.Graphics;

import main.BrickBreaker;

public class Board {
	private static final int width = 80, height = 10;
	private int x = 290, y = 400, up, down;
	private BrickBreaker game;

	public Board(BrickBreaker game, int left, int right, int width) {
		this.game = game;
	}
	
	public void update() {
		
	}
	
	public void pressed(int keyCode) {
		
	}
	
	public void released(int keyCode) {
		
	}
	
	public void paint(Graphics g) {
		g.fillRect(x, y, width, height);
	}
}
