import java.util.*;

class Polyline {
    private final List<Point> points;

    public Polyline(List<Point> points) {
        this.points = points;
    }

    public static Polyline createPolyline(List<Point> points) {
        // Метод просто создает объект Polyline из готового списка
        return new Polyline(points);
    }

    public String toString() {
        return "Линия [" + String.join(",", points.stream().map(Point::toString).toArray(String[]::new)) + "]";
    }
}