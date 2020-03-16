package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MenuPanel extends JPanel implements ActionListener {
	private boolean gamePaused = false;
	private boolean gameEnded = false;
	private BrickBreaker game;
	private JButton newGameButton;
	private JButton pauseButton;
	
	public MenuPanel(BrickBreaker game) {
		this.game = game;
		setBackground(Color.green);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		newGameButton = new JButton("NEW GAME");
		newGameButton.setPreferredSize(new Dimension(80, 20));
		newGameButton.setEnabled(false);
		
		pauseButton = new JButton("PAUSE");
		pauseButton.addActionListener(this);
		
		add(pauseButton);
		add(newGameButton);
		Timer timer = new Timer(100, this);
		timer.start();
		setFocusable(true);

	}
	
	private void checkButtons(ActionEvent e) {
		if (e.getSource() == pauseButton) {
			if (game.getPanel().getTimer().isRunning()) {
				game.getPanel().getTimer().stop();
				return;
			}
			game.getPanel().getTimer().restart();
		}
	}
	private void update(ActionEvent e) {
		if (game.getPanel().getBlocks().isEmpty())
			newGameButton.setEnabled(true);
		checkButtons(e);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		update(e);
		repaint();
		
	}
}
