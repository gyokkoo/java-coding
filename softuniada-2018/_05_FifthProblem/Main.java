package _05_FifthProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static final double TOL = 0.0000001;

    public static Circle circleFromPoints(final Point p1, final Point p2, final Point p3)
    {
        final double offset = Math.pow(p2.x,2) + Math.pow(p2.y,2);
        final double bc = (Math.pow(p1.x,2) + Math.pow(p1.y,2) - offset )/2.0;
        final double cd = (offset - Math.pow(p3.x, 2) - Math.pow(p3.y, 2))/2.0;
        final double det = (p1.x - p2.x) * (p2.y - p3.y) - (p2.x - p3.x)* (p1.y - p2.y);

        if (Math.abs(det) < TOL) { throw new IllegalArgumentException("Yeah, lazy."); }

        final double idet = 1/det;

        final double centerx =  (bc * (p2.y - p3.y) - cd * (p1.y - p2.y)) * idet;
        final double centery =  (cd * (p1.x - p2.x) - bc * (p2.x - p3.x)) * idet;
        final double radius =
                Math.sqrt( Math.pow(p2.x - centerx,2) + Math.pow(p2.y-centery,2));

        return new Circle(new Point(centerx,centery),radius);
    }

    static class Circle
    {
        final Point center;
        final double radius;
        public Circle(Point center, double radius)
        {
            this.center = center; this.radius = radius;
        }

        public boolean isOpisana(Circle o) {
            if ((int)this.center.x  == (int)o.center.x &&
                    (int)this.center.y  == (int)o.center.y &&
                    (int) this.radius == (int)o.radius) {
                return true;
            }

            return false;
        }
    }

    static class Point
    {
        final double x,y;

        public Point(double x, double y)
        {
            this.x = x; this.y = y;
        }

    }

    static class Triangle {
        Point a;
        Point b;
        Point c;

        Triangle(Point a, Point b, Point c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        double sign (Point p1, Point p2, Point p3)
        {
            return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
        }

        boolean PointInTriangle (Point pt)
        {
            boolean b1, b2, b3;
            Point v1 = this.a;
            Point v2 = this.b;
            Point v3 = this.c;
            b1 = sign(pt, v1, v2) < 0.0f;
            b2 = sign(pt, v2, v3) < 0.0f;
            b3 = sign(pt, v3, v1) < 0.0f;

            return ((b1 == b2) && (b2 == b3));
        }
	}

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] circleArgs = reader.readLine().split("[,\\s+]+");
            String[] triangleArgs = reader.readLine().split("[,\\s+]+");
            double Ox = Double.parseDouble(circleArgs[1]);
            double Oy = Double.parseDouble(circleArgs[2]);
            double radius = Double.parseDouble(circleArgs[3]);
            Point o = new Point(Ox, Oy);
            double Ax = Double.parseDouble(triangleArgs[1]);
            double Ay = Double.parseDouble(triangleArgs[2]);
            double Bx = Double.parseDouble(triangleArgs[3]);
            double By = Double.parseDouble(triangleArgs[4]);
            double Cx = Double.parseDouble(triangleArgs[5]);
            double Cy = Double.parseDouble(triangleArgs[6]);
            Point a = new Point(Ax, Ay);
            Point b = new Point(Bx, By);
            Point c = new Point(Cx, Cy);
            Circle circle = new Circle(o, radius);
            Circle circleTwo = circleFromPoints(a, b, c);
            Triangle triangle = new Triangle(a, b, c);
            boolean isOpisana = circle.isOpisana(circleTwo);
            boolean isInsideTriangle = triangle.PointInTriangle(circle.center);
            if (isOpisana && isInsideTriangle) {
                System.out.println("The circle is circumscribed and the center is inside.");
            }
            if (isOpisana && !isInsideTriangle) {
                System.out.println("The circle is circumscribed and the center is outside.");
            }
            if (!isOpisana && !isInsideTriangle) {
                System.out.println("The circle is not circumscribed and the center is outside.");
            }
            if (!isOpisana && isInsideTriangle) {
                System.out.println("The circle is not circumscribed and the center is inside.");
            }
        }
    }
}
