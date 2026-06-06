import java.util.*;

class Main {
    public static void reverse(int[] nums, int i, int j) {
        if (i > j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        reverse(nums, i + 1, j - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] nextPermutation(int[] nums) {
        int n = nums.length;

        int gola_index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                gola_index = i;
                break;
            }
        }
        if (gola_index == -1) {
            reverse(nums, 0, n - 1);
            return nums;
        }

        int swap_index = gola_index;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[gola_index] < nums[i]) {
                swap_index = i;
                break;
            }
        }
        swap(nums, gola_index, swap_index);
        reverse(nums, gola_index + 1, n - 1);

        return nums;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }
}