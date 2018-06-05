package fr.sunshine.items;

import java.awt.image.BufferedImage;

public class BasicItem extends Item {

	public BasicItem(BufferedImage texture, String name, int id) {
		super(texture, name, id);
		stackable = true;
	}

}
