package MapColoring.MyGraphics;

import MapColoring.Connection;
import MapColoring.MyColor;
import MapColoring.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class MyGraphics extends JPanel {
    private ArrayList<Point> points;
    private ArrayList<Connection> connections;

    public MyGraphics(ArrayList<Point> points, ArrayList<Connection> connections) {
        this.points = points;
        this.connections = connections;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        for (Connection connection : connections) {
            g.setColor(Color.BLACK);
            g2.draw(connection.getLine());
        }

        for (Point point : points) {
            Line2D pointWorkaround = new Line2D.Double(point.getPoint(), point.getPoint());
            g.setColor(getColor(point.getColor()));
            g2.setStroke(new BasicStroke(5));
            g2.draw(pointWorkaround);
        }
    }

    private static Color getColor(MyColor myColor) {
        switch (myColor) {
            case WHITE:
                return Color.WHITE;
            case YELLOW:
                return Color.YELLOW;
            case BLUE:
                return Color.BLUE;
            case GREEN:
                return Color.GREEN;
            case RED:
                return Color.RED;
            default:
                return Color.BLACK;
        }

    }
}
