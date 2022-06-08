package com.algo2.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatAndRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getFirstNonRepeatAndRepeat("akkasam");
		System.out.println();
		getFirstNonRepeatAndRepeat("javaconceptoftheday");
		
		int[] arr = {20,10,3,11};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));;
	}
	public static void getFirstNonRepeatAndRepeat(String text) {
		char[] charArr = text.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		boolean foundRepeat = false;

		// find first repeating char
		for (int i = 0; i < charArr.length; i++) {
			int count = map.getOrDefault(charArr[i], 0);
			if (!foundRepeat && count == 1) {
				System.out.println(charArr[i]);
				foundRepeat = true;
			}
			map.put(charArr[i], ++count);
		}
		
		// find first non-repeating char
		for (int i = 0; i < charArr.length; i++) {
			int count = map.getOrDefault(charArr[i], 0);
			if (count == 1) {
				System.out.println(charArr[i]);
				break;
			}
		}
	}

}
