//package treelib;

public class Node {
	public Node left;
	public Node right;
	public char val;
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public char getVal() {
		return val;
	}
	public void setVal(char val) {
		this.val = val;
	}
	public Node(char val)
	{
		this.val=val;
		left=right=null;
	}
}
