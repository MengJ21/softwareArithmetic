package experiment2Recursion;

import java.util.Stack;

public class Hanoi {
    public static long count = 0;
    // 利用栈存取三个盘子的结构。
    public void hanNuoTa(Stack<Integer> A,Stack<Integer> B, Stack<Integer> C) {
        move(A.size(),A,B,C);
    }
    // 不断通过move函数调用。
    public void move(Integer n,Stack<Integer> A,Stack<Integer> B, Stack<Integer> C) {
        if (n == 1) {
            C.push(A.pop());
            count++;
            return;
        }
        // 将n-1个盘子从A移到B
        move(n-1,A,C,B);
//        将第n个盘子从A移到C
        C.push(A.pop());
        count++;
        // 将n-1个破案子从B移到C
        move(n-1,B,A,C);
    }

    public static void main(String[] args) {
        Stack<Integer> A = new Stack<>(){};
        Stack<Integer> B = new Stack<>(){};
        Stack<Integer> C = new Stack<>(){};
        A.push(1);
        A.push(1);
        A.push(1);
        A.push(1);
        A.push(1);
        A.push(1);
        A.push(1);
        A.push(1);
        A.push(1);
        A.push(1);
        A.push(1);
        A.push(1);
        A.push(1);
        A.push(1);
        A.push(1);
        A.push(1);
        Hanoi h = new Hanoi();
        long begin = System.currentTimeMillis();
        h.hanNuoTa(A,B,C);
        long end = System.currentTimeMillis();
        System.out.println(Hanoi.count);
        System.out.println(end - begin );
    }
}
