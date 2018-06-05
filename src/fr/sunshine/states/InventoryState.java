package fr.sunshine.states;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import fr.sunshine.Handler;
import fr.sunshine.items.Item;
import fr.sunshine.ui.ClickListener;
import fr.sunshine.ui.UIBox;
import fr.sunshine.ui.UIGrid;
import fr.sunshine.ui.UIManager;

public class InventoryState extends State {

	private UIManager uiManager;
	private List<UIBox> boxes;

	public InventoryState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		boxes = new ArrayList<>();
		initInventory();
	}

	private void initInventory() {
		boxes = UIGrid.createGrid(100, 20, 10, 6, 32, new ClickListener() {
			@Override
			public void onClick() {
				// Nothing ToDo
			}
		});

		addItem(Item.rockItem);
		addItem(Item.woodItem);
		addItem(Item.rockItem);
		addItem(Item.woodItem);
		addItem(Item.rockItem);
		addItem(Item.woodItem);
		addItem(Item.rockItem);

		for (UIBox b : boxes) {
			uiManager.addObject(b);
		}

		// uiManager.addObject(new UIGrid(100, 20, 10, 6, new ClickListener() {
		// @Override
		// public void onClick() {
		// // TODO Auto-generated method stub
		// }
		// }));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

	public void addItem(Item i) {
		if (i.isStackable()) {
			boolean added = false;
			for (UIBox b : boxes) {
				if (b.getItem() == i) {
					b.getItem().setCount(b.getItem().getCount() + 1);
					added = true;
					break;
				}
			}
			if (!added) {
				for (UIBox b : boxes) {
					if (b.getItem() == null) {
						b.setItem(i);
						break;
					}
				}
			}
		} else {
			for (UIBox b : boxes) {
				if (b.getItem() == null) {
					b.setItem(i);
					break;
				}
			}
		}
	}

}
