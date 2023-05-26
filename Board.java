
public class Board {
    private Color[][] board;
    private boolean[][] converted;
    private int size;
    private int Score;
    private boolean solved;

    public Board(int size) {
        this.size = size;
        board = new Color[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Color.randomColor();
            }
        }
        converted = new boolean[size][size];
        converted[0][0] = true;
        Score = 1;
        solved = false;
    }

    public Board(Color[][] board, boolean[][] converted, int size, int convertedSize, boolean solved) {
        this.board = board;
        this.converted = converted;
        this.size = size;
        this.Score = convertedSize;
        this.solved = solved;
    }

    // Creates empty board
    public Board(int size, boolean placeholder) {
        this.size = size;
        board = new Color[size][size];
        converted = new boolean[size][size];
        Score = 1;
    }

    public Color[][] getBoard() {
        return board;
    }

    public Color getColor(int i, int j) {
        return board[i][j];
    }

    public int getSize() {
        return size;
    }

    public boolean isConverted(int i, int j) {
        return converted[i][j];
    }

    public int getScore() {
        return Score;
    }

    public boolean isSolved() {
        return solved;
    }

    public Board copy() {
        Board copy = new Board(size, true);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                copy.board[i][j] = board[i][j];
                copy.converted[i][j] = converted[i][j];
            }
        }
        copy.Score = Score;
        copy.solved = solved;
        return copy;
    }

    public void changeColor(Color color) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (converted[i][j]) {
                    // changes coler of aready converted tiles
                    board[i][j] = color;
                } else if (board[i][j] == color) {
                    // converts adjacent tiles of same color
                    boolean notConverted = true;
                    try {
                        if (notConverted && converted[i - 1][j]) {
                            convert(i, j);
                            notConverted = false;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (notConverted && converted[i + 1][j]) {
                            convert(i, j);
                            notConverted = false;

                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (notConverted && converted[i][j - 1]) {
                            convert(i, j);
                            notConverted = false;

                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (notConverted && converted[i][j + 1]) {
                            convert(i, j);
                            notConverted = false;

                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private void convert(int i, int j) {
        converted[i][j] = true;
        Score++;
        if (Score == size * size) {
            solved = true;
        }
    }
}
