package fr.sunshine.screen;

import java.awt.Color;
import java.awt.Graphics;

import fr.sunshine.gfx.Assets;
import fr.sunshine.gfx.Text;

public class TitleMenu extends Menu {

	private int selected = 0;
	private final String[] options = { "Start game", "About", "Instructions" };

	@Override
	public void tick() {
		if (input.down.clicked) {
			selected++;
		}
		if (input.up.clicked) {
			selected--;
		}

		int len = options.length;
		if (selected < 0)
			selected = 0;

		if (selected >= len)
			selected = len - 1;

		if (input.attack.clicked || input.menu.clicked) {
			if (options[selected] == options[0]) {
				game.setMenu(null);
			} else if (options[selected] == options[1]) {
				game.setMenu(new AboutMenu());
			} else if (options[selected] == options[2]) {
				game.setMenu(new InstructionMenu());
			}
		}

	}

	@Override
	public void render(Graphics g) {
		clearScreen(g);

		for (int i = 0; i < options.length; i++) {
			String msg = options[i];
			if (selected == i) {
				msg = "> " + msg + " <";
			}
			Text.drawString(g, msg, (game.getWidth() - msg.length()) / 2, 100 + i * 50, true, Color.BLUE,
					Assets.font28);
		}
	}

}
