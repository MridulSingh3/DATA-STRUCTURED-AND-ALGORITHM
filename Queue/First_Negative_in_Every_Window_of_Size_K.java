import java.util.*;

class Main {
    public static List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;
        while (j < n) {
            if (arr[j] < 0) {
                q.add(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else {
                if (!q.isEmpty()) {
                    result.add(q.peek());
                } else if (q.isEmpty()) {
                    result.add(0);
                }

                if (!q.isEmpty() && arr[i] == q.peek()) {
                    q.poll();
                }

                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { -8, 2, 3, -6, 10 };
        int k = 2;
        System.out.println(firstNegInt(arr, k));
    }
}