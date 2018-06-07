package fr.sunshine.ui;

import java.awt.Color;
import java.awt.Graphics;

import fr.sunshine.gfx.Assets;
import fr.sunshine.gfx.Text;
import fr.sunshine.items.Item;

public class UIBox extends UIObject {

	private static final int BOX_SIZE = 32;
	private ClickListener clicker;
	private Item item;
	private Item selectedItem = null;

	public UIBox(Item item, float x, float y, ClickListener clicker) {
		super(x, y, BOX_SIZE, BOX_SIZE);
		this.item = item;
		this.clicker = clicker;
	}

	public UIBox(float x, float y, ClickListener clicker) {
		super(x, y, BOX_SIZE, BOX_SIZE);
		this.item = null;
		this.clicker = clicker;
	}

	@Override
	public void tick() {
		// Nothing to do
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		if (hover) {
			g.setColor(Color.BLUE);
			if (this.getItem() != null) {
				Text.drawString(g, this.getItem().getName(), (int) (x + BOX_SIZE / 2), (int) y, true, Color.BLACK,
						Assets.font28);
			}
		}
		g.drawRect((int) x, (int) y, width, height);
		if (item != null) {
			g.drawImage(item.getTexture(), (int) x, (int) y, BOX_SIZE, BOX_SIZE, null);
			if (item.getCount() > 1) {
				Text.drawString(g, Integer.toString(item.getCount()), (int) (x + BOX_SIZE), (int) (y + BOX_SIZE), true,
						Color.BLACK, Assets.font28);
			}
		}
		if (selectedItem != null) {
			g.drawImage(selectedItem.getTexture(), (int) (x + 10), (int) y, BOX_SIZE, BOX_SIZE, null);
		}
	}

	@Override
	public void onClick() {
		System.out.println("UIBox clicked : x=" + x + ", y=" + y);
		selectedItem = this.getItem();
		clicker.onClick();
	}

	// public void addItem(Item i) {
	// if (this.getItem() != null)
	// return;
	// this.setItem(i);
	// }

	// GETTERS AND SETTERS
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
