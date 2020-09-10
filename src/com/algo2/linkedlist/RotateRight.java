package com.algo2.linkedlist;

public class RotateRight {

	public static void main(String[] args) {
		
		//ListNode head = LinkedList.getList();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = null;
		
		System.out.println(getCount(head));
		
		LinkedList.printListNode(rotateRight1(head, 1));

	}
	
	public static ListNode rotateRight1(ListNode head, int k) {
		
		ListNode kthNode = head;
		ListNode p2 = head;
		ListNode last, newHead;
		last = newHead = new ListNode(0);
		
		int length = getCount(head);
		if(head == null || length ==1) return head;
		if(k==0)
			return head;
		
        if(k > length){
            k= k%length;
        }
		
		while(k >= 0 && p2 != null){
			p2 = p2.next; k--;
		}
		
		while(kthNode!= null && p2 != null){
			last = p2;
			kthNode=kthNode.next;
			p2=p2.next;
		}
		
		newHead = kthNode.next;
		last.next = head;
		kthNode.next = null;
		
		return newHead;
	}
	
	public static int getCount(ListNode head){
		int count=0;
		while(head!=null){
			head = head.next;
			count++;
		}
		return count;
	}
	
	
	public static ListNode rotateRight(ListNode head, int k) {

		ListNode kthNode = head;
		ListNode newHead = null;
		ListNode kthLast = null;
		ListNode last = null;

		while (k-- > 1 && kthNode != null) {
			kthNode = kthNode.next;
		}
		
		newHead = kthNode.next;
		kthLast = kthNode;
		//find last node
		while (kthNode != null) {
			ListNode temp = kthNode;
			kthNode = kthNode.next;
			if (kthNode == null) {
				last = temp;
			}
		}

		if(last != null){
			last.next = head;
			kthLast.next = null;
		}

		return newHead;
	}
}
