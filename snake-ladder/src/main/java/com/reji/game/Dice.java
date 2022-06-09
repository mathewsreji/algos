package com.reji.game;

import java.util.Random;

/**
 * returns random number between 1..6 to simulate a dice roll
 */
public class Dice {

    private static Random RANDOMIZER;

    static int roll(){
        if(RANDOMIZER == null) {
            RANDOMIZER = new Random();
        }
        return (RANDOMIZER.nextInt(1000) % 6) + 1;
    }
}
