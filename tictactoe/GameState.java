// 10/26/22 super ap p5
import java.util.*;
import pkg.*;

public interface GameState {

    Player getWinner();
    Player getCurrentPlayer(int moveCounter);
    ArrayList<String> getCurrentMoves();
    void makeMove(String move, int nmove);

}