import java.util.*;
import java.lang.*;
import java.io.*;

class KnapSack {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		    int n = sc.nextInt();
		    int val[] = new int[n];
		    int wt[] = new int[n];
		    int W = sc.nextInt();
		    for(int i = 0;i < n; i++)
		        val[i] = sc.nextInt();
	        for(int i = 0; i < n; i++)
	            wt[i] = sc.nextInt();
            System.out.println(maxVal(val,wt,W));
		}//code
	}
	private static int maxVal(int[] val, int[] wt, int W)
	{
	    int n = val.length;
	    int[][] dp = new int[n+1][W+1];
	    for(int i = 0; i <= W; i++)
	    {
	        dp[0][i] = 0;    //knapsack with zero items allowed has value zero
	    }
	    for(int i = 0; i<= n; i++)
	    {
	        dp[i][0] = 0;    //knapsack with zero weight allowed has value zero
	    }
	    for(int i = 1; i <= n; i++)
	    {
	        for(int j = 1; j <= W; j++)
	        {
	            dp[i][j] = dp[i-1][j];
	            if(wt[i-1] <= j)
	                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-wt[i-1]] + val[i-1]);
	        }
	    }
	    return dp[n][W];
	}
}
