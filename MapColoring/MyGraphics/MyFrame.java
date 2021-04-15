package MapColoring.MyGraphics;

import MapColoring.Connection;
import MapColoring.Point;

import javax.swing.*;
import java.util.ArrayList;

public class MyFrame extends JFrame {
    MyGraphics myGraphics;

    public MyFrame(int width, int height, ArrayList<Point> points, ArrayList<Connection> connections) {
        myGraphics = new MyGraphics(points, connections);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void print() {
        this.add(myGraphics);
        this.setVisible(true);
    }
}
