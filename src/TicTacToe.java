import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println(
                " 1 | 2 | 3\n---+---+---\n 4 | 5 | 6\n---+---+---\n 7 | 8 | 9\n"
        );
        char X = 'X';
        char O = 'O';
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        Scanner sc = new Scanner(System.in);

        String playerOne = getPlayerName(sc, "Player X");
        String playerTwo = getPlayerName(sc, "Player O");

        // Game loop
        for (int turn = 0; turn < 9; turn++) {
            if (turn % 2 == 0) {
                getPlayerInput(sc, playerOne, X, board);
            } else {
                getPlayerInput(sc, playerTwo, O, board);
            }

            showBoard(board);

            if (checkWinner(board, X)) {
                System.out.println(playerOne + " wins!");
                break;
            } else if (checkWinner(board, O)) {
                System.out.println(playerTwo + " wins!");
                break;
            }
        }

        if (!checkWinner(board, X) && !checkWinner(board, O)) {
            System.out.println("It's a tie!");
        }
    }

    private static String getPlayerName(Scanner sc, String player) {
        System.out.print(player + ", enter your name: ");
        return sc.next();
    }

    private static void getPlayerInput(Scanner sc, String playerName, char sign, char[][] board) {
        int boxNumber;
        while (true) {
            System.out.print(playerName + ", enter box number: ");
            boxNumber = sc.nextInt();
            int row = (boxNumber - 1) / 3;
            int col = (boxNumber - 1) % 3;

            if (row >= 0 && row < 3 && col >= 0) {
                if (board[row][col] == ' ') {
                    board[row][col] = sign;
                    break;
                } else {
                    System.out.println("Box already occupied! Try again.");
                }
            } else {
                System.out.println("Invalid box number! Try again.");
            }
        }
    }

    private static void showBoard(char[][] board) {
        System.out.println(
                " " + board[0][0] + " |" + " " + board[0][1] + " |" + " " + board[0][2] + "\n" +
                        "---+---+---" + "\n" +
                        " " + board[1][0] + " |" + " " + board[1][1] + " |" + " " + board[1][2] + "\n" +
                        "---+---+---" + "\n" +
                        " " + board[2][0] + " |" + " " + board[2][1] + " |" + " " + board[2][2] + "\n"
        );
    }

    private static boolean checkWinner(char[][] board, char sign) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == sign && board[i][1] == sign && board[i][2] == sign) {
                return true;
            }
            if (board[0][i] == sign && board[1][i] == sign && board[2][i] == sign) {
                return true;
            }
        }
        if (board[0][0] == sign && board[1][1] == sign && board[2][2] == sign) {
            return true;
        }
        return board[0][2] == sign && board[1][1] == sign && board[2][0] == sign;
    }
}