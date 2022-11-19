package test;

import java.util.Scanner;


class num1 {
    public int getCount(int n, int count) {
        if (n == 1) {
            return count;
        } else {
            if (n % 2 == 0){
                count++;
                return getCount(n / 2, count);
            } else {
                count++;
                n = (n * 3 + 1) / 2;
                return getCount(n, count);
            }
        }
    }
    public static int TriangleType(int a, int b, int c) {
        if ((a + b) > c && (a + c) > b && (b + c) > a) {
            if (a == c && b == c) {
                return 3;
            } else if (a == c || b == c || a == b) {
                return 2;
            } else {
                return 1;
            }
        }else {
            return 0;
        }
    }
    public static void main(String[] args){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println(num1.TriangleType(a, b, c));
        }
    }
}

