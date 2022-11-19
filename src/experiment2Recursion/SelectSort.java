package experiment2Recursion;

public class SelectSort {
    public void sortBySelect(int[] nums, int n) {
        if (n == 1) {
            return;
        }
        // 每次利用min函数求最小值。
        min(nums,n);
        // 依次递归n个数。
        sortBySelect(nums, n - 1);
    }
    public void min(int[] nums, int n){
        int len = nums.length;
        // tag标志最小值的位置
        int tag = len - n;
        // 求n个数的最小值。
        for (int i = len - n; i < len;i++) {
            if (nums[tag] > nums[i]) {
                tag = i;
            }
        }
        // 交换最小值到初始位置
        int temp = nums[len - n];
        nums[len - n] = nums[tag];
        nums[tag] = temp;
    }
    public static void main(String[] args) {
        int[] nums = new int[10000];
        for (int tag = 0;tag < 10000;tag++){
            nums[tag] = (int)(Math.random() * 10000);
        }
        System.out.println("--------------------------------------------------------------------------------------");
        SelectSort b = new SelectSort();
        long start = System.currentTimeMillis();
        b.sortBySelect(nums, nums.length);
        long end = System.currentTimeMillis();
        System.out.println("运行时间："+(end - start)+"毫秒");
        for (int x : nums) {
            System.out.print(x+"-");
        }
    }
}
