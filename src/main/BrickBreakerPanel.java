package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import brickbreaker.entity.Ball;
import brickbreaker.entity.Block;
import brickbreaker.entity.Board;

public class BrickBreakerPanel extends JPanel implements ActionListener, KeyListener{
	private BrickBreaker game;
	private Ball ball;
	private Board board;
	private List<Block> blocks;
	public BrickBreakerPanel(BrickBreaker game) {
		setBackground(Color.WHITE);
		this.game = game;
		ball = new Ball(game);
		board = new Board(game, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, game.getWidth());
		Timer timer = new Timer(5, this);
		timer.start();
		addKeyListener(this);
		setFocusable(true);
	}
	public Ball getBall() {
		return ball;
	}
	public Board getBoard() {
		return board;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO nothing to do
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball.paint(g);
		board.paint(g);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		board.pressed(e.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		board.released(e.getKeyCode());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
	}
	
	private void update() {
		ball.update();
		board.update();
	}
}
