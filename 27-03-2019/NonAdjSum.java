package dcc;
import java.util.*;
public class NonAdjSum {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i =0 ; i < n; i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println(linmem(arr));
	}
	private static int linmem(int[] arr)
	{
		//the approach uses dp. for every n, maxUpto[n] depends on maxUpto[n-2] and maxUpto[n-3]. 
		//all further maxUpto values would already have been considered by previous solutions
		int n = arr.length;
		int[] maxUpto = new int[n];
		maxUpto[0] = arr[0];
		maxUpto[1] = arr[1];
		for(int i = 2; i < n; i++)
		{
			int prevmax = maxUpto[i-2];
			if(i-3 >= 0)
				prevmax = Math.max(prevmax, maxUpto[i-3]);
			int curr = arr[i];
			int sum = prevmax + curr;
			maxUpto[i]=  Math.max(prevmax, Math.max(curr, sum));
		}
		return Math.max(maxUpto[n-1], maxUpto[n-2]);
	}
}
