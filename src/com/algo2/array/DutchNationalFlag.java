package com.algo2.array;

import java.util.Arrays;

public class DutchNationalFlag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {0,1,2,2,0,1,0,2,1,0};
		//int[] arr = {1,0,1,0,2,2,0,1,2};
		sort(arr);
		Arrays.stream(arr).forEach(a -> System.out.print(a));
	}
	
	private static void sort(int[] arr) {
		int zero =0; int one=0; int two = arr.length-1;
		
		while(one<=two){
			if(arr[one] == 0){
				swap(arr, zero, one);
				zero++; one++;
			}else if(arr[one] == 1){
				one++;
			}else if(arr[one] == 2){
				swap(arr, one, two);
				two--;
			}
		}
	}
	
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}