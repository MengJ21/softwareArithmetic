package experiment1Sort;

public class insertSort {
    public int[] sortByInsert(int[] nums) {
//        遍历数组中的每一个元素
        for (int i = 0;i < nums.length;i++) {
//            将元素插入到之前已经排号的元素中去
            for (int j = i;j > 0;j--) {
                if (nums[j] < nums[j - 1]) {
//                    只要小于就交换，直到大于为止
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[10000];
        for (int tag = 0;tag < 10000;tag++){
            nums[tag] = (int)(Math.random() * 10000);
        }
        System.out.println("--------------------------------------------------------------------------------------");
        long start = System.nanoTime();
        insertSort i = new insertSort();
        long end = System.nanoTime();
        System.out.println("运行时间："+(end - start)+"纳秒");
        int[] ints = i.sortByInsert(nums);
        for (int x : ints) {
            System.out.print(x+"-");
        }
    }
}
