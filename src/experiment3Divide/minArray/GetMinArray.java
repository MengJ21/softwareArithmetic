package experiment3Divide.minArray;

class GetMaxArray {
    public int[] getMaxArray(int[] nums, int start, int end) {
        // res是长度为2的数组，用来存放最大连续子数组的开始和结束位置。
        int[] res;
        // 子数组为1.
        if (start == end) {
            return new int[]{start, end};
        }
        int mid = (start + end) / 2;
        // 获得左侧数组的最大子数组的下标
        int[] maxArray1 = getMaxArray(nums, start, mid);
        // 获得右侧数组的最大子数组的下标
        int[] maxArray2 = getMaxArray(nums, mid + 1, end);
        // 分别求左侧和右侧的最大值。
        int maxValue1 = 0;
        int maxValue2 = 0;
        for (int i = maxArray1[0];i <= maxArray1[1];i++) {
            maxValue1 += nums[i];
        }
        for (int i = maxArray2[0];i <= maxArray2[1];i++) {
            maxValue2 += nums[i];
        }
        // 求最大值。
        int maxValue = Math.max(maxValue1,maxValue2);
        if (maxValue == maxValue1) {
            res = maxArray1;
        } else {
            res = maxArray2;
        }
        // 从mid 和 mid+ 1开始求中间部分。
        int maxValue3 = nums[mid] + nums[mid + 1];
        if (maxValue3 > maxValue) {
            res = new int[]{mid,mid + 1};
        }
        // 分别用来记录左侧和右侧的最大值
        int maxLeft = 0;
        int maxRight = 0;
        // 分别用来记录左边和右边在遍历过程中的和。
        int sumLeft = 0;
        int sumRight = 0;
        // 分别求左边和右边的最大值，注意正负。
        int s = mid - 1;
        int e = mid + 2;
        // 求左半部分最大值
        if (s >= start) {
            maxLeft = nums[s];
            sumLeft = nums[s];
            for (int i = s - 1;i >= start;i--) {
                sumLeft += nums[i];
                if (maxLeft < sumLeft) {
                    maxLeft = sumLeft;
                    s = i;
                }
            }
        }
        // 求右半部分最大值。
        if (e <= end){
            maxRight = nums[e];
            sumRight = nums[e];
            for (int i = e + 1;i <= end;i++) {
                sumRight += nums[i];
                if (maxRight < sumRight) {
                    maxRight = sumRight;
                    e = i;
                }
            }
        }
        int maxValue4;
        // 根据左右部分最大值的正负来判断是否要添加到中间两个值的和上。
        if (maxLeft > 0 && maxRight > 0) {
            maxValue4 = maxValue3 + maxLeft + maxRight;
            if (maxValue4 > maxValue) {
                res[0] = s;
                res[1] = e;
            }
        }
        if (maxLeft > 0 && maxRight <= 0) {
            maxValue4 = maxValue3 + maxLeft;
            if (maxValue4 > maxValue) {
                res[0] = s;
                res[1] = mid + 1;
            }
        }
        if (maxLeft <= 0 && maxRight > 0) {
            maxValue4 = maxValue3 + maxRight;
            if (maxValue4 > maxValue) {
                res[0] = mid;
                res[1] = e;
            }
        }
        return res;
    }
    public int[] getMaxArrayByForce(int[] nums) {
        int[] res = new int[3];
        int maxValue = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0;i < nums.length;i++) {
            sum = nums[i];
            if (sum > maxValue) {
                maxValue = sum;
                res[0] = i;
                res[1] = i;
                res[2] = maxValue;
            }
            for (int j = i + 1;j < nums.length;j++) {
                sum += nums[j];
                if (sum > maxValue) {
                    maxValue = sum;
                    res[0] = i;
                    res[1] = j;
                    res[2] = maxValue;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        GetMaxArray getMaxArray = new GetMaxArray();
        int[] nums = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int[] index = getMaxArray.getMaxArray(nums, 0, nums.length - 1);
        for (int i: index) {
            System.out.println(i);
        }
        int[] indexAndResult = getMaxArray.getMaxArrayByForce(nums);
        for (int i : indexAndResult) {
            System.out.println(i);
        }
    }
}
