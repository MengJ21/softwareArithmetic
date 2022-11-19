package experiment3Divide.minD;

public class SortPoint {
    public void sortPointSetByX(Point[] points) {
        int len = points.length;
        for (int i = 0;i < len - 1;i++) {
            int tag = i;
            for (int j = i + 1;j < len;j++) {
                if (points[tag].x > points[j].x) {
                    tag = j;
                }
            }
            Point temp = points[i];
            points[i] = points[tag];
            points[tag] = temp;
        }
    }
    public void sortPointSetByY(Point[] points, int start, int end) {
        if (start < end) {
            int len = points.length;
            int i = start, j = end;
            Point temp = points[start];
            while (i < j) {
                while (i < j) {
                    if (points[j].y > temp.y) {
                        j--;
                    } else {
                        points[i] = points[j];
                        i++;
                        break;
                    }
                }
                while (i < j) {
                    if (points[i].y < temp.y) {
                        i++;
                    } else {
                        points[j] = points[i];
                        j--;
                        break;
                    }
                }
                points[i] = temp;
                sortPointSetByY(points, start, i - 1);
                sortPointSetByY(points, i + 1, end);
            }
        }
    }
    public static void main(String[] args) {
        GeneratePointSet g = new GeneratePointSet();
        Point[] points = g.setPoint();
        SortPoint s = new SortPoint();
//        for(Point p : points) {
//            System.out.print("（" + p.x + "，" + p.y + "）" + "，");
//        }
//        s.sortPointSetByX(points);
//        for(Point p : points) {
//            System.out.print("（" + p.x + "，" + p.y + "）" + "，");
//        }
        s.sortPointSetByY(points,0,points.length - 1);
        for(Point p : points) {
            System.out.print("（" + p.x + "，" + p.y + "）" + "，");
        }

    }
}
