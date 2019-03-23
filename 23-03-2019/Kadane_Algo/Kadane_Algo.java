import java.util.*;
import java.lang.*;
import java.io.*;

class Kadane_Algo {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-->0)
	    {
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        for(int i = 0; i < n; i++)
	        {
	            arr[i] = sc.nextInt();
	        }
	        System.out.println(maxSum(arr));
	    }//code
	}
	private static long maxSum(int[] arr)
	{
	    int n = arr.length;
	    int max_upto_i[] = new int[n];
	    max_upto_i[0] = arr[0];
	    int maxsum = arr[0];
	    for(int i = 1; i < n; i++)
	    {
	        if(max_upto_i[i-1] < 0)
	            max_upto_i[i] = arr[i];
            else
                max_upto_i[i] = max_upto_i[i - 1] + arr[i];
            if(maxsum < max_upto_i[i])
                maxsum = max_upto_i[i];    
	    }
	    return maxsum;
	}
}
