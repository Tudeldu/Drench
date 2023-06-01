public class DepthSolver extends Solver{

    //Does not work properly yet
    
    public DepthSolver(Board board, Visualizer visualizer) {
        super(board, visualizer);
    }

    public void solve() {
        while (!board.isSolved()) {
            Color bestMove = getBestMove(board);
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

    private Board[] getNextMoves(Board board){
        Board[] out=new Board[Color.values().length];
        for(int i=0;i<out.length;i++){
            out[i]=board.copy();
            out[i].move(Color.values()[i]);
        }
        return out;
    }

    private Color getBestMove(Board board){
        Board[] nextMoves=getNextMoves(board);
        Board[] futureMoves=new Board[nextMoves.length*Color.values().length];
        for(int i=0;i<nextMoves.length;i++){
            futureMoves[i*Color.values().length]=nextMoves[i];
            for(int j=0;j<Color.values().length;j++){
                futureMoves[i*Color.values().length+j]=getNextMoves(nextMoves[i])[j];
            }
        }
        int[] scores=new int[futureMoves.length];
        for(int i=0;i<scores.length;i++){
            scores[i]=futureMoves[i].getScore();
        }
        int bestScore=0;
        int bestMove=0;
        for(int i=0;i<scores.length;i++){
            if(scores[i]>bestScore){
                bestScore=scores[i];
                bestMove=i/Color.values().length;
            }
        }
        return Color.values()[bestMove];
    }
}
