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