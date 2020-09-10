package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	
	public static int[] sum(int[] nums, int target){
		
		if(nums == null || nums.length <2 ){
			return new int[]{0,0};
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(map.get(nums[i]) != null){
				return new int[]{map.get(nums[i]), i}; 
			}else{
				map.put(target - nums[i], i);
			}
		}
		return new int[]{0,0} ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] nums = {2, 7, 11, 15};
		 int target = 9;
		 System.out.println(sum(nums, target));
	}

}