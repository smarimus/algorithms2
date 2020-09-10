package com.algo2.tree;

import java.util.Arrays;
import java.util.List;

public class SerializeAndDeserialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		SerializeAndDeserialize s = new SerializeAndDeserialize();
		TreeNode tn = s.Inorderdeserialize(s.InorderSerialize(root));
		System.out.println("");
		s.print(tn);
	}
	
	// Encodes a tree to a single string.
    public String InorderSerialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        InorderSerialize(root, sb);
		System.out.println(sb.toString());
		return sb.toString();
    }
    
    public void InorderSerialize(TreeNode node, StringBuffer sb){
		if(node == null)
			return;
		
		sb.append(node.val);
		sb.append(",");
		InorderSerialize(node.left, sb);
		InorderSerialize(node.right, sb);
	}

    // Decodes your encoded data to tree.
    public TreeNode Inorderdeserialize(String data) {
        String[] list = data.split(",");
		List ls = Arrays.asList(list);
		return InorderDeserialize(ls, 0, ls.size()-1);
    }
    
    public TreeNode InorderDeserialize(List list, int left, int right){
		if(left > right){
			return null;
		}
		int mid = (left+right) / 2;
		int val = Integer.parseInt((String)list.get(mid));
		TreeNode node = new TreeNode(val);
		
		node.left = InorderDeserialize(list, left, mid-1);
		node.right = InorderDeserialize(list, mid+1, right);
		
		return node;
	}
    
    public void print(TreeNode n){
    	if(n==null)
    		return;
    	
    	System.out.print(n.val + ",");
    	print(n.left);
    	print(n.right);
    }
    
    public static class TreeNode {
    	 int val;
    	 TreeNode left;
    	 TreeNode right;
    	 TreeNode(int x) { val = x; }
    }
}