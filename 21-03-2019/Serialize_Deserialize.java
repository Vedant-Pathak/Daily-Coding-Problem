package dcc;
import java.util.*;
public class Serialize_Deserialize {
	static class Node{
		char val;
		Node left;
		Node right;
		Node(char val)
		{
			this.val = val;
			left = right = null;
		}
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String tree = sc.next();
		Node root = deserialize(tree);
		preorder(root);
		StringBuilder str = new StringBuilder();
		serialize(root,str);
		System.out.println(str.toString());
	}
	private static void serialize(Node node, StringBuilder str)
	{
		if(node == null)
		{
			str.append('.');
			return;
		}
		str.append(node.val);
		str.append('(');
		serialize(node.left,str);
		serialize(node.right,str);
		str.append(')');
	}
	private static Node deserialize(String str)
	{
		HashMap<Character,Node> map = new HashMap<Character,Node>(); //Stores Nodes of characters already found
		Stack<Character> s = new Stack<Character>(); //iterating through the string
		int index = 0;
		while(index < str.length())
		{
			if(str.charAt(index) != ')')
				s.push(str.charAt(index++));
			else
			{
				char rt = s.pop();
				char lt = s.pop();
				s.pop();
				Node par = new Node(s.peek());
				if(rt == '.')
					par.right = null;
				else
					par.right = map.get(rt);
				if(lt == '.')
					par.left = null;
				else
					par.left = map.get(lt);
				map.put(par.val, par);
				index++;
			}
		}
		Node root = map.get(s.peek()); //only the root hasn't been popped from the stack yet
		return root;
	}
	private static void preorder(Node node)
	{
		if(node == null)
			return;
		System.out.println(node.val);
		preorder(node.left);
		preorder(node.right);
	}
	
}
