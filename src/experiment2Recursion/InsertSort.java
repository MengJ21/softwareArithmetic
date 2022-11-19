package experiment2Recursion;

import experiment1Sort.insertSort;

public class InsertSort {
    public void sortByInsert(int[] nums, int n) {
        if (n == 1) {
            return;
        } else {
            // 依次排号前n-1个元素。
            sortByInsert(nums, n - 1);
            // 将元素插入前n - 1个元素中。
            insert(nums,n - 1);
        }
    }
    public void insert(int[] nums, int n) {
        // 将第n个元素插入到前n - 1个元素中去。
        for (int i = n;i > 0;i--) {
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
            } else {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[10000];
        for (int tag = 0;tag < 10000;tag++){
            nums[tag] = (int)(Math.random() * 10000);
        }
        System.out.println("--------------------------------------------------------------------------------------");
        InsertSort i = new InsertSort();
        long start = System.currentTimeMillis();
        i.sortByInsert(nums,nums.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("运行时间："+(end - start)+"毫秒");
        for (int x : nums) {
            System.out.print(x+"-");
        }
    }
}
