package com.github.ludvigwarpe.closestpoints;

/**
 * @author Ludvig Warpe
 *
 */

public class App {

    /*
     * Small application that creates points on a plane and calculates the closest
     * pair of points.
     */
    public static void main(String[] args) {

        Point[] points = { new Point(25, 90), new Point(45, 80),
                new Point(70, 60), new Point(95, 10),
                new Point(0, 0), new Point(100, 100), new Point(10, 78),
                new Point(95, 12), new Point(20, 85) };

        System.out.println("-----Distances Between Points-----");
        for (Point p1 : points) {
            for (Point p2 : points) {
                if (!p1.equals(p2))
                    System.out.println(p1 + " to " + p2 + " distance: " + p1.distanceTo(p2));
            }
        }
        System.out.println();

        Point[] closest = ClosestPoints.findClosestPairOfPoints(points);

        System.out.println("Closest Points:");
        for (Point p : closest)
            System.out.print(p + " ");
        System.out.print(" distance:" + closest[0].distanceTo(closest[1]));
    }
}
