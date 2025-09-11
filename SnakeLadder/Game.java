package SnakeLadder;

public class Game {
    Board board;
    Player[] players;
    int currentPlayerIndex;
    Dice dice;
    GameStatus gameStatus;


    public Game() {
        board = new Board();
        dice = new Dice();
        gameStatus = GameStatus.STOPPED;
    }

    public void startGame(Player[] players) {
        this.players = players;
        currentPlayerIndex = 0;
        gameStatus = GameStatus.RUNNING;
        start();
    }

    private void start() {
        while(gameStatus == GameStatus.RUNNING) {
            Player currPlayer = players[currentPlayerIndex];
            int number = dice.roll();
            
            if(number+currPlayer.position > 100) {
                System.err.println("Player Name : "+currPlayer.name+" Dice : "+number+" Position : "+currPlayer.position+",Sorry we need exact 100");
                currentPlayerIndex = (currentPlayerIndex+1)%players.length;
                continue;
            }
            
            currPlayer.position+= number;
            if(board.checkWinner(currPlayer.position)) {
                System.err.println("Winner : "+currPlayer.name);
                gameStatus = GameStatus.STOPPED;
            }

            if(board.isAtSnakeHead(currPlayer.position)) {
                currPlayer.position = board.getSnakeHead(currPlayer.position);
            } else if(board.isAtLadderBase(currPlayer.position)) {
                currPlayer.position = board.getLadderBase(currPlayer.position);
            }

            System.err.println("Player Name : "+currPlayer.name+" Dice : "+number+" Position : "+currPlayer.position);

            currentPlayerIndex = (currentPlayerIndex+1)%players.length;
        }
    }
}
