
public class Board {
    private Color[][] board;
    private boolean[][] converted;
    private int size;
    private int Score;
    private boolean solved;
    private int moves;

    // creates a random board with a given size
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

    // creates a board with a given size and a given board !only square Boards were
    // considered when implementing everything!
    public Board(Color[][] board, boolean[][] converted, int size, int convertedSize, boolean solved) {
        this.board = board;
        this.converted = converted;
        this.size = size;
        this.Score = convertedSize;
        this.solved = solved;
    }

    // Creates empty board placeholder is only there for method identification true
    // or false does not matter
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

    public int getMoves() {
        return moves;
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

    /*
     * changes the color of the converted tiles and converts adjacent tiles
     */
    public void move(Color color) {
        moves++;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (converted[i][j]) {
                    // changes coler of aready converted tiles
                    board[i][j] = color;
                } else if (board[i][j] == color) {
                    // converts adjacent tiles of same color
                    boolean notConverted = true;
                    if (i > 0) {
                        if (notConverted && converted[i - 1][j]) {
                            convert(i, j);
                            notConverted = false;
                        }
                    }
                    if (i < size - 1) {
                        if (notConverted && converted[i + 1][j]) {
                            convert(i, j);
                            notConverted = false;
                        }
                    }
                    if (j > 0) {
                        if (notConverted && converted[i][j - 1]) {
                            convert(i, j);
                            notConverted = false;
                        }
                    }
                    if (j < size - 1) {
                        if (notConverted && converted[i][j + 1]) {
                            convert(i, j);
                            notConverted = false;
                        }
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

    /*
     * returns a String representation of the board, with the first letter of each
     * color capitalized if it is not converted and lowercase if it is converted
     */
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                char current = getColor(i, j).toString().charAt(0);
                if (isConverted(i, j)) {
                    current = Character.toLowerCase(current);
                }
                output += current;
            }
            output += "\n";
        }
        return output;
    }
}
