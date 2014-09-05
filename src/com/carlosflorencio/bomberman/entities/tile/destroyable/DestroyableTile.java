package com.carlosflorencio.bomberman.entities.tile.destroyable;

import com.carlosflorencio.bomberman.entities.Entity;
import com.carlosflorencio.bomberman.entities.bomb.DirectionalExplosion;
import com.carlosflorencio.bomberman.entities.tile.Tile;
import com.carlosflorencio.bomberman.graphics.Sprite;

public class DestroyableTile extends Tile {

	private final int MAX_ANIMATE = 7500; //save the animation status and dont let this get too big
	private int _animate = 0;
	protected boolean _destroyed = false;
	protected int _timeToDisapear = 20;
	protected Sprite _belowSprite = Sprite.grass; //default
	
	public DestroyableTile(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	
	@Override
	public void update() {
		if(_destroyed) {
			if(_animate < MAX_ANIMATE) _animate++; else _animate = 0; //reset animation
			if(_timeToDisapear > 0) 
				_timeToDisapear--;
			else
				remove();
		}
	}

	public boolean isDestroyed() {
		return _destroyed;
	}
	
	public void destroy() {
		_destroyed = true;
	}
	
	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof DirectionalExplosion)
			destroy();
			
		return false;
	}
	
	public void addBelowSprite(Sprite sprite) {
		_belowSprite = sprite;
	}
	
	protected Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2) {
		int calc = _animate % 30;
		
		if(calc < 10) {
			return normal;
		}
			
		if(calc < 20) {
			return x1;
		}
			
		return x2;
	}
	
}
