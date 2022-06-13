package com.reji.game.square;

import com.reji.game.exceptions.InvalidPositionManipulatorException;
import lombok.Getter;

@Getter
public class Snake implements SquareItem {

    private int sourcePos;
    private final int relocationCount;

    public Snake(int sourcePos, int relocationCount) {
        if(relocationCount >= 0) {
            throw new InvalidPositionManipulatorException("Snake should always take player backward");
        }
        this.sourcePos = sourcePos;
        this.relocationCount = relocationCount;
    }

    @Override
    /**
     * returns target position to which this snake can de-mote you
     */
    public int relocationStepCount() {
        return relocationCount;
    }
}
