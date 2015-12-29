package com.algos.java.tree;
class TreeNode
{
	int data;
	TreeNode right;
	TreeNode left;

    public TreeNode()
	{
		right = null;
		left = null;
		data = 0;
	}

	public TreeNode(int d)
	{
		right = null;
		left = null;
		data = d;
	}

	TreeNode getRight()
	{
		return right;
	}
	TreeNode getLeft()
	{
		return left;
	}
	int getData()
	{
		return data;
	}
}

class TreeTraversal
{
	TreeNode root;

	public TreeTraversal()
	{
		root = new TreeNode();
	}

	TreeNode insertR(TreeNode t, int val)
	{
		if(t == null)
		{
			TreeNode n = new TreeNode(val);
			System.out.println("inserting.."+val);
			t = n;
		}
		else{
		if(t.left == null)
		{
			System.out.println("Left");
			t.left = insertR(t.left,val);
		}
		else{
			System.out.println("Right");
			t.right = insertR(t.right,val);
		}
		}

		return t;
	}

	void insert(int num)
	{
		root = insertR(root, num);
		System.out.println( root.left );	
	}

	void inorderhelper(TreeNode t)
	{
		while(t!=null){
		    System.out.println(t.data);
			inorderhelper(t.left);
			inorderhelper(t.right);
		}

	}
	void inorder()
	{
		//System.out.println(temp.data);
		inorderhelper(root);
	}
}

public class BinaryTree
{
	public static void main(String[] args)
	{
		TreeTraversal tree = new TreeTraversal();
		tree.insert(1);
		//tree.insert(5);
		//tree.insert(2);
		//tree.insert(7);
		//tree.insert(4);
		tree.inorder();
	}
}