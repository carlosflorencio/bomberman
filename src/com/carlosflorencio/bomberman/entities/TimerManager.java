package com.carlosflorencio.bomberman.entities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.carlosflorencio.bomberman.entities.mob.enemy.Enemy;

public class TimerManager implements ActionListener {
    Enemy _enemy;

    public TimerManager(Enemy _enemy) {
        this._enemy = _enemy;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        _enemy.freeze();
    }
    
}
