import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i = 0; i < n; i++)
		    {
		        arr[i] = sc.nextInt();
		    }
		    ArrayList<Integer> ans = windowMax(arr,k);
		    for(int i: ans)
		        System.out.print(i + " ");
	        System.out.println();
		}//code
	}
	private static ArrayList<Integer> windowMax(int[] arr,final int k)
	{
	    int n = arr.length;
	    ArrayList<Integer> ans = new ArrayList<Integer>();
	    Deque<Integer> q = new LinkedList<Integer>();
	    for(int i = 0; i < k; i++)
	    {
	        while(!q.isEmpty() && arr[i] >=arr[q.peekLast()])
	            q.pollLast();
            q.offerLast(i);
	    }
	    for(int i = k; i < n; i++)
	    {
	        
	        ans.add(arr[q.peekFirst()]);
	        while(!q.isEmpty() && q.peekFirst() <= i-k)
	            q.poll();
            while(!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.pollLast();
            q.offerLast(i);
	    }
	    ans.add(arr[q.peekFirst()]);
	    return ans;
	}
}
