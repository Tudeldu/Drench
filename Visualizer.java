
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Visualizer extends Frame {

    private Board board;
    private static final int Frame_Size = 600;

    public Visualizer(Board board) {
        this.board = board;
        setSize(Frame_Size, Frame_Size);
        setVisible(true);

        // ends Programm, when window is closed
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void paint(Graphics g) {
        int size = board.getSize();
        int width = 600 / size;
        int height = 600 / size;
        for (int i = 0; i < size; i++) {
            int y = i * height;
            for (int j = 0; j < size; j++) {
                int x = j * width;
                g.setColor(convertColor(board.getColor(i, j)));
                g.fillRect(x, y, width, height);
            }
        }
    }

    // converts color from slef made Enum to java.awt.Color
    private static java.awt.Color convertColor(Color color) {
        switch (color) {
            case RED:
                return java.awt.Color.RED;
            case GREEN:
                return java.awt.Color.GREEN;
            case BLUE:
                return java.awt.Color.BLUE;
            case ORANGE:
                return java.awt.Color.ORANGE;
            case YELLOW:
                return java.awt.Color.YELLOW;
            case PINK:
                return java.awt.Color.PINK;
            default:
                return java.awt.Color.BLACK;
        }
    }

    // prints teh board to the console and returns it as a String
    public static String PrintBoard(Board board) {
        String out = board.toString();
        System.out.println(out);
        return out;
    }

}
