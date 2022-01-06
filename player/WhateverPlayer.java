package player;
import java.util.Random;
import main.Board;
public class WhateverPlayer implements Player{
    public Board.Mark mark;
    protected Random rand = new Random();
    public WhateverPlayer(Board.Mark mark){
        this.mark = mark;
    }
    public void playerTurn(Board board){
        System.out.println("\nMr.Whatever thinking..");
        String [] blank_cells = new String[Board.SIZE * Board.SIZE];
        String [] array = new String[2];
        int random_chooise = 0;
        int blank_cell_counter = 0;
        for(int x = 0; x < Board.SIZE; x++){
            for(int y = 0; y < Board.SIZE; y++){
                if(board.board_array[x][y] == Board.Mark.BLANK){
                    blank_cells[blank_cell_counter] = x + "#" + y;
                    blank_cell_counter++;
                }
            }
        }
        random_chooise = rand.nextInt(blank_cell_counter);
        array = blank_cells[random_chooise].split("#");
        board.putMark(Integer.parseInt(array[0]), Integer.parseInt(array[1]), this.mark);
        System.out.println("\nMr.Whatever made a choose!\n");
    }
    public Board.Mark getPlayerMark(){
        return this.mark;
    }
}
