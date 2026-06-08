import java.util.*;

public class Main{
    //Recursion
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    
    //Memoization
    public static int fibonacciMemo(int n, int[]dpMemo){
        if(n==0 || n==1){
            return n;
        }
        if(dpMemo[n]!=-1){
            return dpMemo[n];
        }
        dpMemo[n]=fibonacciMemo(n-2,dpMemo)+fibonacciMemo(n-1,dpMemo);
        return dpMemo[n];
    }
    
    //Tabulation
    public static int fibonacciTab(int n){
        if(n==0 || n==1){
            return n;
        }
        int[]dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
    
    //Optimized
    public static int fib(int n) {
        if(n==0 || n==1){
            return n;
        }
        int a=0, b=1, temp=0;

        for(int i=2;i<=n;i++){
            temp=a+b;
            a=b;
            b=temp;
        }
        return temp;
    }
	public static void main(String[] args) {
		int n=5;
		System.out.println(fibonacci(n));
		
		int[]dpMemo=new int[n+1];
        Arrays.fill(dpMemo,-1);
        System.out.println(fibonacciMemo(n,dpMemo));
        
        System.out.println(fibonacciTab(n));
        
        System.out.println(fib(n));
	}
}
