import java.util.*;

public class Main {
    // Brute Force
    public static int removeDuplicatesBrute(int[] nums) {
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!arr.contains(nums[i])) {
                arr.add(nums[i]);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            nums[i] = arr.get(i);
        }
        return arr.size();
    }

    // Optimized
    public static int removeDuplicatesOptimized(int[] nums) {
        int n = nums.length;

        int k = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr1 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int[] arr2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

        System.out.println(removeDuplicatesBrute(arr1));
        System.out.println(removeDuplicatesOptimized(arr2));
    }
}