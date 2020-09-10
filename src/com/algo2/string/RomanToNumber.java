package com.algo2.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(romanToInteger("XXXXXIIIIIIIII"));
		System.out.println(romanToInteger("LIX"));
		System.out.println(romanToInteger("LVIIII"));
		System.out.println(romanToInteger("CDM"));
	}
	
	
	/*The Roman numeral representation of positive integers uses the symbols I,V,X,L,C,D,M. Each symbol represents a value, with 
	I being 1, V being 5, X being 10, L being 50, C being 100, D being 500, and M being 1000.
	
	In this problem we give simplified rules for representing numbers in this system. Specifically, define a string over the Roman number 
	symbols to be a valid Roman number string if symbols appear in nonincreasing order,withthefollowingexceptions allowed:
	• I can immediately precede V and X. 
	• X can immediately precede L and C. 
	• C can immediately precede D and M.
	
	Back-to-back exceptions are not allowed, e.g., IXC is invalid, as is CDM.
	A valid complex Roman number string represents the integer which is the sum of the symbols that do not correspond to exceptions; 
	
	for the exceptions, add the
	difference of the larger symbol and the smaller symbol.
	For example, the strings "XXXXXfflllllH", "LVIIII" and "LIX" are valid Roman
	number strings representing 59. The shortest valid complex Roman number string corresponding to the integer 59 is "LIX".
	
	*/	
	
	public static int romanToInteger(String s){
		Map<Character, Integer> T = new HashMap<Character, Integer>();
		
		T.put('I',1);
		T.put('V',5);
		T.put('X', 10);
		
		T.put('L',50);
		T.put('C',100);
		
		T.put('D',500);
		T.put('M',1000);
		
		int sum =T.get(s.charAt(s.length()-1));
		
		//System.out.println(sum);
		for (int i =s.length() - 2; i >= 0; --i) {
			if (T.get(s.charAt(i)) < T.get(s.charAt(i + 1))) {
				sum -= T.get(s.charAt(i));
			} else {
				sum += T.get(s.charAt(i));
			}
		}
		return sum;
	}
	
	public static int rtoi(String num){
		
		Map<Character, Integer> T = new HashMap<Character, Integer>();
		
		T.put('I',1);
		T.put('V',5);
		T.put('X', 18);
		T.put('L',58);
		T.put('C',188);
		T.put('D',588);
		T.put('M',1888);
		
	    int intNum=0;
	    int prev = 0;
	    for(int i = num.length()-1; i>=0 ; i--){
            int temp = T.get(num.charAt(i));
            if(temp < prev)
                intNum-=temp;
            else
                intNum+=temp;
            prev = temp;
	    }
	    return intNum;
	}   
}