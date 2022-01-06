package main;
public class Board {
    public enum Mark {BLANK, X ,O}
    //enum Status {DRAW, X_WIN, Y_WIN}
    public static final int SIZE = 3;
    public static final int WIN_STREAK = 3;
    public Mark [][] board_array = new Mark[SIZE][SIZE];
    public Board(){
        // Making blank board.
        for(int row = 0; row < SIZE; row++){
            for(int col =0; col < SIZE; col++){
                board_array[row][col] = Board.Mark.BLANK;
            }
        }
    }
    // The method check if the numbers she got are valid and the put mark on the cell in the array, when numbers are valid it return false so the while function in player will end. 
    public void putMark(int row, int col, Mark mark){
        board_array[row][col] = mark;
    }
    // This method check if we have winner in our game.
    public boolean isGameOver(Mark mark){
        int win_counter = 0;
        for(int x = 0; x < SIZE; x++){
            // check wining by completing rows
            for(int y = 0; y < SIZE; y++){
                if(board_array[x][y] == mark){
                    win_counter++;
                }
            }
            if(win_counter == WIN_STREAK){
                System.out.println("\nThe Round is over! , Player " + mark + " WIN!\n");
                return true;
            }
            win_counter = 0;
            // check wining by completing columns
            for(int y = 0; y < SIZE; y++){
                if(board_array[y][x] == mark){
                    win_counter++;
                }
            }
            if(win_counter == WIN_STREAK){
                System.out.println("\nThe Round is over! , Player " + mark + " WIN!\n");
                return true;
            }
            win_counter = 0;
        }
        // check wining by completing crosses.
        for(int x = SIZE - 1; x >= 0; x--){
            if(board_array[(SIZE - 1) - x][x] == mark){
                win_counter++;
            }
        }
        if(win_counter == WIN_STREAK){
            System.out.println("\nThe Round is over! , Player " + mark + " WIN!\n");
            return true;
        }
        win_counter = 0;

        for(int x = 0; x < SIZE; x++){
            if(board_array[x][x] == mark){
                win_counter++;
            }
        }
        if(win_counter == WIN_STREAK){
            System.out.println("\nThe Round is over! , Player " + mark + " WIN!\n");
            return true;
        }
        return false; // if the game didn't over it's return false.
    }
}
