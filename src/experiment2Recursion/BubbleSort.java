package experiment2Recursion;

public class BubbleSort {
    public void sortByBubble(int[] nums, int len) {
        if (len == 1) {
            return;
        }
        // 每次冒泡求最大值
        max(nums, len - 1);
//        依次递归n个元素
        sortByBubble(nums, len - 1);
    }
    public void max(int[] nums, int end) {
        // 求最大值
        for (int i = 0;i < end;i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[10000];
        for (int tag = 0;tag < 10000;tag++){
            nums[tag] = (int)(Math.random() * 10000);
        }
        System.out.println("--------------------------------------------------------------------------------------");
        BubbleSort b = new BubbleSort();
        long start = System.currentTimeMillis();
        b.sortByBubble(nums, nums.length);
        long end = System.currentTimeMillis();
        System.out.println("运行时间："+(end - start)+"毫秒");
        for (int x : nums) {
            System.out.print(x+"-");
        }
    }
}
