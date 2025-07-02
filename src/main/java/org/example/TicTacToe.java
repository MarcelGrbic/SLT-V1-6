package org.example;
import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        board.clear();

        while (true) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());

            int row, col;
            while (true) {
                System.out.print("row (0-2): ");
                row = scanner.nextInt();
                System.out.print("column (0-2): ");
                col = scanner.nextInt();

                if (row >= 0 && row <= 2 && col >= 0 && col <= 2 && board.isCellEmpty(row, col)) {
                    break;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            board.place(row, col, currentPlayer.getMarker());

            if (hasWinner()) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                break;
            } else if (board.isFull()) {
                board.print();
                System.out.println("It's a draw!");
                break;
            }

            switchCurrentPlayer();
        }

        System.out.println("Game over. Want to play again? (yes/no)");
        String again = scanner.next();
        if (again.equalsIgnoreCase("yes")) {
            start(); // neues Spiel starten
        }
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char m = currentPlayer.getMarker();
        char[][] c = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                c[i][j] = board.getCell(i, j);

        // Reihen, Spalten, Diagonalen prüfen
        for (int i = 0; i < 3; i++) {
            if (c[i][0] == m && c[i][1] == m && c[i][2] == m) return true;
            if (c[0][i] == m && c[1][i] == m && c[2][i] == m) return true;
        }
        if (c[0][0] == m && c[1][1] == m && c[2][2] == m) return true;
        if (c[0][2] == m && c[1][1] == m && c[2][0] == m) return true;

        return false;
    }

    // Main-Methode zum Starten
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
