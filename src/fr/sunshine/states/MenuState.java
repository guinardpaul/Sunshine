package fr.sunshine.states;

import java.awt.Color;
import java.awt.Graphics;

import fr.sunshine.Handler;
import fr.sunshine.gfx.Assets;
import fr.sunshine.gfx.Text;
import fr.sunshine.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;
	private final String[] options = { "Start", "About", "Instructions" };
	private int selected = 0;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		// uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.start_button,
		// new ClickListener() {
		//
		// @Override
		// public void onClick() {
		// handler.getMouseManager().setUIManager(null);
		// State.setState(handler.getGame().gameState);
		// }
		// }));
	}

	@Override
	public void tick() {
		if (handler.getKeyManager().down.clicked) {
			selected++;
		}

		if (handler.getKeyManager().up.clicked) {
			selected--;
		}

		if (selected < 0) {
			selected = options.length - 1;
		}
		if (selected > options.length - 1) {
			selected = 0;
		}

		if (handler.getKeyManager().menu.clicked) {
			if (options[selected] == options[0]) {
				State.setState(handler.getGame().gameState);
			} else if (options[selected] == options[1]) {
				// TODO
			} else if (options[selected] == options[2]) {
				State.setState(handler.getGame().instructionState);
			}
		}

		// uiManager.tick();
		// System.out.println(handler.getMouseManager().getMouseX() + " " +
		// handler.getMouseManager().getMouseY());
		// if (handler.getMouseManager().isLeftPressed() &&
		// handler.getMouseManager().isRightPressed()) {
		// getState().setState(handler.getGame().gameState);
		// }
		// handler.getMouseManager().setUIManager(null);
		// State.setState(handler.getGame().gameState);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());

		for (int i = 0; i < options.length; i++) {
			String msg = options[i];
			if (i == selected) {
				msg = "> " + msg + " <";
			}
			Text.drawString(g, msg, handler.getWidth() / 2 - msg.length() / 2, 100 + i * 75, true, Color.BLUE,
					Assets.font28);
		}

		// uiManager.render(g);
		// g.setColor(Color.RED);
		// g.fillRect(handler.getMouseManager().getMouseX(),
		// handler.getMouseManager().getMouseY(), 8, 8);
	}

}
