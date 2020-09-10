package com.algo2.array;

import java.util.ArrayList;
import java.util.List;

public class IncrementPrecisionInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> i = new ArrayList<Integer>();
		i.add(9);
		i.add(9);
		plusOne(i);
		i.stream().forEach(v -> System.out.print(v));
		System.out.println();
		
		List<Integer> j = new ArrayList<Integer>();
		j.add(1);
		j.add(0);
		j.add(0);
		plusOne(j);
		j.stream().forEach(v -> System.out.print(v));
		System.out.println();
		
		List<Integer> k = new ArrayList<Integer>();
		k.add(8);
		k.add(8);
		k.add(0);
		plusOne(k);
		k.stream().forEach(v -> System.out.print(v));
	}
	
	public static List<Integer> plusOne (List<Integer> A) {
		int n = A.size() - 1;
		A.set(n, A.get(n) + 1);
		
		for (int i = n; i > 0 && A.get(i) == 10; --i) {
			A.set(i, 0);
			A.set(i - 1, A.get(i - 1) + 1);
		}
		
		if (A.get(0) == 10) {
			//Need additional digit as the most significant digit (i.e A.get(9)) // has a carry-out .
			A.set(0, 0);
			A.add(0, 1);
		}
		return A;
	}
}