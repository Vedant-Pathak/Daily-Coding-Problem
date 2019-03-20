package dcc;
import java.util.*;
public class ArrayProductFinder {
	public static void main(String ...args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ;i < n; i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(finderone(arr)));
		System.out.println(Arrays.toString(findertwo(arr)));
		System.out.println(Arrays.toString(finderthree(arr)));
		
	}
	private static int[] finderone(int[] arr)
	{
		//linear time, constant memory, division allowed
		int n = arr.length;
		int[] ans = new int[n];
		int arrprod = 1;
		for(int i = 0; i < n; i++)
		{
			arrprod *= arr[i];
		}
		for(int i = 0; i < n; i++)
		{
			ans[i] = arrprod/arr[i];
		}
		return ans;
	}
	private static int[] findertwo(int[] arr)
	{
		//quadratic time, constant memory, no division allowed
		int n = arr.length;
		int[] ans = new int[n];
		for(int i = 0; i < n; i++)
		{
			ans[i] = 1;
			for(int j = 0; j < n; j++)
			{
				if(i == j)
					continue;
				ans[i] *= arr[j];
			}
		}
		return ans;
	}
	private static int[] finderthree(int[] arr)
	{
		//optimization of the quadratic solution using precomputation
		//linear time, linear memory solution, no division allowed
		int n =arr.length;
		int[] ans = new int[n];
		HashMap<Integer,Integer> ltree = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> rtree = new HashMap<Integer,Integer>();
		int lprod = 1;
		int rprod = 1;
		for(int i = 0; i < n - 1; i++)
		{
			lprod *= arr[i];
			ltree.put(i, lprod);
		}
		for(int i = n-1; i > 0; i--)
		{
			rprod *= arr[i];
			rtree.put(i, rprod);
		}
		for(int i = 0;i < n; i++)
		{
			int lneighbour = i - 1;
			int rneighbour = i + 1;
			int leftp = 1;
			int rightp = 1;
			if(lneighbour > 0)
				leftp = ltree.get(lneighbour);
			if(rneighbour < n)
				rightp = rtree.get(rneighbour);
			ans[i] = leftp*rightp;
		}
		return ans;
	}
}
