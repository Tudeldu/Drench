public class Main {
    private static final int SIZE = 100;

    public static void main(String[] args) {
        Board board = new Board(SIZE);
        System.out.println(board);

        Visualizer visualizer = new Visualizer(board);
        Solver solver = new Solver(board, visualizer);
        solver.solve();
        System.out.println("Solved " + SIZE + "x" + SIZE + " board in " + board.getMoves() + " moves.");
    }
}