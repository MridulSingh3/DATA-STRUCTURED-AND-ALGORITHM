import java.util.*;
class Main{
    public static int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]>result=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int []current=intervals[0];
        result.add(current);

        for(int i=1;i<n;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];

            if(current[1]>=start){
                current[1]=Math.max(current[1],end);
            }
            else{
                current=intervals[i];
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        int[][]intervals={{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}