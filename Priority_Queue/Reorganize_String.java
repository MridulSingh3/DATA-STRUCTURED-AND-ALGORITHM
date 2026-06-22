import java.util.*;
class Pair implements Comparable<Pair>{
    char ele;
    int freq;

    public Pair(char ele, int freq){
        this.ele=ele;
        this.freq=freq;
    }

    @Override
    public int compareTo(Pair p2){
        if(this.freq!=p2.freq){
            return p2.freq-this.freq;
        }
        return p2.ele-this.ele; 
    }
}
public class Main{
    public static String reorganizeString(String s) {
        int n=s.length();
        int[]freq=new int[26];

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
            
            if(freq[ch-'a']>(n+1)/2){
                return "";
            }
        }

        PriorityQueue<Pair>pq=new PriorityQueue<>();

        for(char ch='a';ch<='z';ch++){
            if(freq[ch-'a']>0){
                pq.add(new Pair(ch,freq[ch-'a']));
            }
        }

        StringBuilder sb=new StringBuilder();

        while(pq.size()>=2){
            Pair p1=pq.poll();
            Pair p2=pq.poll();

            sb.append(p1.ele);
            p1.freq--;
            sb.append(p2.ele);
            p2.freq--;

            if(p1.freq>0){
                pq.add(new Pair(p1.ele,p1.freq));
            }
            if(p2.freq>0){
                pq.add(new Pair(p2.ele,p2.freq));
            }
        }
        if(!pq.isEmpty()){
            sb.append(pq.peek().ele);
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String str="aaabbbcdd";
		
		System.out.println(reorganizeString(str));
	}
}
