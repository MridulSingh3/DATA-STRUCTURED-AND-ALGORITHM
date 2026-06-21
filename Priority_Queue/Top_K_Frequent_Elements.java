import java.util.*;
public class Main{
    static class Pair implements Comparable<Pair>{
        int element;
        int freq;

        public Pair(int element, int freq){
            this.element=element;
            this.freq=freq;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.freq-this.freq;
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>();

        for(int key:map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }

        int[]result=new int[k];
        int idx=0;
        while(k-->0){
            Pair curr=pq.remove();
            result[idx++]=curr.element;
        }
        return result;
    }
	public static void main(String[] args) {
		int[]arr={1,2,1,2,1,2,3,1,3,2};
		int k = 2;
		
		System.out.print(Arrays.toString(topKFrequent(arr,k)));
	}
}
