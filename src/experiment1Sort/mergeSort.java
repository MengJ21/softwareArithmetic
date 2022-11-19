package experiment1Sort;

import java.security.PublicKey;

public class mergeSort {
    // 自底向上的归并排序，使用for循环。
    public int[] orderByMergingByFor(int[] nums) {
        // k是2的整数次幂。
        int k = (int)(Math.log(nums.length) / Math.log(2));
        // 遍历每一个k，每个k的增量（一个子集合的元素的个数）是2的k次方。
        for (int i = 1;i <= k;i++) {
            // 定义增量
            int increase;
            if (i == 1) {
                // 最开使子集合元素个数是一
                increase = 1;
            } else {
                // 以后一次扩大二倍。
                increase = (int) Math.pow(2,i - 1);
            }
            int j;
            for (j = 0;j <= nums.length - (increase * 2);j += increase * 2) {
                // 对每两组进行合并。从数组下标0开始
                merge(nums,j,j + increase,j + increase * 2);
            }
            if ( j + increase < nums.length) {
//                出现情况元素个数不是2的整数次幂。
                merge(nums,j,j + increase,nums.length);
            }
        }
        return nums;
    }
    // 合并函数。合并两个有序数组。
    public void merge(int[] nums, int start1, int start2, int end) {
        int[] res = new int[end - start1];
        int p = 0;
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
        System.arraycopy(res,0,nums,start1,res.length);
    }
    public static void main(String[] args) {
        //(int) Math.pow(2,14);
        int[] nums = new int[10000];
        for (int tag = 0;tag < 10000;tag++){
            nums[tag] = (int)(Math.random() * 10000);
        }
        mergeSort mergeSort = new mergeSort();
        long start = System.nanoTime();
        int[] ints = mergeSort.orderByMergingByFor(nums);
        long end = System.nanoTime();
        System.out.println(10000+"个数据"+"运行时间："+(end - start)+"纳秒");
        for (int i : ints) {
            System.out.print(i+"-");
        }
    }
}
