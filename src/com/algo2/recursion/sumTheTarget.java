package com.algo2.recursion;

public class sumTheTarget {

	public static void main(String[] args) {
		
		int[] arr = {2, 3, 4, 5};
		//int[] arr = {5, 2, 2, 25};
		
		int target = 25;
		boolean val = sumTheTargetVal(arr, target, arr[0], 0);
		System.out.println(val);
		
	}
	
	public static boolean sumTheTargetVal(int arr[], int target, int sum, int counter){
		
		if(sum == target){
			return true;
		}
		if( counter >= arr.length-1){
			System.out.println(sum + " " + arr.length);
			return false;
		}
		boolean result = false;
		
		//add
		result = sumTheTargetVal(arr, target, sum + arr[counter+1], counter+1);
		if(result)
			return true;
		
		//multiply
		result = sumTheTargetVal(arr, target, sum * arr[counter+1], counter+1);
		if(result)
			return true;
		
		return result;
	}
}