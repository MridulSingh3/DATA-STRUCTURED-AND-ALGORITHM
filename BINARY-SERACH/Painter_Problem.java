import java.util.*;

class Main {
    public static boolean isPossible(int[] arr, int n, int m, int maxAllocatedTime) {
        int painter = 1, time = 0;

        for (int i = 0; i < n; i++) {
            if (time + arr[i] <= maxAllocatedTime) {
                time += arr[i];
            } else {
                painter++;
                time = arr[i];
            }
        }
        return painter <= m;
    }

    public static int minimumPainter(int[] arr, int n, int m) {
        int sum = 0, max_Val = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max_Val = Math.max(max_Val, arr[i]);
        }
        int st = max_Val, end = sum;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (isPossible(arr, n, m, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 40, 30, 10, 20 };
        int n = 4, m = 2;
        System.out.println(minimumPainter(arr, n, m));
    }
}