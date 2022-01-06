package render;
import main.Board;
public class ConsoleRenderer implements Renderer{
    // Just printing the board with the array values.
    public void renderBoard(Board.Mark [][] array){
        String board_stirng = "";
        String num_col = "  ";
        for(int num = 0; num < array.length; num ++){
            num_col += num + " ";
        }
        System.out.println("\f" + num_col);
        for(int x = 0; x < array.length; x++){
            board_stirng += x + " ";
            for(int y = 0; y < array[x].length; y++){
                if(array[x][y] == Board.Mark.BLANK){
                    board_stirng += " ";
                }
                else{
                    board_stirng += array[x][y];
                }
                if(y != array[x].length - 1){
                    board_stirng += "|";
                }
            }
            System.out.println(board_stirng);
            if(x != array.length - 1){
                System.out.println("  _|_|_");
            } 
            board_stirng = "";
        }
        
    }
    
}
