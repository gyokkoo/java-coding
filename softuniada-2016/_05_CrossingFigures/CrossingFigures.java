package _05_CrossingFigures;

import java.util.Scanner;

public class CrossingFigures {

    static final double EPSILON = 0.01;

    private static Circle circle;
    private static Rectangle rect;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] firstLineArgs = scanner.nextLine().split("\\(");
            if (firstLineArgs[0].equals("circle")) {
                circle = createCircle(firstLineArgs[1]);
            } else if (firstLineArgs[0].equals("rectangle")) {
                rect = createRectangle(firstLineArgs[1]);
            }

            String[] secondLineArgs = scanner.nextLine().split("\\(");
            if (secondLineArgs[0].equals("circle")) {
                circle = createCircle(secondLineArgs[1]);
            } else if (secondLineArgs[0].equals("rectangle")) {
                rect = createRectangle(secondLineArgs[1]);
            }

            if (circle.isInsideCircle(rect.getA()) &&
                    circle.isInsideCircle(rect.getB()) &&
                    circle.isInsideCircle(rect.getC()) &&
                    circle.isInsideCircle(rect.getD())) {
                System.out.println("Rectangle inside circle");
            } else if (rect.isInsideRectangle(circle.getLeftPoint()) &&
                    rect.isInsideRectangle(circle.getRightPoint()) &&
                    rect.isInsideRectangle(circle.getTopPoint()) &&
                    rect.isInsideRectangle(circle.getBottomPoint())) {
                System.out.println("Circle inside rectangle");
            } else {
                Point centerDistance = new Point(Math.abs(circle.getCenter().getX() - rect.getCenter().getX()),
                        Math.abs(circle.getCenter().getY() - rect.getCenter().getY()));
                double width = rect.getB().getX() - rect.getA().getX();
                double height = rect.getA().getY() - rect.getD().getY();
                if (centerDistance.getX() > width / 2 + circle.getRadius() || centerDistance.getY() > height / 2 +
                        circle.getRadius()) {
                    System.out.println("Rectangle and circle do not cross");
                } else if (centerDistance.getX() <= width / 2 || centerDistance.getY() <= height / 2) {
                    System.out.println("Rectangle and circle cross");
                } else {
                    double cornerDistance = (centerDistance.getX() - width / 2) * (centerDistance.getX() - width / 2)
                            + (centerDistance.getY() - height / 2) * (centerDistance.getY() - height / 2);
                    if (cornerDistance - circle.getRadius() * circle.getRadius() <= EPSILON) {
                        System.out.println("Rectangle and circle cross");
                    } else {
                        System.out.println("Rectangle and circle do not cross");
                    }
                }
            }
        }
    }

    private static Rectangle createRectangle(String args) {
        String[] coordinates = args.substring(0, args.length() - 1).split(", ");
        double aX = Double.parseDouble(coordinates[0]);
        double aY = Double.parseDouble(coordinates[1]);
        double dX = Double.parseDouble(coordinates[2]);
        double dY = Double.parseDouble(coordinates[3]);
        return new Rectangle(new Point(aX, aY), new Point(dX, dY));
    }

    private static Circle createCircle(String args) {
        String[] coordinates = args.substring(0, args.length() - 1).split(", ");
        double oX = Double.parseDouble(coordinates[0]);
        double oY = Double.parseDouble(coordinates[1]);
        double r = Double.parseDouble(coordinates[2]);
        return new Circle(new Point(oX, oY), r);
    }
}

class Circle {

    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public Point getTopPoint() {
        return new Point(center.getX() - radius, center.getY());
    }

    public Point getBottomPoint() {
        return new Point(center.getX() + radius, center.getY());
    }

    public Point getLeftPoint() {
        return new Point(center.getX(), center.getY() - radius);
    }

    public Point getRightPoint() {
        return new Point(center.getX(), center.getY() + radius);
    }

    public double getRadius() {
        return radius;
    }

    public boolean isInsideCircle(Point p) {
        return ((p.getX() - center.getX()) * (p.getX() - center.getX()) +
                (p.getY() - center.getY()) * (p.getY() - center.getY())) - radius * radius <= CrossingFigures.EPSILON;
    }
}

class Rectangle {

    private Point a;
    private Point c;

    public Rectangle(Point a, Point c) {
        this.a = a;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return new Point(this.getC().getX(), this.getA().getY());
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return new Point(this.getA().getX(), this.getC().getY());
    }

    public Point getCenter() {
        return new Point((a.getX() + c.getX()) / 2, (a.getY() + c.getY()) / 2);
    }

    public boolean isInsideRectangle(Point p) {
        return (getA().getX() <= p.getX() && p.getX() <= getB().getX() &&
                getC().getY() <= p.getY() && p.getY() <= getB().getY());
    }
}

class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
