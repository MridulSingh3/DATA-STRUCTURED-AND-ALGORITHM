import java.util.*;

public class Main {
    //Brute Force
    public static int[] twoSumBrute(int[] nums, int target) {
        int n=nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }

    //Optimized
    public static int[] twoSumOptimized(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int[]arr={2,7,11,15};
        int target=9;

        System.out.println(Arrays.toString(twoSumBrute(arr,target)));
        System.out.println(Arrays.toString(twoSumOptimized(arr,target)));
    }
}
