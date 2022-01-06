package main;
import player.*;
import render.*;
public class Game {
    private Player [] player;
    private Renderer render;
    private Board board;
    public Game(Player [] player, Renderer render){
        this.board = new Board(); // Here i printing the opening and making the Board object and Render object.
        this.player = player;
        this.render = render;
        render.renderBoard(board.board_array); // printing  the blank board for start.
    }
    public String run(){
        for(int i = 0; i < 9; i++){
            player[i % player.length].playerTurn(board);
            render.renderBoard(board.board_array);
            if(board.isGameOver(player[i % player.length].getPlayerMark())){
                if(i % player.length == 0){
                    return "X";   
                }
                else{
                    return "O";
                }
            }
        }
        System.out.println("\nThe Round is Over!, it's a DRAW!\n");
        return "DRAW";
    }
}