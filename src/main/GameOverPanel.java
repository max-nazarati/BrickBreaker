package main;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel {
	private BrickBreaker game;
	GameOverPanel(BrickBreaker game){
		this.game = game;
		JLabel label = new JLabel("GAME OVER");
		setLayout(new BorderLayout());
		add(label);
	}
}
