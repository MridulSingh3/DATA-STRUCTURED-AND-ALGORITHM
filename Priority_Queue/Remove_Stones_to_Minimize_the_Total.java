import java.util.*;
class Main{
    public static int minStoneSum(int[] piles, int k) {
        int n=piles.length;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);

        for(int i=0;i<n;i++){
            pq.add(piles[i]);
        }
        while(k-->0){
            int curr=pq.poll();
            int currPile=(int)Math.floor(curr/2);
            int newPile=curr-currPile;
            pq.add(newPile);
        }
        int sum=0;

        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
    }
	public static void main(String[] args) {
		int[]piles={4,3,6,7};
		int k=3;
		
		System.out.print(minStoneSum(piles,k));
	}
}
