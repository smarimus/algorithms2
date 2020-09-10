package com.bitwise;

public class CountBits {

	
	public static short countBits(int x) {
		short numBits = 0;
		while (x != 0) {
			System.out.println("first " + Integer.toBinaryString(x & 1) + " : " + x);
			numBits += (x & 1);
			x >>>= 1;
			System.out.println("second " + Integer.toBinaryString(x) + " : " + x);
			System.out.println();
		}
		return numBits; 
	}
	
	public static void main(String[] args) {
		int x=10;
		System.out.println(Integer.toBinaryString(5));
		//System.out.println(Integer.toBinaryString(1));
		
		System.out.println(10&1);
		System.out.println(5&1);
		System.out.println(2&1);
		
		System.out.println("16>>>1 " + (16>>>1));
		System.out.println("-16>>1" + (-16>>1));
		
		System.out.println("-16>>>1 " + (-16>>>1));
		System.out.println("1<<31 " + (1<<31));
		
		int bitmask = 0x000F;
		System.out.println(bitmask);
		
		int A = 34;
		int j = 3;
		System.out.println(1<<j);
		System.out.println(Integer.toBinaryString(1<<j));
		
		//System.out.println(countBits(x));
	}
}
