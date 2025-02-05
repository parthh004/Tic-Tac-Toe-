import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            int row, col;
            printBoard(board);

            while (true) {
                System.out.println("Player " + player + " enter");
                row = scanner.nextInt();
                col = scanner.nextInt();
                if (row > 2 || col > 2 || row < 0 || col < 0) {
                    System.out.println("Enter valid location");
                } else if (board[row][col] != ' ') {
                    System.out.println("Already Placed");
                } else {
                    break;
                }

            }
            board[row][col] = player;//place the element
            gameOver = haveWon(board, player);
            if (gameOver) {
                System.out.println("Player " + player + " has won");
            } else {
                if (player == 'X') {
                    player = 'O';
                } else {
                    player = 'X';
                }
            }
        } printBoard(board);
//        String out = Arrays.deepToString(board);
//        System.out.println(out);
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean haveWon(char[][] board, char player) {
        // for row
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        //for col
        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // for diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
}
