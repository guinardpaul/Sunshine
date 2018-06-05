package fr.sunshine;

import fr.sunshine.gfx.GameCamera;
import fr.sunshine.input.KeyManager;
import fr.sunshine.input.MouseManager;
import fr.sunshine.world.World;

public class Handler {

	private Game game;
	private World world;

	public Handler(Game game) {
		this.game = game;
	}

	public int getWidth() {
		return game.getWidth();
	}

	public int getHeight() {
		return game.getHeight();
	}

	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}

	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
