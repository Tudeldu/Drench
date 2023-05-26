

import java.awt.*;
/*<applet code="Chess" width=600 height=600>
</applet>*/
// Extends Applet Class
public class Visualizer extends Frame{
    
 
    private Board board;
    public Visualizer(Board board){
        this.board=board;
        setSize(600,600);
        setVisible(true);
    }
 
    // Use paint() method
    public void paint(Graphics g){
        int size=board.getSize();
        int x, y;
        for (int row = 0; row <size; row++) {
 
            for (int col = 0; col <size; col++) {
 
                // Set x coordinates of rectangle
                // by 20 times
                x = row * 20;
 
                // Set y coordinates of rectangle
                // by 20 times
                y = col * 20;
 
                // Check whether row and column
                // are in even position
                // If it is true set Black color
                g.setColor(convertColor(board.getColor(row,col)));
 
                // Create a rectangle with
                // length and breadth of 20
                g.fillRect(x, y, 20, 20);
            }
        }
    }

    private static java.awt.Color convertColor(Color color){
        switch(color){
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








    public static String displayBoard(Board board){
        String output="";
        for(int i=0;i<board.getSize();i++){
            for(int j=0;j<board.getSize();j++){
                char current=board.getColor(i,j).toString().charAt(0);
                if(board.isConverted(i,j)){
                    current=Character.toLowerCase(current);
                }
                output+=current;
            }
            output+="\n";
        }
        return output;
    }

    
    
}
