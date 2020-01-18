package medium;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal_545 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root= new TreeNode(1);
		root.left = new TreeNode(2);
		root.right =new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(8);
		root.right.left =new TreeNode(6);
		root.right.left.left =new TreeNode(9);
		root.right.left.right =new TreeNode(10);
		List<Integer> res = boundaryOfBinaryTree(root);
		for(int i=0; i<res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

	public static List<Integer> boundaryOfBinaryTree(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		res.add(root.val);
		leftSubtree(root.left, res);
		leaves(root.left, res);
		leaves(root.right, res);
		rightSubtree(root.right, res);
		return res;
	}
	//leftSubtree
	public static void leftSubtree(TreeNode root, List<Integer> res) {
		if(root==null || root.left==null && root.right==null)
			return;
		res.add(root.val);
		if(root.left !=null)
			leftSubtree(root.left, res);
		else //if(root.right!=null)
			leftSubtree(root.right, res);
	}
	
	//rightSubtree
	public static void rightSubtree(TreeNode root, List<Integer> res) {
		if(root==null || root.left==null && root.right==null)
			return;
		if(root.right!=null)
			rightSubtree(root.right, res);
		else //if( root.left!=null)
			rightSubtree(root.left, res);
		res.add(root.val);
	}

	//leaves
	public static void leaves(TreeNode root, List<Integer> res) {
		if(root==null)
			return;
		if(root.left==null && root.right==null)
			res.add(root.val);
		leaves(root.left, res);
		leaves(root.right, res);
	}

}
