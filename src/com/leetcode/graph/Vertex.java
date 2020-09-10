package com.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
	
	private List<Vertex<T>> adjList = new ArrayList<Vertex<T>>();
	private  T value;
	
	Vertex(T value, Vertex<T> edge){
		this.value = value;
		this.adjList.add(edge);
	}

	public List<Vertex<T>> getAdjList() {
		return adjList;
	}

	public void setAdjList(List<Vertex<T>> adjList) {
		this.adjList = adjList;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	
}