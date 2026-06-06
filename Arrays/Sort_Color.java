import java.util.*;

class Main {
    public static int[] sortColors(int[] nums) {
        int n = nums.length;

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
        }
        int[] freq = new int[max + 1];

        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        int idx = 0;
        for (int i = 0; i <= max; i++) {
            while (freq[i] > 0) {
                nums[idx++] = i;
                freq[i]--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 0, 3, 12 };
        System.out.println(Arrays.toString(sortColors(nums)));
    }
}