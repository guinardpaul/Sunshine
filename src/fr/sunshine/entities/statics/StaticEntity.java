package fr.sunshine.entities.statics;

import fr.sunshine.Handler;
import fr.sunshine.entities.Entity;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
