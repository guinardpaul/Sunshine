package fr.sunshine.screen;

import java.awt.Color;
import java.awt.Graphics;

import fr.sunshine.gfx.Assets;
import fr.sunshine.gfx.Text;

public class AboutMenu extends Menu {
	private final String[] infos = { "Description of the game", "use e to interact", "use c to attack" };

	@Override
	public void tick() {
		if (input.menu.clicked) {
			game.setMenu(new TitleMenu());
		}
	}

	@Override
	public void render(Graphics g) {
		clearScreen(g);

		for (int i = 0; i < infos.length; i++) {
			String msg = infos[i];
			Text.drawString(g, msg, (game.getWidth() - msg.length()) / 2, 100 + 50 * i, true, Color.BLUE,
					Assets.font28);
		}

		String returnText = "press e to return to the menu";
		Text.drawString(g, returnText, (game.getWidth() - returnText.length()) / 2, 100 + 50 * infos.length + 100, true,
				Color.BLUE, Assets.font28);
	}

}
