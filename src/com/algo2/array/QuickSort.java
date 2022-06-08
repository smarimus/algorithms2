package com.algo2.array;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println();
		
		int[] b = {3,1};
		quickSort(b, 0, b.length-1);
		Arrays.stream(b).forEach(System.out::print);
		
		System.out.println();
		
		int[] c = {4,-1,6,8,0,5,-3};
		quickSort(c, 0, c.length-1);
		Arrays.stream(c).forEach(System.out::println);
		
		/*
		 * int[] a = {3, 5, 1, 4, 2}; quick_sort(a, 0, a.length-1);
		 * Arrays.stream(a).forEach(System.out::print);
		 */
		
	}
	
	public static void quickSort(int[] a, int left, int right) {
		if(left < right) {
			int sortedIndex = partition(a, left, right);
			quickSort(a, left, sortedIndex-1);
			quickSort(a, sortedIndex+1, right);
		}
	}
	
	static void quick_sort(int intArray[], int low, int high) { 
        if (low < high) { 
            //partition the array around pi=>partitioning index and return pi
            int pi = partition(intArray, low, high); 
   
            // sort each partition recursively 
            quick_sort(intArray, low, pi-1); 
            quick_sort(intArray, pi+1, high); 
        } 
    } 
	
	public static int partition(int[]  a, int left, int right){
		  
		  int pivot = left;
		  int pivotVal = a[left];
		  
		  left = left+1;		  

		  while(left <= right){

		      if(a[left] < pivotVal){
		        left++;
		        continue;
		      }

		      if(a[right] > pivotVal ){
		        right--;
		        continue;
		      }
		      swap(a, left, right);
		      left++; right--;
		  }
		  if(a[right] < a[pivot]){
		    swap(a, pivot, right);
		  }
		  
		  return right;
		}
	
	
	
	static int partition1(int intArray[], int low, int high) { 
        int pi = intArray[high];  
        int i = (low-1); // smaller element index   
        for (int j=low; j<high; j++) { 
            // check if current element is less than or equal to pi 
            if (intArray[j] <= pi) { 
                i++; 
                // swap intArray[i] and intArray[j] 
                int temp = intArray[i]; 
                intArray[i] = intArray[j]; 
                intArray[j] = temp; 
            } 
        } 
   
        // swap intArray[i+1] and intArray[high] (or pi) 
        int temp = intArray[i+1]; 
        intArray[i+1] = intArray[high]; 
        intArray[high] = temp; 
   
        return i+1; 
    } 

		public static void swap(int[] a, int left, int right){
		  int temp = a[left];
		  a[left] = a[right];
		  a[right] = temp;
		}

}
