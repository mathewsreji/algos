package com.reji.game.square;

public interface SquareRelocator {
    /**
     * moves a player from the position to new position.
     * It can be a ladder or a snake. Both can have a target position
     * @return
     */
    int getRelocationStepCount();
}
