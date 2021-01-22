package com;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	  static int WHITE = 1;
	  static int GRAY = 2;
	  static int BLACK = 3;

	  boolean isPossible;
	  Map<Integer, Integer> color;
	  Map<Integer, List<Integer>> adjList;
	  List<Integer> topologicalOrder;

	  private void init(int numCourses) {
	    this.isPossible = true;
	    this.color = new HashMap<Integer, Integer>();
	    this.adjList = new HashMap<Integer, List<Integer>>();
	    this.topologicalOrder = new ArrayList<Integer>();

	    // By default all vertces are WHITE
	    for (int i = 0; i < numCourses; i++) {
	      this.color.put(i, WHITE);
	    }
	  }
	  
	  private void dfs(int node) {

	    // Don't recurse further if we found a cycle already
	    if (!this.isPossible) {
	      return;
	    }

	    // Start the recursion
	    this.color.put(node, GRAY);

	    // Traverse on neighboring vertices
	    for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
	      if (this.color.get(neighbor) == WHITE) {
	        this.dfs(neighbor);
	      } else if (this.color.get(neighbor) == GRAY) {
	        // An edge to a GRAY vertex represents a cycle
	        this.isPossible = false;
	      }
	    }

	    // Recursion ends. We mark it as black
	    this.color.put(node, BLACK);
	    this.topologicalOrder.add(node);
	  }

	  public int[] findOrder(int numCourses, int[][] prerequisites) {

	    this.init(numCourses);

	    // Create the adjacency list representation of the graph
	    for (int i = 0; i < prerequisites.length; i++) {
	      int dest = prerequisites[i][0];
	      int src = prerequisites[i][1];
	      List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
	      lst.add(dest);
	      adjList.put(src, lst);
	    }

	    // If the node is unprocessed, then call dfs on it.
	    for (int i = 0; i < numCourses; i++) {
	      if (this.color.get(i) == WHITE) {
	        this.dfs(i);
	      }
	    }

	    int[] order;
	    if (this.isPossible) {
	      order = new int[numCourses];
	      for (int i = 0; i < numCourses; i++) {
	        order[i] = this.topologicalOrder.get(numCourses - i - 1);
	      }
	    } else {
	      order = new int[0];
	    }

	    return order;
	  }
	}


/*
 * input: slotsA = [[10, 50], [60, 120], [140, 210]] slotsB = [[0, 15], [60,
 * 70]] dur = 8
 * 
 * output: [60, 68]
 * 
 * input: slotsA = [[10, 50], [60, 120], [140, 210]] slotsB = [[0, 15], [60,
 * 70]] dur = 12
 * 
 * 
 * [0,5], [10, 30] [10, 20]
 * 
 * 0------5 10---------------------30 10-------------20 5 18
 * |---------------------------------------|
 * |---------------------------------------| 7 20
 * 
 * [7,18] [7,15] a = {5 , 15} b = {7 , 15} dur = 8
 * 
 * [7, 15]
 * 
 * a = {5 , 14} b = {7 , 15}
 * 
 * dur = 3 7,10
 * 
 * find common interval take bigger start + dur <= common interval
 * 
 * bigger start, bigger start + dur
 * 
 * output: []
 */