package com.carlosflorencio.bomberman.entities.tile.powerup;

import com.carlosflorencio.bomberman.Board;
import com.carlosflorencio.bomberman.Game;
import com.carlosflorencio.bomberman.entities.Entity;
import com.carlosflorencio.bomberman.entities.mob.Player;
import com.carlosflorencio.bomberman.graphics.Sprite;

public class PowerupFreeze extends Powerup {
	Board _board;
    public PowerupFreeze(int x, int y, int level, Board _board, Sprite sprite) {
        super(x, y, level, sprite);
		this._board = _board;
    }

    @Override
	public boolean collide(Entity e) {
		
		if(e instanceof Player) {
			((Player) e).addPowerup(this);
			remove();
			return true;
		}
		
		return false;
	}

    @Override
    public void setValues() {
		_active = true;
		Game.freezeMobs(_board);
	}
    
    
}
