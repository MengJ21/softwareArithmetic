package experiment3Divide.minD;

public class GeneratePointSet {
    public Point[] setPoint() {
        Point[] points = new Point[1000];
        for (int i = 0;i < 1000;i++) {
            int xt = (int) (Math.random() * 1000);
            int yt = (int) (Math.random() * 1000);
            points[i] = new Point();
            points[i].x = xt;
            points[i].y = yt;
        }
        return points;
    }

    public static void main(String[] args) {
        GeneratePointSet g = new GeneratePointSet();
        Point[] points = g.setPoint();
        for (Point p : points) {
            System.out.println("（" + p.x + "，" + p.y + "）");
        }
    }
}
