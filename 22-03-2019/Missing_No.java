package dcc;
import java.util.*;
public class Missing_No {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i =0 ;i < n; i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println(numFind(arr));
		System.out.println(Arrays.toString(arr));
	}
	private static int numFind(int[] arr)
	{
		int n = arr.length;
		int ans = n + 1;  //in case all numbers are in the array
		for(int i = 0 ; i < n; i++)
		{
			int val = arr[i];
			int nextval = 0;
			
			if(val <= 0 || val >= n) //values we don't care about
				continue;
			while(arr[val - 1] != val)   //the naive approach would be to create a new 
			{                            //array and put elements of value i at i -1 position and then iterate to find missing element 
				nextval = arr[val - 1];  //this approach does that in place by putting some additional constraints
				arr[val - 1] = val;
				val = nextval;
				if(val <= 0 || val >= n)
					break;
			}
		}
		for(int i = 0; i < n; i++)
		{
			if(arr[i] != i + 1)
				return i + 1;
		}
		//System.out.println(ans);
		return ans;
	}

}
