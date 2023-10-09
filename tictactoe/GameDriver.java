// 10/26/22 super ap p5
import java.util.*;
public class GameDriver implements GameState {
    // public GameState state;
    public Player X, O;
    public boolean xWins, oWins; // implement as boolean because Michael's method accounts for 
    public ArrayList<String> moves = new ArrayList<String>();
    public static String[][]board = new String[3][3];

    public GameDriver(){
        
    }
    
    public void play(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name of player X?");
        String pXName = sc.nextLine();
        System.out.println("Name of player O?");
        String pOName = sc.nextLine();
        X = new Player(pXName);
        O = new Player(pOName);

        moves.add("0,0");
        moves.add("0,1");
        moves.add("0,2");
        moves.add("1,0");
        moves.add("1,1");
        moves.add("1,2");
        moves.add("2,0");
        moves.add("2,1");
        moves.add("2,2");

        Player currentPlayer;
        String currentName;
        int nextMove;
        ArrayList<String>currentMoves;
        int moveCounter = 0;
        //implement try catch to catch input mistmatch error
        try{}
        catch(Exception E){
            System.out.println("Failed to load image: " + e.getLocalizedMessage());
        }
        while(!isGameOver(board)){
            toString();
            currentPlayer = getCurrentPlayer(moveCounter);
            currentMoves = getCurrentMoves();
            currentName = currentPlayer.getName();
            System.out.println("Here are the moves available:");
            for(int i=0; i < currentMoves.size(); i++){
                System.out.print(i + ":" + currentMoves.get(i) + " ");
            }
            System.out.println();
            System.out.println(currentName + " choose a move...");
            nextMove = sc.nextInt();
            currentMoves.remove(nextMove);
            makeMove(currentMoves.get(nextMove), moveCounter);
            System.out.println(currentName + " has moved to " + currentMoves.get(nextMove));
            moveCounter++;
        }
        
        if(!isGameOver(board)){
            currentPlayer = getWinner();
            if(currentPlayer == null){
                System.out.println("Draw!");
            }else{
                System.out.println(currentPlayer.getName() + " is the winner!");
            }
        }
        
    }

    public Player getWinner() {
        if(!isGameOver(board)) {
            if(xWins) // check for X
                return X;
            else if(oWins) // check for O
                return O;
        }
        return null;
    }

    public Player getCurrentPlayer(int moveCounter) { // even -> X, odd -> Y
        if(!isGameOver(board)) {
            if(moveCounter%2 == 0) // even -> X
                return X;
            else // odd -> O
                return O;
        }
        else {
            return null;
        }
    }

    public ArrayList<String> getCurrentMoves() {
        return moves;
    }

    public void makeMove(String move, int nmove){
        String COMMA  = ",";
        String x_value = "";
        String y_value = "";
        String player =  "";

        if((nmove%2) == 0){
            player = "X";
        }else{
            player = "O";
        }

        int counter = 0;
        for(int i = 0; i < move.length(); i++){
            //first part of the string(x value)
            if(!COMMA.equals(move.substring(i,i+1)) && counter == 0){
                x_value += move.substring(i, i+1);                
            //second part of the string(y_value)
            }else if(!COMMA.equals(move.substring(i,i+1))&& counter ==1){
                y_value += move.substring(i, i+1);
            //third part of the string(name of player)
            }else if(!COMMA.equals(move.substring(i,i+1))&& counter ==2){
                player += move.substring(i, i+1);
            //counter increments everytime comma is placed
            }else if(COMMA.equals(move.substring(i, i+1))){
                counter++;
            }
        }
        //check if the board is already filled in
        if(board[Integer.parseInt(x_value)][Integer.parseInt(y_value)] == null){
            board[Integer.parseInt(x_value)][Integer.parseInt(y_value)] = player;
        }else{
            System.out.println("This position is already taken!");
        }
    }

    public String toString(){
        String result = "";
       //show the current state of the game board
       for(int row = 0; row < board.length; row++){
           for(int col = 0; col < board[row].length; col++){
               result += board[row][col];
           }
           result += "\n";
       } 
       System.out.println(result);
       return result;
   }

   public boolean isGameOver(String[][]board){
    String check = "";
    boolean found = false;
    for(int a=0; a<2; a++) {
        if(a==0)
            check="X";
        else if(a==1)
            check="O";
  
        for(int i=0; i<3; i++) { // checks columns (vertically)
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] == check) {
                if(check=="X") 
                    xWins = true;
                else if(check=="O") 
                    oWins = true;
                System.out.println("v");

                found = true;
             }
        }
  
        if(!found) {
            for(int i=0; i<3; i++) { // checks rows (horizontally)
                if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] == check) {
                    if(check=="X") {
                        xWins = true;
                    }
                    else if(check=="O") {
                        oWins = true;
                    }
                    System.out.println("v");
                    found = true;
                }
            }
        }
  
        if(!found && board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[2][2]==check) { // check diagonal \
            if(check=="X") {
                xWins = true;
            }
            else if(check=="O") {
                oWins = true;
            }
            System.out.println("dl");
            found = true;
        }
  
        if(!found && board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[2][0]==check) { // check diagonal /
            if(check=="X") {
                xWins = true;
            }
            else if(check=="O") {
                oWins = true;					
            }
            System.out.println("dr");
            found = true;
        }
  
        else if(moves.size() == 0){ //checks if 7/9 is full
            System.out.println("ti");
           found = true;
        }
    }
        System.out.println(found);
        return found;
  }

}