package com.reji.game;

import lombok.Getter;

@Getter
public class GamePlayer implements Player{

    private String name;
    private int position;

    public GamePlayer(String name, int initPos) {
        this.name = name;
        this.position = initPos;
    }

    @Override
    public int play() {
        return Dice.roll();
    }

    public void updatePosition(int position) {
        this.position = position;
    }

}
