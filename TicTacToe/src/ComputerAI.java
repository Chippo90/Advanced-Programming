import java.util.ArrayList;
import java.util.List;

public class ComputerAI {

    // Returns a random valid move (row, col)
    public static int[] chooseRandomMove(Board board) {
        List<int[]> moves = new ArrayList<>();
        char[][] grid = board.getBoard();

        // Collect all empty cells
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    moves.add(new int[]{i, j});
                }
            }
        }

        // Pick one at random
        return moves.get((int)(Math.random() * moves.size()));
    }
}
