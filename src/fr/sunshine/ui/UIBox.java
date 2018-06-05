package fr.sunshine.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIBox extends UIObject {

	private static final int BOX_SIZE = 32;
	private ClickListener clicker;
	private BufferedImage texture;

	public UIBox(BufferedImage texture, float x, float y, ClickListener clicker) {
		super(x, y, BOX_SIZE, BOX_SIZE);
		this.texture = texture;
		this.clicker = clicker;
	}

	public UIBox(float x, float y, ClickListener clicker) {
		super(x, y, BOX_SIZE, BOX_SIZE);
		this.texture = null;
		this.clicker = clicker;
	}

	@Override
	public void tick() {
		// Nothing to do
	}

	@Override
	public void render(Graphics g) {
		// System.out.println("UIBox :" + hover);
		if (hover) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.BLACK);
		}
		g.drawRect((int) x, (int) y, width, height);
		if (texture != null) {
			g.drawImage(texture, (int) x, (int) y, BOX_SIZE, BOX_SIZE, null);
		}
	}

	@Override
	public void onClick() {
		System.out.println("UIBox clicked : x=" + x + ", y=" + y);
		clicker.onClick();
	}

}
