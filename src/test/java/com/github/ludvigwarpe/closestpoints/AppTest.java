package com.github.ludvigwarpe.closestpoints;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Random;

/**
 * Unit test for closest points App.
 */
public class AppTest {
    private static final int MAX_COORD = 1000;
    private static final Random RND = new Random();

    private Point[] bruteForceSolution(Point[] points) {
        Point[] closest = { points[0], points[1] };
        double closestDistance = closest[0].distanceTo(closest[1]);

        for (Point p1 : points) {
            for (Point p2 : points) {
                if (p1 != p2) {
                    double distance = p1.distanceTo(p2);
                    if (distance < closestDistance) {
                        closest[0] = p1;
                        closest[1] = p2;
                        closestDistance = distance;
                    }
                }
            }
        }

        return closest;
    }

    private Point[] randomPoints(int number) {
        Point[] points = new Point[number];
        for (int i = 0; i < number; i++) {
            points[i] = new Point(RND.nextInt(MAX_COORD), RND.nextInt(MAX_COORD));
        }
        return points;
    }

    @ParameterizedTest
    @ValueSource(ints = { 10, 20, 50, 100 })
    void test(int number) {
        Point[] points = randomPoints(number);

        Point[] x = ClosestPoints.findClosestPairOfPoints(points);
        Point[] y = bruteForceSolution(points);

        assertEquals(y[0].distanceTo(y[1]), x[0].distanceTo(x[1]), 0.1);
    }
}
