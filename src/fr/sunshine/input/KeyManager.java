package fr.sunshine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyManager implements KeyListener {
	public class Key {
		public int presses, absorbs;
		public boolean down, clicked;

		public Key() {
			keys.add(this);
		}

		public void toggle(boolean pressed) {
			if (pressed != down) {
				down = pressed;
			}
			if (pressed) {
				presses++;
			}
		}

		public void tick() {
			if (absorbs < presses) {
				absorbs++;
				clicked = true;
			} else {
				clicked = false;
			}
		}
	}

	public List<Key> keys = new ArrayList<Key>();

	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();
	public Key attack = new Key();
	public Key menu = new Key();

	public void releaseAll() {
		for (int i = 0; i < keys.size(); i++) {
			keys.get(i).down = false;
		}
	}

	public void tick() {
		for (int i = 0; i < keys.size(); i++) {
			keys.get(i).tick();
		}
	}

	public KeyManager() {
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		toggle(ke, true);
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		toggle(ke, false);
	}

	private void toggle(KeyEvent ke, boolean pressed) {
		if (ke.getKeyCode() == KeyEvent.VK_Z)
			up.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_S)
			down.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_Q)
			left.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_D)
			right.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_UP)
			up.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_DOWN)
			down.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_LEFT)
			left.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
			right.toggle(pressed);

		if (ke.getKeyCode() == KeyEvent.VK_TAB)
			menu.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_ALT)
			menu.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_ALT_GRAPH)
			menu.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_E)
			menu.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_SPACE)
			attack.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_CONTROL)
			attack.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_NUMPAD0)
			attack.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_INSERT)
			attack.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_ENTER)
			menu.toggle(pressed);

		if (ke.getKeyCode() == KeyEvent.VK_X)
			menu.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_C)
			attack.toggle(pressed);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
	}
}
