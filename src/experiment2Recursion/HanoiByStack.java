package experiment2Recursion;

import java.util.Stack;

public class HanoiByStack {
    // 记录次数
    public static int count = 0;
    // 定义ABC三个盘子的数据结构
    static class HanoiRecord {
        int n;
        String from;
        String to;
        String other;

        public HanoiRecord(int n, String from, String to, String other) {
            this.n = n;
            this.from = from;
            this.to = to;
            this.other = other;
        }
    }

    public static void hanoi3(int n) {
        hanoiNonRecursion(n, "A", "C", "B");

    }


    private static void hanoiNonRecursion(int n, String A, String C, String B) {
        if (n < 1) return;

        Stack<HanoiRecord> stack = new Stack<>();
        stack.push(new HanoiRecord(n, A, C, B));
        while (!stack.isEmpty()) {
            HanoiRecord pop = stack.pop();
            if (pop.n == 1) {
                move(pop.from, pop.to);
                count++;
            } else {
                //栈是先进后出的，所以和递归的处理逻辑相反，先把temp到to进栈
                stack.push(new HanoiRecord(pop.n - 1, pop.other, pop.to, pop.from));
                stack.push(new HanoiRecord(1, pop.from, pop.to, pop.other));
                stack.push(new HanoiRecord(pop.n - 1, pop.from, pop.other, pop.to));
            }

        }
    }

    private static void move(String from, String to) {
        System.out.println(" from " + from + " to " + to);
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        hanoi3(16);
        long end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(end - begin);
    }
}
