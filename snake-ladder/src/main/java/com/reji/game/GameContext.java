package com.reji.game;

import com.reji.game.exceptions.CannotStartGameException;
import lombok.Builder;
import lombok.Setter;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
public class GameContext implements Runnable{

    @Singular
    private List<Player> players = new ArrayList<>();
    private GameBoard board;
    private boolean isGameOver = false;

    @Override
    /**
     * starts the game context
     */
    public void run() {

        if(board == null) {
            throw new CannotStartGameException("Board is not assigned to game context. Please assign a board");
        }

        int playerIndex = 0;

        while(!isGameOver) {



        }
    }
}
