package SnakeLadder;

import java.util.ArrayList;
import java.util.List;

public class Board {
    
    int position;
    List<Snake> snakes;
    List<Ladder> ladders;

    public Board() {
        this.position = 100;
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        initializeSnakeLadders();
    }

    private void initializeSnakeLadders() {
        snakes.add(new Snake(99, 78));
        snakes.add(new Snake(95, 56));
        snakes.add(new Snake(88, 24));
        snakes.add(new Snake(36, 6));

        ladders.add(new Ladder(4, 63));
        ladders.add(new Ladder(22, 78));
        ladders.add(new Ladder(19, 50));
        ladders.add(new Ladder(52, 96));
    }

    public boolean isAtSnakeHead(int position) {
        for (Snake s : snakes) {
            if (s.head == position) {
                return true;
            }
        }
        return false;
    }

    public boolean isAtLadderBase(int position) {
        for (Ladder l : ladders) {
            if (l.base == position) {
                return true;
            }
        }
        return false;
    }

    public int getSnakeHead(int position) {
        for (Snake s : snakes) {
            if (s.head == position) {
                return s.tail; 
            }
        }
        return position;
    }

    // Get ladder top if at base
    public int getLadderBase(int position) {
        for (Ladder l : ladders) {
            if (l.base == position) {
                return l.top; 
            }
        }
        return position;
    }

    public boolean checkWinner(int position) {
        return position == this.position;
    }
}
