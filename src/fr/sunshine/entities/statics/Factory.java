package fr.sunshine.entities.statics;

import java.awt.Graphics;

import fr.sunshine.Handler;
import fr.sunshine.gfx.Assets;
import fr.sunshine.items.Item;
import fr.sunshine.tiles.Tile;

public class Factory extends StaticEntity {

	public Factory(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

		bounds.setBounds(28, getHeight() / 2 + 18, 8, 30);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.factory, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int) x, (int) y));
	}

}
