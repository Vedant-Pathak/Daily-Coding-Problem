package dcc;

import java.util.*;
public class PairSumK{
	  public static void main(String args[])
	    {
	      Scanner sc = new Scanner(System.in);
	      int n = sc.nextInt();
	      int[] prob = new int[n];
	      for(int i = 0; i < n; i++)
	      {
	        prob[i] = sc.nextInt();
	      }
	      Arrays.sort(prob);
	      int k = sc.nextInt();
	      int i = 0;
	      int j = prob.length - 1;
	      while(i < j)
	      {
	        int a = prob[i];
	        int b = prob[j];
	        if(a+b == k)
	          System.out.println("Found!" + a + ", " +b);
	        if(a+b < k)
	          i++;
	        else
	          j--;
	      }
	      System.out.println("nope");
	    }
	  }

