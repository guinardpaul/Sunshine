package fr.sunshine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import fr.sunshine.display.Display;
import fr.sunshine.gfx.Assets;
import fr.sunshine.gfx.GameCamera;
import fr.sunshine.gfx.Text;
import fr.sunshine.input.KeyManager;
import fr.sunshine.input.MouseManager;
import fr.sunshine.screen.Menu;
import fr.sunshine.screen.TitleMenu;
import fr.sunshine.states.State;
import fr.sunshine.world.World;

public class Game implements Runnable {

	private Display display;
	private int width;
	private int height;
	public String title;

	private Thread thread;
	private boolean running = false;

	private BufferStrategy bs;
	private Graphics g;

	public Menu menu;
	private World world;
	// States
	public State gameState;
	public State menuState;
	public State instructionState;
	public State inventoryState;

	// Input
	private KeyManager keyManager;
	private MouseManager mouseManager;

	// Camera
	private GameCamera gameCamera;

	// Handler
	private Handler handler;

	public void setMenu(Menu menu) {
		this.menu = menu;
		if (menu != null)
			menu.init(this, keyManager);
	}

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);

		// gameState = new GameState(handler);
		// menuState = new MenuState(handler);
		// instructionState = new InstructionState(handler);
		// inventoryState = new InventoryState(handler);
		// State.setState(menuState);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);

		setMenu(new TitleMenu());
	}

	private void tick() {
		if (!display.getFrame().hasFocus()) {
			keyManager.releaseAll();
		} else {
			keyManager.tick();
			// if (State.getState() != null) {
			// State.getState().tick();
			// }
			// world.tick();
			if (menu != null) {
				menu.tick();
			} else {
				world.tick();
			}
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			display.getCanvas().requestFocus();
			return;
		}

		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// Draw here
		// g.drawImage(Assets.water, x, 10, null);
		// if (State.getState() != null) {
		// State.getState().render(g);
		// }

		world.render(g);
		renderGui(g);

		if (!display.getFrame().hasFocus()) {
			renderFocusNagger();
		}

		// End drawing
		bs.show();
		g.dispose();
	}

	private void renderGui(Graphics g) {
		if (menu != null) {
			menu.render(g);
		}
	}

	private void renderFocusNagger() {
		String msg = "Click to focus !";
		Text.drawString(g, msg, (getWidth() - msg.length()) / 2, getHeight() / 2, true, Color.RED, Assets.font28);
	}

	@Override
	public void run() {
		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				// System.out.println("Ticks " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this, "Game Thread");
		thread.start(); // Call run override method
	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
