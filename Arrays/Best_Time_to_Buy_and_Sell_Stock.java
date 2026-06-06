import java.util.*;

class Main {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                max = Math.max(max, price - min);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(nums));
    }
}