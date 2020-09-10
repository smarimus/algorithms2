package com.algo2.string;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Pattern does not have to be in the order
		String fullString = "this is a test string";
		String pattern = "t stri";
		
		System.out.println(minWindow(fullString, pattern));
	}
	
	/*
	 * start with first matching character,
	 * 		loop - find the match{
	 * 				check from the map, whenever there is a match increase the counter
	 * 				and decrease the missing and continue outer loop.
	 * 				When missing becomes 0 exit the loop.
	 * 
	 * 			Loop - Slide the left, when missing is not 0, exit the loop{
	 * 				decrease from the left, until the match does not exist( maintain a counter table)
					then expand the right
					}
	 * 		}
	 * 
	 */
	public static class Result{
		private int start;
		private int end;
		private int count;
		Result(int start, int end, int count){
			this.start = start;
			this.end = end;
			this.count = count;
		}
	}
	public static int minWindow(String fullString, String pattern){
		
		Map<Character, Integer> map = new HashMap<Character, Integer>(); 
		for (int i = 0; i < pattern.length(); i++) {
			map.put(pattern.charAt(i), 0);
		}
		
		int right=0;
		int left=0;
		for (int i = 0; i < fullString.length(); i++) {
			if(map.get(i) != null){
				left=i; break;
				
			}
		}
		Result rs = new Result(0,0,0);
		
		int missing= pattern.length();
		//move the windown from right
		for (right = left; right < fullString.length(); right++) {
			Character curr = fullString.charAt(right);
			
			if(missing > 0){
				if(map.get(curr) != null){
					Integer count = map.get(right);
					if(count ==0){missing--;}
					map.put(curr,count++);
				}
				continue;
			}
			
			//update the results
			if((right-left) < rs.count){
				rs = new Result(left, right, (right-left));
			}
			
			//move the window from left
			while(missing == 0){
				Character leftChar = fullString.charAt(left);
				
				Integer val = map.get(leftChar); 
				if(val != null){
					if(val == 1){
						missing++;
					}
					map.put(leftChar, val--);
				}
				left++;
			}
		}
		
		return rs.count;
	}
	
	
	
}