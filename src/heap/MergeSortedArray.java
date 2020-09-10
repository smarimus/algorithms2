package heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArray {
	
	private static class ArrayEntry{
		private Integer value;
		private Integer arrayId;
		
		public ArrayEntry(Integer value, Integer arrayId){
			this.value = value;
			this.arrayId = arrayId;
		}
	}

	public static void main(String[] args) {
	}

	public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
		
		PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(sortedArrays.size(),
				(a,b) -> Integer.compare(a.value, b.value) );
		
		List<Integer> results = new ArrayList<Integer>();
		
		List<Iterator<Integer>> iter = new ArrayList<>(sortedArrays.size());
		for (List<Integer> sortedArray : sortedArrays) {
			iter.add(sortedArray.iterator());
		}
		
		for(int i=0; i< sortedArrays.size(); i++){
			minHeap.add( new ArrayEntry(sortedArrays.get(i).get(0),i));
		}
		
		while(!minHeap.isEmpty()){
			ArrayEntry arrayEntry = minHeap.poll();
			results.add(arrayEntry.value);
			
			if(iter.get(arrayEntry.arrayId).hasNext()){
				minHeap.add(new ArrayEntry(iter.get(arrayEntry.arrayId).next(), arrayEntry.arrayId));
			}
		}
		
		return results;
	}
}