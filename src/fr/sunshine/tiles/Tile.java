package fr.sunshine.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	public static Tile[] tiles = new Tile[256];

	public static Tile GRASS = new GrassTile(0);
	public static Tile DIRT = new DirtTile(1);
	public static Tile WALL = new WallTile(2);
	public static Tile WATER = new WaterTile(3);
	public static Tile ROCK = new RockTile(4);

	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;

		tiles[id] = this;
	}

	public void tick() {
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}

	public boolean isSolid() {
		return false;
	}

	public int getId() {
		return id;
	}

}
