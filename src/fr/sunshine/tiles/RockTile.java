package fr.sunshine.tiles;

import fr.sunshine.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.rock, id);
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
