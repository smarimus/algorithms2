package heap;

import java.util.ArrayList;
import java.util.List;

public class PQueue {
	
	static List<Integer> queue = new ArrayList<Integer>();

	// left child 2*k
	// right child 2*k+1
	
	// left parent
	// right parent
	public static void main(String[] args) {
		queue.add(0, 1);
		
		System.out.println(queue.size());
	}
	
	public void add(int value){
		int size = queue.size();
		
		if(size ==1){
			queue.add(value);
			return;
		}
		
		queue.add(value);
		int parent = size/2;
		
		int child = queue.size();
		while(queue.get(parent)< queue.get(child)){
			//swap
			int temp = queue.get(parent);
			queue.add(parent, queue.get(child));
			queue.add(child, temp);
			
			child = parent;
		}
		// compare if parent is less then child
		// yes, swap and continue
	}
	
	public Integer extract(){
		int size = queue.size();
		
		int head = queue.get(1);
		queue.add(1, queue.get(size));
		
		queue.remove(size);
		
		int parent = 1;
		
		int leftChild = 2*parent;
		int rightChild = leftChild+1;
		
		while(queue.get(leftChild) > queue.get(parent) 
				&& queue.get(rightChild) > queue.get(parent)){
			
			if(queue.get(leftChild) > queue.get(parent)){
				int temp = queue.get(parent);
				queue.add(parent, queue.get(leftChild));
				queue.add(leftChild, temp);
				
				parent = leftChild;
				leftChild = 2*parent;
				rightChild = leftChild+1;
				continue;
			}else if(queue.get(rightChild) > queue.get(parent)){
				int temp = queue.get(parent);
				queue.add(parent, queue.get(rightChild));
				queue.add(rightChild, temp);
				
				parent = leftChild;
				leftChild = 2*parent;
				rightChild = leftChild+1;
				continue;
			}
		}
		return head;
		
	}
}