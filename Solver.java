
public class Solver {
    public static void solve(Board board) {
        while (!board.isSolved()) {
            Color bestMove = getBestMove(board);
            board.changeColor(bestMove);
            System.out.println(Visualizer.displayBoard(board));
        }
    }

    private static int getScoreAfterMove(Board board, Color color) {
        Board copy = board.copy();
        copy.changeColor(color);
        return copy.getScore();
    }

    private static Color getBestMove(Board board) {
        Color bestMove = Color.RED;
        if (getScoreAfterMove(board, Color.GREEN) > getScoreAfterMove(board, Color.RED)) {
            bestMove = Color.GREEN;
        }
        if (getScoreAfterMove(board, Color.BLUE) > getScoreAfterMove(board, bestMove)) {
            bestMove = Color.BLUE;
        }
        if (getScoreAfterMove(board, Color.YELLOW) > getScoreAfterMove(board, bestMove)) {
            bestMove = Color.YELLOW;
        }
        if (getScoreAfterMove(board, Color.ORANGE) > getScoreAfterMove(board, bestMove)) {
            bestMove = Color.ORANGE;
        }
        if (getScoreAfterMove(board, Color.PINK) > getScoreAfterMove(board, bestMove)) {
            bestMove = Color.PINK;
        }
        return bestMove;
    }
}
