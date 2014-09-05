package com.carlosflorencio.bomberman.entities.bomb;

import com.carlosflorencio.bomberman.Board;
import com.carlosflorencio.bomberman.entities.Entity;
import com.carlosflorencio.bomberman.entities.mob.Mob;
import com.carlosflorencio.bomberman.graphics.Screen;
import com.carlosflorencio.bomberman.graphics.Sprite;


public class Explosion extends Entity {

	protected boolean _last = false;
	protected Board _board;
	protected Sprite _sprite1, _sprite2;
	
	public Explosion(int x, int y, int direction, boolean last, Board board) {
		_x = x;
		_y = y;
		_last = last;
		_board = board;
		
		switch (direction) {
			case 0:
				if(last == false) {
					_sprite = Sprite.explosion_vertical2;
				} else {
					_sprite = Sprite.explosion_vertical_top_last2;
				}
			break;
			case 1:
				if(last == false) {
					_sprite = Sprite.explosion_horizontal2;
				} else {
					_sprite = Sprite.explosion_horizontal_right_last2;
				}
				break;
			case 2:
				if(last == false) {
					_sprite = Sprite.explosion_vertical2;
				} else {
					_sprite = Sprite.explosion_vertical_down_last2;
				}
				break;
			case 3: 
				if(last == false) {
					_sprite = Sprite.explosion_horizontal2;
				} else {
					_sprite = Sprite.explosion_horizontal_left_last2;
				}
				break;
		}
	}
	
	@Override
	public void render(Screen screen) {
		int xt = (int)_x << 4;
		int yt = (int)_y << 4;
		
		screen.renderEntity(xt, yt , this);
	}
	
	@Override
	public void update() {}

	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof Mob) {
			((Mob)e).kill();
		}
		
		return true;
	}
	

}