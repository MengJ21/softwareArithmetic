package experiment2Recursion;

import experiment1Sort.mergeSort;

public class MergeSort {
    public void sortByMerge(int[] nums, int start, int end) {
        if (start == end) {
            return;
        } else {
            int mid = (start + end) / 2;
            // 排列前n/2个元素，并依次递归调用。
            sortByMerge(nums,start,mid);
            // 排列后n/2个元素，并以此递归调用。
            sortByMerge(nums,mid + 1, end);
            // 合并。
            merge(nums,start,mid + 1, end + 1);
        }
    }
    public void merge(int[] nums, int start1, int start2, int end) {
        int[] res = new int[end - start1];
        int p = 0;
        // 合并函数，依次选取两个子数组中的最小值，依次放入辅助数组res中。
        for (int x = start1, y = start2;(x < start2) && (y < end);) {
            if (nums[x] < nums[y]) {
                res[p] = nums[x];
                x++;
            } else {
                res[p] = nums[y];
                y++;
            }
            p++;
            // 第一个数组中元素用完。
            if (x == start2) {
                while (y < end) {
                    res[p] = nums[y];
                    y++;
                    p++;
                }
            }
            // 第二个数组中元素用完。
            if (y == end) {
                while (x < start2) {
                    res[p] = nums[x];
                    x++;
                    p++;
                }
            }
        }
        // 将辅助数组中的值对原数组尽进行替换。
        System.arraycopy(res,0,nums,start1,res.length);
    }
    public static void main(String[] args) {
        //(int) Math.pow(2,14);
        int[] nums = new int[10000];
        for (int tag = 0;tag < 10000;tag++){
            nums[tag] = (int)(Math.random() * 10000);
        }
        MergeSort mergeSort = new MergeSort();
        long start = System.currentTimeMillis();
        mergeSort.sortByMerge(nums,0,nums.length - 1);
        long end = System.currentTimeMillis();
        System.out.println(10000+"个数据"+"运行时间："+(end - start)+"毫秒");
        for (int i : nums) {
            System.out.print(i+"-");
        }
    }
}
