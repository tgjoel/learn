package coding.array;

public class TicTacToe {

    public static void main(String[] args) {
        // Design of the move method of the tic tac toe
    }

    /*
     player: 1 ,-1
     row: current playing row
     col: current playing col
     */
    public int move(int player, int row, int col) {
        int n = 3;
        int[][] board = new int[3][3];
        int rowSum[] = new int[3];  // sum of the rows
        int colSum[] = new int[3]; // sum of the columns
        int revDiaSum = 0; // sum of the reverse diagonal
        int diaSum = 0; // sum of the diagonal

        if(row < 0 || col < 0 || row > n || col >n ) {
            System.out.println("invalid row or column number");
        }
        if(player != -1 && player != 1) {
            System.out.println("invalid player");
        }
        if(board[row][col] != 0) {
            System.out.println("Already played");
        }
        board[row][col] = player; // marking the square for the current player;
        rowSum[row]+=player; // keeping track of the rows
        colSum[col]+=player; // keeping track of the column
        if(row == col) {
            diaSum+=player; // only we are playing in the diagonal squares
        }
        if(col == n-row-1) {  //>>>>>>> condition for reverse diagonal elements
            revDiaSum+=player;
        }
        if(Math.abs(rowSum[row]) == n || Math.abs(colSum[col]) == n || Math.abs(diaSum) == n || Math.abs(revDiaSum) == n) {
            // the player wins;
            return player;
        }
        return 0; // as its draw now
    }
}
