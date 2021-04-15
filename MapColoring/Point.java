package MapColoring;

import java.awt.geom.Point2D;

public class Point {
    private Point2D point;
    private MyColor color ;

    public Point(Point2D point, MyColor color) {
        this.point = point;
        this.color = color;
    }

    public Point(Point2D point) {
        this.point = point;
        this.color = null;
    }

    public Point(double x, double y) {
        this.point = new Point2D.Double(x, y);
        this.color = null;
    }

    public Point2D getPoint() {
        return point;
    }

    public MyColor getColor() {
        return color;
    }

    public void setPoint(Point2D point) {
        this.point = point;
    }

    public void setColor(MyColor color) {
        this.color = color;
    }

    public double distanceSq(Point pt) {
        double px = pt.getPoint().getX() - this.getPoint().getX();
        double py = pt.getPoint().getY() - this.getPoint().getY();
        return (px * px + py * py);
    }
}
