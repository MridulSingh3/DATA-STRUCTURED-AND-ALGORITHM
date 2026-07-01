import java.util.*;
public class Main{
    public static void solve(int n, int[]arr, int target, int sum, int i, List<Integer>list, List<List<Integer>>result){
        if(sum==0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(sum<0 || i==n){
            return;
        }
        list.add(arr[i]);
        solve(n,arr,target,sum-arr[i],i+1,list,result);
        list.remove(list.size()-1);
        int j=i+1;
        while(j<n && arr[j]==arr[i]){
            j++;
        }
        solve(n,arr,target,sum,j,list,result);
    }
	public static void main(String[] args) {
		int[]arr={10, 1, 2, 7, 6, 1, 5};
		int k = 8;
		Arrays.sort(arr);
		List<List<Integer>>result=new ArrayList<>();
		solve(arr.length,arr,k,k,0,new ArrayList<>(),result);
		System.out.print(result);
	}
}
