package com.algo2.array;

import java.util.Arrays;
import java.util.List;

public class DeleteDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer arr[] = {2,3,5,5,7,11,11,11,13};
		List<Integer> a = Arrays.asList(arr);
		System.out.println(deleteDuplicates(a));

	}

	// .Returns the number of valid entries after deletion.
	public static int deleteDuplicates(List<Integer> A) {
		if (A.isEmpty()) {
			return 0;
		}
		int writelndex = 1;
		for (int i = 1; i < A.size(); ++i) {
			if (!A.get(writelndex - 1).equals(A.get(i))) {
				A.set(writelndex++, A.get(i));
			}
			System.out.println(A + " writelndex:" + writelndex + " i:" + i);
		}
		return writelndex;
	}
	
	/*
	 * [2, 3, 5, 5, 7, 11, 11, 11, 13]
		[2, 3, 5, 7, 11, 11, 11, 11, 13]
		[2, 3, 5, 7, 11, 13, 11, 11, 13]
	 */

}
