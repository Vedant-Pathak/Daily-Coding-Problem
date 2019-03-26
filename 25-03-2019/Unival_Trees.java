//package dcc;
import treelib.*;
import java.util.*;
public class Unival_Trees {
	static class doublet{
		int count;
		boolean isUni;
		doublet(int count, boolean a)
		{
			this.count = count;
			this.isUni = a;
		}
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Node root = Utilities.deserialize(sc.nextLine());
		System.out.println(unival(root).count);
	}
	private static doublet unival(Node node)
	{
		if(node == null)
			return new doublet(0,true);
		doublet ltree = unival(node.left);
		doublet rtree = unival(node.right);
		//boolean curr = false;
		if((node.left != null && node.val != node.left.val) || (node.right != null && node.val != node.right.val))
		{
			return new doublet(ltree.count + rtree.count, false);
		}
		if(ltree.isUni && rtree.isUni)
			return new doublet(ltree.count + rtree.count + 1,true);
		return new doublet(ltree.count + rtree.count, false);	
	}
}
