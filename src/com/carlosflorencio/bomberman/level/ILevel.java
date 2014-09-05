package com.carlosflorencio.bomberman.level;


import com.carlosflorencio.bomberman.exceptions.LoadLevelException;

public interface ILevel {

	public void loadLevel(String path) throws LoadLevelException;
}
