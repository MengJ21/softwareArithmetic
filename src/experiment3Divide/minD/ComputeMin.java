package experiment3Divide.minD;

import java.util.ArrayList;
import java.util.List;

public class ComputeMin {
    public double getMin(Point[] points) {
        double minD = Double.MAX_VALUE;
        for (int i = 0;i < points.length;i++) {
            for (int j = i + 1;j < points.length;j++) {
                minD = Math.min(minD,distance(points[i],points[j]));
            }
        }
        return minD;
    }
    public double getMin(Point[] points, int start, int end) {
        // 两个点的的情况
        if (end - start == 1) {
            return distance(points[start], points[end]);
        }
        // 三个点的情况，比较两次。
        if (end - start == 2) {
            double d1 = distance(points[start], points[start + 1]);
            double d2 = distance(points[start], points[end]);
            double d3 = distance(points[start + 1], points[end]);
            return Math.min(d1,Math.min(d2, d3));
        }
        int mid = (start + end) / 2;
        // 求左半部分
        double d1 = getMin(points,start,mid);
        // 求右半部分
        double d2 = getMin(points,mid,end);
        double minD = Math.min(d1,d2);
        List<Point> list = new ArrayList<>();
        // 求中间部分。
        for (int i = start;i < end;i++) {
            if (Math.abs(points[i].x - points[mid].x) <= (minD / 2)) {
                list.add(points[i]);
            }
        }
        for (int i = 0;i < list.size();i++) {
            int tag = Math.min(i + 7, list.size());
            for (int j = i + 1;j < tag;j++) {
                minD = Math.min(minD,distance(list.get(i),list.get(j)));
            }
        }
        return minD;
    }
    public double distance(Point p1, Point p2) {
        return Math.sqrt((Math.pow((p1.x - p2.x),2) + Math.pow((p1.y - p2.y), 2)));
    }

    public static void main(String[] args) {
        GeneratePointSet generatePointSet = new GeneratePointSet();
        Point[] points = generatePointSet.setPoint();
        points[0].x = 1;
        points[0].y = 1;
        points[1].x = 1;
        points[1].y = 10;
        SortPoint sortPoint = new SortPoint();
        ComputeMin computeMin = new ComputeMin();
        long start = System.nanoTime();
        sortPoint.sortPointSetByX(points);
        double min = computeMin.getMin(points, 0, points.length - 1);
        long end = System.nanoTime();
        for(Point p : points) {
            System.out.print("（" + p.x + "，" + p.y + "）" + "，");
        }
        System.out.println("");
        System.out.println("利用分治法结果是" + min + "时间是" + (end - start) + "纳秒");
        long start1 = System.nanoTime();
        double min1 = computeMin.getMin(points);
        long end1 = System.nanoTime();
        System.out.println("利用暴力法结果是" + min1 + "时间是" + (end1 - start1) + "纳秒");
    }
}
