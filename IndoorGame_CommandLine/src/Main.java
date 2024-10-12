import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        System.out.println("Welcome to the Target Game!");

        while (!game.isGameOver()) {
            printBoard(game);
            System.out.println(game.getGameStatus());

            System.out.print("Enter row (0-4): ");
            int x = scanner.nextInt();
            System.out.print("Enter column (0-4): ");
            int y = scanner.nextInt();

            boolean hit = game.makeMove(x, y);
            if (hit) {
                System.out.println("Hit!");
            } else {
                System.out.println("Miss!");
            }

            game.incrementTurns();
        }

        printBoard(game);
        System.out.println(game.getGameStatus());
        System.out.println("The targets were: ");
        for (Target target : game.getAllTargets()) {
            System.out.println(target);
        }

        scanner.close();
    }

    private static void printBoard(Game game) {
        int size = Game.SIZE;
        char[][] board = new char[size][size];

        // Initialize board with empty cells
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }

        // Mark targets for display once game is over
        if (game.isGameOver()) {
            for (Target target : game.getAllTargets()) {
                board[target.getX()][target.getY()] = 'T'; // Show target positions
            }
        }

        // Print the board
        System.out.println("Board:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
