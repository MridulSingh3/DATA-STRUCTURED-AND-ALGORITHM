import java.util.*;

public class Main {
    // Brute Force
    public static int[] productExceptSelfBrute(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            int mul = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    mul = mul * nums[j];
                }
            }
            temp[i] = mul;
        }
        return temp;
    }

    // Optimized
    public static int[] productExceptSelfOptimized(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };

        System.out.println(Arrays.toString(productExceptSelfBrute(arr)));
        System.out.println(Arrays.toString(productExceptSelfOptimized(arr)));
    }
}