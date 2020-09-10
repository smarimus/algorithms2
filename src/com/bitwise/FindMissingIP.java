package com.bitwise;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class FindMissingIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> ip = new ArrayList<Integer>();
		//ip.add(0.0.0.0);
		//System.out.println(16<<1);
		//System.out.println(16>>1);
		//System.out.println(1<<16);
		
		//System.out.println(1000000000>>>16);
		
		List<Integer> sequence = new ArrayList<Integer>();
		sequence.add(0);
		sequence.add(1);
		sequence.add(2);
		sequence.add(3);
		sequence.add(4);
		sequence.add(5);
		sequence.add(6);
		sequence.add(7);
		sequence.add(8);
		sequence.add(9);
		sequence.add(10);
		sequence.add(2147483647);
		
		System.out.println(findMissingElement(sequence));

	}

	private static final int NUM_BUCKET = 1<<16;

	public static int findMissingElement(Iterable <Integer> sequence) {
		int[] counter = new int[NUM_BUCKET];
		Iterator<Integer> s = sequence.iterator();
		while (s.hasNext()){
			int idx = s.next() >>> 16;
			++counter[idx];
		}
		for (int i = 0; i < counter.length; ++i) {
			// Look for a bucket that contains less than NUN_BUCKET elements.
			if (counter[i] < NUM_BUCKET) {
				BitSet bitVec = new BitSet(NUM_BUCKET);
				s = sequence.iterator(); // Search from the beginning again.
				while (s.hasNext()) {
					int x = s.next();
					int rx = x >>> 16;
					if (i == (rx)) {
						int val = ((NUM_BUCKET)-1) & x;
						System.out.println("rx : " +  rx +"  " +"val : " + val);
						bitVec.set(val); // Gets the lower 16 bits of x.
					}
				}
				for (int j = 0; j < (1 << 16); ++j){
					if (!bitVec.get(j)){
						return (i << 16) | j ;
					}
				}
			}
		}
		return -1;
	}
}