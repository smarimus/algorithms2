package com.leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public static void BFS(Vertex<Integer> sourceVertex){
		Queue<Vertex<Integer>> q = new LinkedList<Vertex<Integer>>();
		q.add(sourceVertex);
		
		Map<Integer, Vertex<Integer>> visited = new HashMap<Integer, Vertex<Integer>>();
		// parent map
		
		while(!q.isEmpty()){
			Vertex<Integer> captured = q.poll();
			
			for(Vertex<Integer> adjVertex : captured.getAdjList()){
				if(!visited.containsKey(adjVertex.getValue())){
					visited.put(adjVertex.getValue(), adjVertex);
					q.add(adjVertex);
					
					// add parent map
				}
			}
		}
	}
	
	public static void DFS(Vertex<Integer> v){
		
	}
}