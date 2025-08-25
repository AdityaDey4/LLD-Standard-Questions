package TicTacToe;
// import java.util.Scanner;

// class Player {
//     String name;
//     char symbol;

//     public Player(String name, char symbol) {
//         this.name = name;
//         this.symbol = symbol;
//     }
// }

// class Board {
//     char[][] cells = new char[3][3];

//     public Board() {
//         for (int i = 0; i < 3; i++)
//             for (int j = 0; j < 3; j++)
//                 cells[i][j] = ' ';
//     }

//     public boolean markCell(int row, int col, char symbol) {
//         if(row < 0 || row > 2 || col < 0 || col > 2) return false;
//         if (cells[row][col] != ' ') return false;
//         cells[row][col] = symbol;
//         return true;
//     }

//     public boolean isFull() {
//         for (char[] row : cells)
//             for (char cell : row)
//                 if (cell == ' ') return false;
//         return true;
//     }

//     public void display() {
//         for (char[] row : cells) {
//             for (char cell : row) System.out.print("|" + cell);
//             System.out.println("|");
//         }
//     }

//     public void reset() {
//         for(int i=0; i<3; i++) {
//             for(int j=0; j<3; j++) {
//                 cells[i][j] = ' ';
//             }
//         }
//     }

//     public boolean hasWinner(char symbol) {
//         // Rows, columns, diagonals
//         for (int i = 0; i < 3; i++)
//             if (cells[i][0] == symbol && cells[i][1] == symbol && cells[i][2] == symbol)
//                 return true;
//         for (int i = 0; i < 3; i++)
//             if (cells[0][i] == symbol && cells[1][i] == symbol && cells[2][i] == symbol)
//                 return true;
//         if (cells[0][0] == symbol && cells[1][1] == symbol && cells[2][2] == symbol)
//             return true;
//         if (cells[0][2] == symbol && cells[1][1] == symbol && cells[2][0] == symbol)
//             return true;
//         return false;
//     }
// }

// class Game {
//     Player[] players;
//     Board board;
//     int currentPlayerIndex;
//     Scanner sc;

//     public Game(Player p1, Player p2) {
//         players = new Player[]{p1, p2};
//         board = new Board();
//         currentPlayerIndex = 0;
//         sc = new Scanner(System.in);
//     }

//     public void start() {
//         while (true) {
//             board.display();
//             Player player = players[currentPlayerIndex];
//             System.out.println(player.name + "'s turn (" + player.symbol + ")");
//             System.out.print("Enter row and column (0-2): ");
//             int row = sc.nextInt();
//             int col = sc.nextInt();

//             if (!board.markCell(row, col, player.symbol)) {
//                 System.out.println("Invalid move. Try again.");
//                 continue;
//             }

//             if (board.hasWinner(player.symbol)) {
//                 board.display();
//                 System.out.println(player.name + " wins!");

//                 checkRestart();
//                 break;
//             }

//             if (board.isFull()) {
//                 board.display();
//                 System.out.println("It's a draw!");

//                 checkRestart();
//                 break;
//             }

//             currentPlayerIndex = 1 - currentPlayerIndex;
//         }
//     }

//     public void checkRestart() {
//         System.out.print("Do you want to play again? (y/n): ");
//         String again = sc.next().toLowerCase();
//         if (again.equals("y")) {
//             System.out.println("Game has restarted");
            
//             board.reset();
//             start();
//         }
//         System.out.println("Thanks for playing!");
//         return;        
//     }
// }

public class TicTacToe {

    public static void main(String args[]) {
        // Player p1 = new Player("Player 1", 'X');
        // Player p2 = new Player("Player 2", 'O');
        // Game game = new Game(p1, p2);
        // game.start();
    }
}