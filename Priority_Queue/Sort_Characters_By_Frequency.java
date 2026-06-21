import java.util.*;
class Main{
    static class Pair implements Comparable<Pair>{
        char ch;
        int freq;

        public Pair(char ch, int freq){
            this.ch=ch;
            this.freq=freq;
        }
        public int compareTo(Pair p2){
            return p2.freq-this.freq;
        }
    }
    public static String frequencySort(String s) {
        int n=s.length();
        Map<Character,Integer>map=new HashMap<>();

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>();

        for(char ch:map.keySet()){
            pq.add(new Pair(ch,map.get(ch)));
        }
        
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            while(curr.freq-->0){
                sb.append(curr.ch);
            }
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		String s="tree";
		System.out.print(frequencySort(s));
	}
}
