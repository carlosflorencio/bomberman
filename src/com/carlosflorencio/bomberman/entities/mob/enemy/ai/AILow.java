package com.carlosflorencio.bomberman.entities.mob.enemy.ai;

public class AILow extends AI {

	@Override
	public int calculateDirection() {
		return random.nextInt(4);
	}

}
