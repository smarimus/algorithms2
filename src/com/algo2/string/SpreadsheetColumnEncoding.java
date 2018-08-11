package com.algo2.string;

public class SpreadsheetColumnEncoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(ssDecodeColID("AAA"));

	}
	
	public static int ssDecodeColID(final String col) { 
		int result = 0;
		for (int i = 0; i < col.length(); i++) {
			char c = col .charAt (i) ;
			System.out.println(( c - 'A'));
			
			result = result * 26 + c - 'A' + 1;
		}
		return result;
	}

}
