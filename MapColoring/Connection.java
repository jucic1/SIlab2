package MapColoring;

import java.awt.geom.Line2D;

public class Connection {
    private Point a;
    private Point b;
    private Line2D line;

    public Connection(Point a, Point b) {
        this.a = a;
        this.b = b;
        this.line = new Line2D.Double(a.getPoint(), b.getPoint());
    }


    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Line2D getLine() {
        return line;
    }
}
