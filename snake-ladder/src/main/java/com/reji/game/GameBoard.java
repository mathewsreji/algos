package com.reji.game;

import com.reji.game.posmovers.PosManipulator;

import java.util.Map;

public class GameBoard {
    private static final int TOTAL_CELLS = 100;
    private Map<Integer, PosManipulator> posMovers;
}