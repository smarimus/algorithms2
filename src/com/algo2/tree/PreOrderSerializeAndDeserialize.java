package com.algo2.tree;

import java.util.Arrays;
import java.util.List;

public class PreOrderSerializeAndDeserialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		PreOrderSerializeAndDeserialize s = new PreOrderSerializeAndDeserialize();
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
		if(node == null){
			sb.append("#");
			sb.append(",");
			return;
		}
		
		sb.append(node.val);
		sb.append(",");
		InorderSerialize(node.left, sb);
		InorderSerialize(node.right, sb);
	}

    // Decodes your encoded data to tree.
    public TreeNode Inorderdeserialize(String data) {
        String[] list = data.split(",");
		List ls = Arrays.asList(list);
		return InorderDeserialize(ls);
    }
    
    int index=0;
    public TreeNode InorderDeserialize(List list){
		if("#".equals((String)list.get(index))){
			index++;
			return null; 
		}
		
		int val = Integer.parseInt((String)list.get(index));
		TreeNode node = new TreeNode(val);
		
		index++;
		node.left = InorderDeserialize(list);
		node.right = InorderDeserialize(list);
		
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