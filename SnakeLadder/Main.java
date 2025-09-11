package SnakeLadder;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        Player player1 = new Player("Aditya ", "aditya@gmail.com");
        Player player2 = new Player("Anurag", "anurag@gmail.com");
        Player player3 = new Player("Rohit", "rohit@gmail.com");
        game.startGame(new Player[]{player1, player2, player3});
    }
}
