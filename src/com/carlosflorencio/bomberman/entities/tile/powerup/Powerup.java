package com.carlosflorencio.bomberman.entities.tile.powerup;

import com.carlosflorencio.bomberman.entities.tile.Tile;
import com.carlosflorencio.bomberman.graphics.Sprite;

public abstract class Powerup extends Tile {

	protected int _duration = -1; // -1 is infinite, duration in lifes
	protected boolean _active = false;
	protected int _level;
	
	public Powerup(int x, int y, int level, Sprite sprite) {
		super(x, y, sprite);
		_level = level;
	}
	
	public abstract void setValues();
	
	public void removeLive() {
		if(_duration > 0)
			_duration--;
		
		if(_duration == 0)
			_active = false;
	}
	
	public int getDuration() {
		return _duration;
	}
	
	public int getLevel() {
		return _level;
	}

	public void setDuration(int duration) {
		this._duration = duration;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		this._active = active;
	}
}
