package MapColoring;

import MapColoring.MyGraphics.MyFrame;

import java.awt.geom.Point2D;
import java.util.*;

public class MapColoring {
    private int numberOfColors;
    private int numberOfPoints;
    private ArrayList<Connection> connections;
    private ArrayList<Point> points;
    private List<MyColor> myColors;
    private int maxX;
    private int maxY;

    public MapColoring(int maxX, int maxY, int numberOfColors, int numberOfPoints) {
        this.numberOfColors = numberOfColors;
        this.numberOfPoints = numberOfPoints;
        this.maxX = maxX;
        this.maxY = maxY;

        myColors = Arrays.asList(MyColor.values()).subList(0, numberOfColors - 1);
        points = generateRandomPoints(maxX, maxY, numberOfPoints);
//        points = new ArrayList<Point>();
//        points.add(new Point(40, 100));
//        points.add(new Point(40, 400));
//        points.add(new Point(40, 300));
//        points.add(new Point(40, 200));
        connections = connectPoints(points);
    }

    public void runBacktracking() {
        if(!this.canAssignColorToPoint(0, points)) {
            System.out.println("Couldn't find combination");
        }
    }

    private boolean canAssignColorToPoint(int pointIndex, ArrayList<Point> points) {
        if (pointIndex == this.points.size()) {
            return true;
        }

        for (MyColor color : myColors) {
            if (canPlaceValue(pointIndex, color, points, connections)) {
                points.get(pointIndex).setColor(color);
                if(canAssignColorToPoint(pointIndex + 1, points)) {
                    return true;
                }
                points.get(pointIndex).setColor(null);
            }
        }
        return false;
    }

    private boolean canPlaceValue(int pointIndex, MyColor color, ArrayList<Point> points, ArrayList<Connection> connections) {
        Point myPoint = points.get(pointIndex);

        if (myPoint.getColor() != null) {
            return false;
        }
        for (Connection connection : connections) {
            if ((connection.getA().equals(myPoint) && connection.getB().getColor()!=null && connection.getB().getColor().equals(color)) ||
                    (connection.getB().equals(myPoint) && connection.getA().getColor()!=null && connection.getA().getColor().equals(color))) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Connection> connectPoints(ArrayList<Point> points) {
        ArrayList<Connection> connectionsOfPoints = new ArrayList<>();

        for (Point myPoint : points) {
            boolean allConnected = false;
            ArrayList<Point> fromClosestToFurthestPoint = new ArrayList<>(points);
            fromClosestToFurthestPoint.sort(createComparator(myPoint));//sortFromClosestToFurthestPoint(myPoint, points);

            for (Point otherPoint : fromClosestToFurthestPoint) {
                if (!allConnected) {
                    if (!myPoint.equals(otherPoint)) {
                        Connection newConnection = new Connection(myPoint, otherPoint);
                        if (connectionsOfPoints.isEmpty() || !connectionsOfPoints.contains(newConnection)) {
                            if (!intersectsWithAnotherLine(newConnection, connectionsOfPoints)) {
                                connectionsOfPoints.add(newConnection);
                            } else {
                                allConnected = true;
                            }
                        }
                    }
                }
            }
        }
        return connectionsOfPoints;
    }

    private static Comparator<Point> createComparator(Point p) {
        final Point finalP = new Point(p.getPoint());
        return (o1, o2) -> {
            double ds0 = o1.distanceSq(finalP);
            double ds1 = o2.distanceSq(finalP);
            return Double.compare(ds0, ds1);
        };
    }

    private boolean intersectsWithAnotherLine(Connection newConnection, ArrayList<Connection> connections) {
        for (Connection connection : connections) {
            if (newConnection.getLine().intersectsLine(connection.getLine()) && !(newConnection.getA().equals(connection.getA()) || newConnection.getA().equals(connection.getB()) || newConnection.getB().equals(connection.getA()) || newConnection.getB().equals(connection.getB()))) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Point> generateRandomPoints(int maxX, int maxY, int numberOfPoints) {
        ArrayList<Point> randomPoints = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < numberOfPoints; i++) {
            double randomX = r.nextInt(maxX * 100) / 100.0;
            double randomY = r.nextInt(maxY * 100) / 100.0;
            Point2D.Double point = new Point2D.Double(randomX, randomY);
            randomPoints.add(new Point(point));
        }
        return randomPoints;
    }

    public void print() {
        MyFrame myFrame = new MyFrame(maxX, maxY, points, connections);
        myFrame.print();
    }
}
