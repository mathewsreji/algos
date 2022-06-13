package com.reji.game.square;

import com.reji.game.exceptions.InvalidPositionManipulatorException;

public class Ladder implements SquareItem {

    private int sourcePos;
    private final int relocationCount;

    public Ladder(int sourcePos, int relocationCount) {
        if(relocationCount <= 0) {
            throw new InvalidPositionManipulatorException("Ladder should always take player forward");
        }
        this.sourcePos = sourcePos;
        this.relocationCount = relocationCount;
    }

    @Override
    /**
     * returns target position to which this ladder can promote you
     */
    public int relocationStepCount() {
        System.out.println("Viola! Player got promoted by  " + relocationCount + "steps");
        return relocationCount;
    }
}
