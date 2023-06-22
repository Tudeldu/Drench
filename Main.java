public class Main {
    private static final int SIZE = 150;

    public static void main(String[] args) {
        Board board1 = new Board(SIZE);
        Board board2 = board1.copy();
        System.out.println(board1);

        Visualizer visualizer1 = new Visualizer(board1);
        Visualizer visualizer2 = new Visualizer(board2);
        Solver solver = new DepthSolver(board1, visualizer1);
        Solver solver2 = new SimpleSolver(board2, visualizer2);
        solver.solve();
        solver2.solve();
        System.out.println("Solved " + SIZE + "x" + SIZE + " board in " + board1.getMoves() + " moves. with DepthSolver");
        System.out.println("Solved " + SIZE + "x" + SIZE + " board in " + board2.getMoves() + " moves. with SimpleSolver");
        
    }
}