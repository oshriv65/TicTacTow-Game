package player;
import main.Board;
public class PlayerFactory {
    public Player build(String input, Board.Mark mark){
        Player player = null;
        switch(input){
            case "Human", "human":
                player = new HumanPlayer(mark);
                break;
            case "CleverPlayer", "clever":
                player = new CleverPlayer(mark);
                break;
            case "whatever","Whatever", "Mr. Whatever":
                player = new WhateverPlayer(mark);
                break;
            default:
                System.err.println("The requested Player mode not founded in the system!.\nThe system choose Human Player by default.");
                player = new HumanPlayer(mark);
        }
        return player;
    }
}
