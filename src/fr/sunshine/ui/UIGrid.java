package fr.sunshine.ui;

import java.util.ArrayList;
import java.util.List;

/** Class to create GRID composed of UIBox Object */
public class UIGrid {

	public static List<UIBox> createGrid(float xPos, float yPos, int width, int height, final int BOX_SIZE,
			ClickListener clicker) {
		List<UIBox> grid = new ArrayList<>();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				grid.add(new UIBox((int) (xPos + x * BOX_SIZE), (int) (yPos + y * BOX_SIZE), clicker));
			}
		}
		return grid;
	}

	// private static final int BOX_SIZE = 32;
	// private ClickListener clicker;
	// private List<UIBox> boxes;
	// private float x, y;
	// private int width, height;
	//
	// public UIGrid(float x, float y, int width, int height, ClickListener
	// clicker)
	// {
	// this.x = x;
	// this.y = y;
	// this.width = width;
	// this.height = height;
	// this.clicker = clicker;
	// boxes = new ArrayList<>();
	// initGrid();
	// }

	// public void initGrid() {
	// for (int y = 0; y < height; y++) {
	// for (int x = 0; x < width; x++) {
	// boxes.add(new UIBox((int) (this.x + x * BOX_SIZE), (int) (this.y + y *
	// BOX_SIZE), clicker));
	// }
	// }
	// }

	// public void tick() {
	// // TODO Auto-generated method stub
	// }
	//
	// public void render(Graphics g) {
	// // System.out.println("UIGrid :" + hover);
	// for (UIBox b : boxes) {
	// b.render(g);
	// }
	// }

}
