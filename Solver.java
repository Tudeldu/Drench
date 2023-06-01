public abstract class Solver {
    public Board board;
    public Visualizer visualizer;
    public static final int PAUSE_BETWEEN_FRAMES = 10;
    public abstract void solve();
    public Solver(Board board, Visualizer visualizer){
        this.board=board;
        this.visualizer=visualizer;
    }

}
