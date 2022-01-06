package player;
import main.Board;
import java.util.Scanner;
public class HumanPlayer implements Player{
    public Board.Mark mark; // symbol save the mark of the player in his object.
    protected Scanner scanner = new Scanner(System.in);
    // The constructor here make the player to choose X or O mark, then it's easier to use it on other methods, i dont need to send the symbol from main over and over again.
    public HumanPlayer(Board.Mark mark){
        this.mark = mark;
    }
    // This method doesn't return noting, it's just send the row and col to board to check if it's valid numbers and when it valid the while get false and the method end.
    public void playerTurn(Board board){
        int row;
        int col;
        while(true){
            System.out.println("\fPlayer " + this.mark + ", please enter your row and column:");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if((row >= Board.SIZE || row < 0) || (col >= Board.SIZE || col < 0)){
                System.err.println("\nInvalid row or column! ,please choose valid row and column:");
            }
            else{
                if(board.board_array[row][col] != Board.Mark.BLANK){
                    System.err.println("\nThis place already marked, Please different row and column:");
                }
                else{
                    break;
                }
            }
        }
        board.putMark(row, col, mark);
    }
    public Board.Mark getPlayerMark(){
        return this.mark;
    }
}
