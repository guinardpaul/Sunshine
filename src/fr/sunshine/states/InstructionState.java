package fr.sunshine.states;

import java.awt.Color;
import java.awt.Graphics;

import fr.sunshine.Handler;
import fr.sunshine.gfx.Assets;
import fr.sunshine.gfx.Text;

public class InstructionState extends State {

	private final String[] aboutMsg = { "use arrow keys to move", "use e to interact", "use c to attack" };

	public InstructionState(Handler handler) {
		super(handler);
	}

	@Override
	public void tick() {
		if (handler.getKeyManager().menu.clicked) {
			State.setState(handler.getGame().menuState);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());

		for (int i = 0; i < aboutMsg.length; i++) {
			String msg = aboutMsg[i];
			Text.drawString(g, msg, handler.getWidth() / 2 - msg.length() / 2, 100 + i * 50, true, Color.BLUE,
					Assets.font28);
		}

		String returnText = "press e to return to the menu";
		Text.drawString(g, returnText, handler.getWidth() / 2 - returnText.length() / 2, handler.getHeight() - 50, true,
				Color.BLUE, Assets.font28);
	}

}
