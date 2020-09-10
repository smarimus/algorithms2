package com.algo2.string;

public class Sinusoidally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("Hellow World!"));
	}

	public static String convert(String s) {
		StringBuilder result = new StringBuilder();

		for (int i = 1; i < s.length(); i += 4) {
			result.append(s.charAt(i));
		}
		for (int i = 0; i < s.length(); i += 2) {
			result.append(s.charAt(i));
		}
		for (int i = 3; i < s.length(); i += 4) {
			result.append(s.charAt(i));
		}
		return result.toString();
	}

	public static String snakeString(String s) {
		StringBuilder result = new StringBuilder();
		for (int i = 1; i < s.length(); i += 4) {
			result.append(s.charAt(i));
		}
		for (int i = 0; i < s.length(); i += 2) {
			result.append(s.charAt(i));
		}
		for (int i = 3; i < s.length(); i += 4) {
			result.append(s.charAt(i));
		}
		return result.toString();
	}

}

/*
 * if(i%2 == 0){ System.out.print(s.charAt(i)); }else System.out.print("");
 */