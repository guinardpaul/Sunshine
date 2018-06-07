package fr.sunshine.screen;

import java.awt.Color;
import java.awt.Graphics;

import fr.sunshine.Game;
import fr.sunshine.input.KeyManager;

public class Menu {

	protected Game game;
	protected KeyManager input;

	public void init(Game game, KeyManager input) {
		this.game = game;
		this.input = input;
	}

	public void tick() {
	}

	public void render(Graphics g) {
	}

	public void clearScreen(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, game.getWidth(), game.getHeight());
	}

}
