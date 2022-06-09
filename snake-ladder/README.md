### What is this codebase all about?
This simulates the popular snake and ladder game!

Note - This project is still under construction!


#### Overview 
This code contains a self-driven snake and ladder game. It can run multiple games in separate contexts.

#### Classes overview

- **Main** : - run this class to begin the game
- **Gameboard**: - contains definition of aboard which includes number of positions and registered position manipulators.
- **PosManipulator**: `Snakes` and `Ladders` implement this interface. They are capable of altering the position of players that lands at the position.
- **Player** : Blueprint class for a player
- **GameContext** - this represents an instance of a game and is a `Runnable` thread. You can run multiple contexts representing multiple games going on in parallel.

Author - Reji Mathews