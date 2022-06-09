package com.reji.game.posmovers;

import com.reji.game.exceptions.InvalidPositionManipulatorException;

public class Ladder implements PosManipulator {

    private int sourcePos;
    private int targetPos;

    public Ladder(int sourcePos, int targetPos) {
        if(targetPos <= sourcePos) {
            throw new InvalidPositionManipulatorException("Ladder should always take player forward");
        }
        this.sourcePos = sourcePos;
        this.targetPos = targetPos;
    }

    @Override
    /**
     * returns target position to which this ladder can promote you
     */
    public int getTargetPosition() {
        System.out.println("Viola! Player got promoted from position " + sourcePos + "to" + targetPos);
        return targetPos;
    }
}
