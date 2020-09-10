package com.algo2.string;

import java.util.Stack;

public class PrefixTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tries root = new Tries();
		Tries tries = buildPrefixTree("sudhakar", root);
		buildPrefixTree("kar", tries);
		buildPrefixTree("karthick", tries);
		printPrefixTree(tries);
	}
	
	public static Tries buildPrefixTree(String s, Tries root){
		
		char[] chars = s.toCharArray();
		Tries tempRoot = root;
		for (int i = 0; i < chars.length; i++) {
			int index = chars[i] - 'a';
			
			if(root.node[index] !=  null){
				root = root.node[index];
			}else{
				Tries newTrie = new Tries();
				root.node[index] = newTrie;
				root = newTrie;
			}
		}
		root.isWord = true;
		root = tempRoot;
		
		return tempRoot;
	}
	
	public static void printPrefixTree(Tries tries){
		
		Stack s = new Stack();
		
		s.push(tries);
		while(!s.isEmpty()){
			Tries top = (Tries)s.pop();
			for (int i = 0; i < top.node.length; i++) {
				
				if(top.node[i] != null){
					char c=(char)(i+'a');
					System.out.println(c);
					s.push(top.node[i]);
				}
			}	
		}
	}
	
	static class Tries{
		Tries node[] = new Tries[26];
		boolean isWord = false;
	}

}
