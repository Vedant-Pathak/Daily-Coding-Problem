package treelib;
import java.util.*;
public class Utilities {
	public static Node deserialize(String str)
	{
		int[] pointer = new int[1];
		pointer[0] = 0;
		return serialHelper(str,pointer);
	}
	private static Node serialHelper(String str, int[] pointer)
	{
		//System.out.println(str.charAt(curr));
		if(str.charAt(pointer[0]) == '#')
		{
			pointer[0]++;
			return null;
		}
		Node root = new Node(str.charAt(pointer[0]));
		pointer[0]++;
		root.left = serialHelper(str,pointer);
		root.right= serialHelper(str,pointer);
		return root;
	}
	private static void preorder(Node root)
	{
		if(root == null)
			return;
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		preorder(deserialize(str));
	}
}
