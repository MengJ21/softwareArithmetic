package experiment1Sort;

public class BubbleSort {
    public void sortByBubble(int[] nums) {
        int len = nums.length;
        // 第一层循环，遍历每一个元素。每次选出一个最大的
        for (int i = len - 1;i > 0;i--) {
            // 设置标志位，如果没有交换的话，说明大小已经排号，就是true，就可以省去很多次循环，节省了时间。
            boolean tag = true;
            // 寻找0到i的最大元素。
            for (int j = 0;j < i;j++) {
                if (nums[j] > nums[j + 1]){
                    // 交换元素。
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    tag = false;
                }
            }
            if (tag) {
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
        long start = System.nanoTime();
        BubbleSort b = new BubbleSort();
        long end = System.nanoTime();
        System.out.println("运行时间："+(end - start)+"纳秒");
        b.sortByBubble(nums);
        for (int x : nums) {
            System.out.print(x+"-");
        }
    }
}
