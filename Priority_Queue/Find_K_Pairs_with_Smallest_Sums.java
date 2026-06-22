import java.util.*;
class Pair implements Comparable<Pair>{
    int i;
    int j;
    int sum;
    public Pair(int i, int j, int sum){
        this.i=i;
        this.j=j;
        this.sum=sum;
    }
    @Override
    public int compareTo(Pair p2){
        return this.sum-p2.sum;
    }
}
public class Main{
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int m=nums2.length;

        List<List<Integer>>result=new ArrayList<>();

        if(n==0 || m==0 || k==0){
            return result;
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(0,0,nums1[0]+nums2[0]));

        boolean[][]visited=new boolean[n][m];
        visited[0][0]=true;

        while(k-->0 && !pq.isEmpty()){
            Pair curr=pq.poll();

            int i=curr.i;
            int j=curr.j;

            result.add(Arrays.asList(nums1[i],nums2[j]));

            if(j+1<m && !visited[i][j+1]){
                pq.add(new Pair(i,j+1,nums1[i]+nums2[j+1]));
                visited[i][j+1]=true;
            }
            if(i+1<n && !visited[i+1][j]){
                pq.add(new Pair(i+1,j,nums1[i+1]+nums2[j]));
                visited[i+1][j]=true;
            }
        }
        return result;
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[]nums1={1,7,11};
		int[]nums2={2,4,6};
		int k=3;
		
		System.out.print(kSmallestPairs(nums1,nums2,k));
	}
}
