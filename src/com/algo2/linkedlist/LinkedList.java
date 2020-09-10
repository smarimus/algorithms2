package com.algo2.linkedlist;

public class LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printListNode(getList());
	}
	
	public static ListNode getList(){
		ListNode head = new ListNode(1);
		
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		//ListNode six = new ListNode(6);
		
		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = null;
		//six.next = null;
		
		return head;
	}
	
	public static void printListNode(ListNode head){
		
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
}

