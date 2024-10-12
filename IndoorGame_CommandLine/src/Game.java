import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public static final int SIZE = 5;
    private List<Target> targets = new ArrayList<>();
    private int turns = 0;
    private static final int NO_OF_TURNS = 13;

    public Game() {
        Random rand = new Random();

        // Randomly generate 3 targets on the grid
        for (int j = 0; j < 3; j++) {
            int x = rand.nextInt(SIZE);
            int y = rand.nextInt(SIZE);
            targets.add(new Target(x, y));
        }
    }

    public boolean makeMove(int x, int y) {
        for (Target target : targets) {
            if (target.isHit(x, y)) {
                targets.remove(target);
                return true;
            }
        }
        return false;
    }

    public boolean isGameOver() {
        return targets.isEmpty() || turns >= NO_OF_TURNS;
    }

    public String getGameStatus() {
        if (targets.isEmpty()) {
            return "Congratulations! You've hit all the targets.";
        } else if (turns >= NO_OF_TURNS) {
            return "Game Over! You've run out of turns.";
        }
        return "Make your move (" + (NO_OF_TURNS - turns) + " turns remaining)";
    }

    public void incrementTurns() {
        turns++;
    }

    public List<Target> getAllTargets() {
        return new ArrayList<>(targets);
    }
}
