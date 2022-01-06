package player;
import main.Board;
public class CleverPlayer implements Player{
    public Board.Mark mark;
    //Board.Mark rival_mark;
    // "1#1", "2#1", "2#2" |||||| "2#0", "0#0", "0#1"
    public CleverPlayer(Board.Mark mark){
        /*
        if(mark == Board.Mark.X){
            rival_mark = Board.Mark.O;
        }
        else{
            rival_mark = Board.Mark.X;
        }
        */
        this.mark = mark; 
    }
    public void playerTurn(Board board){
        // need to check to make an "lite Ai"
        System.out.println("\nMrs.Clever thinking..");
        if(board.board_array[1][1] == Board.Mark.BLANK || board.board_array[2][1] == Board.Mark.BLANK || board.board_array[2][2] == Board.Mark.BLANK || board.board_array[2][0] == Board.Mark.BLANK){
            if(board.board_array[1][1] == Board.Mark.BLANK){
                board.putMark(1, 1, this.mark);
            }
            else if(board.board_array[2][1] == Board.Mark.BLANK){
                board.putMark(2, 1, this.mark);

            }
            else if(board.board_array[2][0] == Board.Mark.BLANK){
                if(board.board_array[0][1] == Board.Mark.BLANK){
                    board.putMark(0, 1, mark);
                }
                else{
                    board.putMark(2, 0, this.mark);
                }
                
            }
            else{
                if(board.board_array[0][1] == Board.Mark.BLANK){
                    board.putMark(0, 1, mark);
                }
                else{
                    board.putMark(2, 2, this.mark);
                }
            }
        }
        else{
            if(board.board_array[2][0] == Board.Mark.BLANK && board.board_array[2][1] == mark && board.board_array[2][2] == mark){
                board.putMark(2, 0, this.mark);
            }
            else if(board.board_array[0][0] == Board.Mark.BLANK && board.board_array[1][1] == mark && board.board_array[2][2] == mark){
                board.putMark(0, 0, this.mark);
            }
            else if(board.board_array[0][1] == Board.Mark.BLANK && board.board_array[1][1] == mark && board.board_array[2][1] == mark){
                board.putMark(0, 1, this.mark);
            }
            else if(board.board_array[0][2] == Board.Mark.BLANK && board.board_array[1][1] == mark && board.board_array[2][0] == mark){
                board.putMark(0, 2, this.mark);
            }

            else{
                //random fill
                return;
            }
        }
    }
    /*
    public boolean loseingInterupt(Board board){
        int win_counter = 0;
        for(int x = 0; x < board.SIZE; x++){
            // check wining by completing rows
            for(int y = 0; y < board.SIZE; y++){
                if(board.board_array[x][y] == rival_mark){
                    win_counter++;
                        if(win_counter == 2){
                            if(board.board_array[y+1][x] == Board.Mark.BLANK){
                                board.putMark(y + 1, x, mark);
                            }
                        return true;
                    }
                }
            }
            win_counter = 0;
            // check wining by completing columns
            for(int y = 0; y < board.SIZE; y++){
                if(board.board_array[y][x] == rival_mark){
                    win_counter++;
                    if(win_counter == 2){
                        if(board.board_array[y+1][x] == Board.Mark.BLANK){
                            board.putMark(y + 1, x, mark);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
    */
    public Board.Mark getPlayerMark(){
        return this.mark;
    }
}