package player;
import main.Board;
public interface Player {
    public void playerTurn(Board board);
    public Board.Mark getPlayerMark();
}