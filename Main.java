import java.awt.Graphics;
import java.awt.Graphics2D;

public class Main{
    public static void main(String[] args) {
        Board board=new Board(5);
        // board.setColor(new Color[][]{   {Color.RED,Color.GREEN,Color.BLUE,Color.ORANGE,Color.YELLOW},
        //                                 {Color.RED,Color.GREEN,Color.BLUE,Color.ORANGE,Color.YELLOW},
        //                                 {Color.RED,Color.GREEN,Color.BLUE,Color.ORANGE,Color.YELLOW},
        //                                 {Color.RED,Color.GREEN,Color.BLUE,Color.ORANGE,Color.YELLOW},
        //                                 {Color.RED,Color.GREEN,Color.BLUE,Color.ORANGE,Color.YELLOW} });
        System.out.println(Visualizer.displayBoard(board));
        //uses the paint method
        Visualizer visualizer=new Visualizer(board);
        Solver.solve(board);
    }
}