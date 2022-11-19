package experiment4dynamicPlanning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class getShortestPath {
    public static class Result {
        List<Integer> sp;
        Integer cost;
        public Result(List<Integer> sp, Integer cost) {
            this.sp = sp;
            this.cost = cost;
        }
    }
    public static Result getMin(int[][] graph, int s, int u,Result[] opt) {
        int cost = 10000;
        List<Integer> sp = new ArrayList<>();
        if (s == u) {
            sp.add(s);
            return new Result(sp,0);
        }
        for (int i = s;i < u;i++) {
            if (opt[i - s] == null) {
                opt[i - s] = getMin(graph, s, i,opt);
            }
            Result result = opt[i - s];
            if (result.cost + graph[i][u] < cost) {
                cost = result.cost + graph[i][u];
                result.sp.add(u);
                sp.clear();
                sp.addAll(result.sp);
                result.sp.remove(result.sp.size() - 1);
            }
        }
        return new Result(sp,cost);
    }

    public static void main(String[] args) {
        int max = 10000;
        int[][] graph = {
                {0,9,7,3,2,max,max,max,max,max,max,max},
                {max,0,max,max,max,4,2,1,max,max,max,max},
                {max,max,0,max,max,2,7,max,max,max,max,max},
                {max,max,max,0,max,max,max,11,max,max,max,max},
                {max,max,max,max,0,max,11,8,max,max,max,max},
                {max,max,max,max,max,0,max,max,6,5,max,max},
                {max,max,max,max,max,max,0,max,4,3,max,max},
                {max,max,max,max,max,max,max,0,max,5,6,max},
                {max,max,max,max,max,max,max,max,0,max,max,4},
                {max,max,max,max,max,max,max,max,max,0,max,2},
                {max,max,max,max,max,max,max,max,max,max,0,5},
        };
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Result[] opt = new Result[end - start + 1];
            Result min = getShortestPath.getMin(graph, start - 1, end - 1, opt);
            System.out.println(min.cost);
            for (int path: min.sp) {
                System.out.print(path + 1 + "->");
            }
            System.out.println();
        }
    }
}
