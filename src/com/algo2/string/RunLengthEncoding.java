package com.algo2.string;

public class RunLengthEncoding {

	public static void main(String[] args) {
		System.out.println(decoding("4e1w4r6t1q"));
		int v = 'A';
		System.out.println(v);
	}
	
	public static String decoding(String s){
		StringBuilder sb = new StringBuilder();
		
		int count=0;
		for (int i = 0; i < s.length()-1; i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				count = count * 10 + c - '0';
				count = Integer.valueOf(c);
				while(count>0){
					sb.append(s.charAt(i+1));
					count--;
				}
			}
		}
		return sb.toString();
	}
	
	public static String encode(String s){
		//aaaabcccaa
		StringBuilder sb = new StringBuilder();
		int count=1;
		int i=0;
		
		while(i<s.length()-1){
			if(s.charAt(i) == s.charAt(i+1)){
				count++;
			}else{
				sb.append(i);
				sb.append(count);
			}
			count=1;
		}
		return sb.toString();
	}
}