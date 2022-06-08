package com.general;

import java.util.NoSuchElementException;

public class Stack<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<String> s = new Stack<String>();
		
		s.push("Sudhakar");
		s.push("Shopana");
		s.push("Nilan");
		
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push("Sudhakar");
		System.out.println(s.pop());
	}
	
	Node<T> top, first = null;
	
	Node<T> current = null;
	
	public void push(T value){
		
		if(top == null) {
			top = new Node<T>(value);
		}else {
			
		}
	}
	
	public void push1(T value){
		if(top == null) {
			top = first = new Node<T>(value);
		}else {
			Node<T> temp = top;
			top.next = new Node<T>(value);
			top = top.next;
			top.pre = temp;
		}
	}
	
	public T pop(){
		if(top == null || first == null) {
			throw new NoSuchElementException();
		}
		T result = top.value;
		Node<T> pre = top.pre;
		if(pre != null) {
			pre.next = null;
			top = pre;
		}else {
			top = first = null;
		}
		return result;
	}
	
	public T peek() {
		return top.value;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}

class Node<T> {
	T value;
	Node<T> next;
	Node<T> pre;
	
	Node(T value){
		this.value = value;
	}
}