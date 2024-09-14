/**
 * LAB 2
 *
 * Name: Aayush Kafle
 * Class: CS-251L-005 (Spring 2022)
 * Email: akafle1@unm.edu
 * Date Submitted: 02/19/2022
 *
 * Brief explanation of the program:
 * This is the Gomoku game just like a tic-tac-toe. Different player with rings or cross get their turn turnwise. They
 * make their move and wait for the other player to make the other move. Whenever 5 of either ring or cross are together
 * in row, column, or in either diagonal then the selected ring or cross will win.
 * The game also shows draw if no player won the game
 *
 */

import cs251 . lab2 .*;


public class Gomoku implements GomokuInterface {
    private Square[][] board = new Square[getNumRows()][getNumCols()]; // creating a new square board with default row and default column
    private Square player = Square.EMPTY; // setting player to a random empty square

    private boolean forRow(int row, int col) // checks if any of the rings or crosses are same in a particular horizontal line
    {
        int count = 0;
        boolean isWinner;
        // from the first row to the last
        for (int i = row; i > -1 && i < getNumRows(); i++) {
            {
                if (board[row][col] == board[i][col]) // checking for each row in many column
                    count++;

                else
                    break;
            }
        }
        if (count >= SQUARES_IN_LINE_FOR_WIN)
            isWinner = true;

        else
            isWinner = false;

        return isWinner;
    }

    private boolean forColumn(int row, int col) // checks if the rings and crosses are same in a particular same column
    {
        int count = 0;
        boolean isWinner;
        for (int j = col; j > -1 && j < getNumCols(); j++) {
            {
                if (board[row][col] == board[row][j])
                    count++;

                else
                    break;
            }
        }
        if (count >= SQUARES_IN_LINE_FOR_WIN)
            isWinner = true;

        else
            isWinner = false;

        return isWinner;
    }

    // checks if either ring or cross are consecutive 5 in upward diagonal
    private boolean upDiagonals(int row, int col) {
        int count = 0;
        boolean isWinner;

        // for upward diagonals
        for (int i = row, j = col; i > -1 && i < getNumRows() && j > -1 && j < getNumCols(); i++, j++) {
            if (board[row][col] == board[i][j]) {
                count++;
            } else {
                break;
            }
        }

        if (count >= SQUARES_IN_LINE_FOR_WIN)
            isWinner = true;

        else
            isWinner = false;

        return isWinner;
    }

    // checks if any consecutive 5 rings, or 5 crosses are together in downward diagonal direction
    private boolean downDiagonals(int row, int col) {
        int count = 0;
        boolean isWinner;
        // for diagonals along downward axis
        for (int i = row, j = col; i > -1 && i < getNumRows() && j > -1 && j < getNumCols(); i--, j++) {
            if (board[row][col] == board[i][j]) {
                count++;
            } else {
                break;
            }
        }
        if (count >= SQUARES_IN_LINE_FOR_WIN)
            isWinner = true;

        else
            isWinner = false;

        return isWinner;

    }

    // detects if any horizontal, vertical, or diagonal player has won the game
    private boolean hasWon() {
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumCols(); j++) {
                if (board[i][j] != Square.EMPTY) {
                    if (forRow(i, j) || forColumn(i, j) || upDiagonals(i, j) || downDiagonals(i, j))
                        return true;
                }
            }
        }
        return false;
    }

    // checks if there are any empty squares for checking if the game is drawn
    private boolean gameDraw()
    {
        for (int i =0; i<getNumRows(); i++)
        {
            for (int j=0; j<getNumCols(); j++)
            {
                if (board[i][j] == Square.EMPTY)
                    return false;
            }
        }
        return true;
    }



    public int getNumRows() {
        return DEFAULT_NUM_ROWS;
    }

    public int getNumCols() {
        return DEFAULT_NUM_COLS;
    }

    public int getNumInLineForWin() {
        return SQUARES_IN_LINE_FOR_WIN;
    }

    // draws cross or rings in the window as per the turn of the players
    public TurnResult handleClickAt(int row, int col) {

        // checks if the game has been draw
        if (gameDraw() == true)
        {
            return TurnResult.DRAW;
        }


        // checks if ring or cross has won
        if (board[row][col] == Square.EMPTY) {
            board[row][col] = getCurrentTurn();
            if (hasWon()) {
                if (getCurrentTurn() == Square.CROSS) {
                    return TurnResult.CROSS_WINS;
                }
                else if (getCurrentTurn() == Square.RING) {
                    return TurnResult.RING_WINS;
                }
            }

            // changes the player .i.e from ring to cross and vice versa
            if (player == Square.RING)
            {
                player = Square.CROSS;
            }
            else
                player = Square.RING;
        }

        return TurnResult.GAME_NOT_OVER;
    }

    // starts the game with empty square boards
    public void initializeGame() {
        for (int row=0; row<getNumRows(); row++)
        {
            for (int col=0; col<getNumCols(); col++)
            {
                board[row][col] = Square.EMPTY;
            }
        }
    }


    // gets the current ring or cross in the string form
    public String getCurrentBoardAsString() {

        StringBuilder ab = new StringBuilder();

        for (int row=0; row<getNumRows(); row++) {
            for (int col = 0; col < getNumCols(); col++) {
                ab.append(board[row][col].toChar());
            }
            ab.append("\n");

        }
        return ab.toString();

    }

    // sets the turn for the player in only the empty square fields
    public Square getCurrentTurn() {
        return player;
    }

    // alternates between crosses and squares
    public void setOpponentType (String type)
    {
        // for the computer player
    }

    // starts the program
    public static void main ( String [] args ) {
        Gomoku game = new Gomoku ();
        if (args . length > 0) {
            game . setOpponentType ( args [0]);
        }
        GomokuGUI . showGUI ( game );
    }

}
