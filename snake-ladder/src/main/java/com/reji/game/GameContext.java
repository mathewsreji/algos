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

        if(players == null || players.size() <= 0) {
            throw new CannotStartGameException("No players are registered. Please add some players to the game");
        }

        // the index of the first player
        int playerIndex = 0;

        while(!isGameOver) {

            // game logic here
            // loop through each player and call play() method by rolling the using Dice.roll()
                    // On every move, evaluate of a pos manipulator (snake or ladder) is registered with the cell.
                    // if so, update player position to a new position accordingly

            // at any point if a player touches the final cell, update isGameOver=true. this finishes the GameContext thread
        }
    }
}
