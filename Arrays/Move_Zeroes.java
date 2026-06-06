import java.util.*;

class Main {
    public static int[] moveZeroes(int[] nums) {
        int n = nums.length;

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        for (int i = idx; i < n; i++) {
            nums[idx++] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 0, 3, 12 };
        System.out.println(Arrays.toString(moveZeroes(nums)));
    }
}