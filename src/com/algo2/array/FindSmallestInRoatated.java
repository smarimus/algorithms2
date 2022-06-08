package com.algo2.array;

public class FindSmallestInRoatated {

	public static void main(String[] args) {

		int array1[] = { 124, 130, 142, 150, 154, 162, 169, 176, 178, 14, 19, 80 };
		int array2[] = { 15, 0, 1, 5, 12 };
		int array3[] = { 0, 1, 2, 3, 4, 5 };
		int array4[] = {  12, 19, 25, 31, -1, 5, 11 };
		int array5[] = {15, 19, 25, 31, -1, 5, 11, 12, 13};
		int array6[] = {3,4,5,1,2};
		
		/*
		 * System.out.println(findSmallestElement(array1, 0, array1.length - 1));;
		 * System.out.println(findSmallestElement(array2, 0, array2.length - 1));;
		 * System.out.println(findSmallestElement(array3, 0, array3.length - 1));;
		 * System.out.println(findSmallestElement(array4, 0, array4.length - 1));;
		 * System.out.println(findSmallestElement(array5, 0, array5.length - 1));;
		 * System.out.println(findSmallestElement(array6, 0, array6.length - 1));;
		 */
		
		System.out.println(binarySearch(array1, 0, array1.length - 1));;
		System.out.println(binarySearch(array2, 0, array2.length - 1));;
		System.out.println(binarySearch(array3, 0, array3.length - 1));;
		System.out.println(binarySearch(array4, 0, array4.length - 1));;
		System.out.println(binarySearch(array5, 0, array5.length - 1));;
		System.out.println(binarySearch(array6, 0, array6.length - 1));;
		
	}

	public static int findSmallestElement(int[] array, int left, int right) {
		if (left == right) {
			return array[left];
		}
		//int mid = (left+right)/2;
		int mid = left + (right - left) / 2;
		int result = 0;

		if (array[left] < array[mid] && array[mid] < array[right]) {
			result = array[left];
		} else if (array[mid] > array[right]) {
			result = findSmallestElement(array, mid + 1, right);
		} else if (array[mid] <= array[left]) {
			result = array[mid];
		}else {
			result = findSmallestElement(array, left, mid - 1);
		}
		return result;
	}
	
	public static int binarySearch(int[] nums, int start, int end) {
        if(start >= end) {
            return nums[start];
        }
        
        int mid = start + (end - start)/2;
        if(nums[mid] > nums[end]) {
            return binarySearch(nums, mid + 1, end);
        }
        
        return binarySearch(nums, start, mid);
    }

}
