package dcc;
import java.util.*;
public class Decode_String {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(numWays(str));
	}

	private static int numWays(String str) {
		//Simple DP approach - numWays(n) = numWays(n-1) + numWays(n-2), assuming those exist 
		//corner cases
		//Key Assumption - you can remove non-compliant subtrings
		//Eg. 110 can be decoded after removing 0
		if(str.length() == 0)
				return 0;
		int n = str.length();
		int[] dp = new int[str.length()];
		char first = str.charAt(0);
		if(isValid((int)(first - '0')))
			dp[0] = 1;
		if(n == 1)
			return dp[0];
		if(isValid(Integer.parseInt(str.substring(0, 2))))
			dp[1] = dp[0] + 1;
		else
			dp[1] = dp[0];
		if(n == 2)
			return dp[1];
		for(int i = 2; i < n; i++)
		{
			if(isValid((int)(str.charAt(i) - '0')))
				dp[i] += dp[i-1];
			if(isValid(Integer.parseInt(str.substring(i - 1, i + 1))))
				dp[i] += dp[i-2];
		}
		return dp[n-1];
		
	}
	private static boolean isValid(int a)
	{
		if(a >= 1 && a <= 26)
			return true;
		return false;
	}

}
