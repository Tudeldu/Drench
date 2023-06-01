public class SimpleSolver extends Solver{

    public SimpleSolver(Board board, Visualizer visualizer) {
        super(board, visualizer);
    }

    // does the best move until the board is solved, updates the visualizer and
    // prints the board to the consoole
    public void solve() {
        while (!board.isSolved()) {
            Color bestMove = getBestMove();
            board.move(bestMove);

            try {
                Thread.sleep(PAUSE_BETWEEN_FRAMES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            visualizer.repaint();
            System.out.println(board);
        }
    }

    // returns the hypothetical score after a move
    private int getScoreAfterMove(Color color) {
        Board copy = board.copy();

        copy.move(color);
        return copy.getScore();
    }

    // returns the move that will result in the highest score int one move
    private Color getBestMove() {
        Color bestMove = Color.RED;
        int bestScore = 0;
        for (Color color : Color.values()) {
            int score = getScoreAfterMove(color);
            if (score > bestScore) {
                bestScore = score;
                bestMove = color;
            }
        }
        return bestMove;
    }
}
