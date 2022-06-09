package com.reji.game.posmovers;

import com.reji.game.exceptions.InvalidPositionManipulatorException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Snake implements PosManipulator {

    private int sourcePos;
    private int targetPos;

    public Snake(int sourcePos, int targetPos) {
        if(targetPos >= sourcePos) {
            throw new InvalidPositionManipulatorException("Snake should always take player backward");
        }
        this.sourcePos = sourcePos;
        this.targetPos = targetPos;
    }

    @Override
    /**
     * returns target position to which this snake can de-mote you
     */
    public int getTargetPosition() {
        return targetPos;
    }
}
