package experiment1Sort;

public class SelectSort {
    public void sortBySelect(int[] nums) {
        int len = nums.length;
        // 遍历每一个元素，从第一个开始，每次选出一个最小的。
        for (int i = 0;i < len - 1;i++) {
            // 记录最小元素的下标。
            int tag = i;
            //　选出从i开始到最后的最小的元素。
            for (int j = i + 1;j < len;j++) {
                if (nums[tag] > nums[j]) {
                    tag = j;
                }
            }
            // 交换最小的那个元素和下标为i的元素。
            int temp = nums[i];
            nums[i] = nums[tag];
            nums[tag] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[10000];
        for (int tag = 0;tag < 10000;tag++){
            nums[tag] = (int)(Math.random() * 10000);
        }
        System.out.println("--------------------------------------------------------------------------------------");
        SelectSort sor = new SelectSort();
        long start = System.nanoTime();
        sor.sortBySelect(nums);
        long end = System.nanoTime();
        System.out.println("运行时间："+(end - start)+"纳秒");
        for (int x : nums) {
            System.out.print(x+"-");
        }
    }
}
