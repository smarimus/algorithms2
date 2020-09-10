package com.algo2.string;

public class FindFirstOccuranceOfaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "sudhakar";
		String find = "kar";
		
		System.out.println(find("sudhakkkkkar", "kar"));
	}
	
	public static int find(String s, String find){
		int result=-1;
		for (int i = 0; i < s.length(); i++) {
			int count=0;
			// This is needed because multiple k can occur
			int k=i;
			for (int k2 = 0; k2 < find.length(); k2++) {
				if(s.charAt(k) == find.charAt(k2)){
					k++;
					count++;
				}else{break;}
			}
			if(count == find.length()){
				result=i;
				break;
			}
		}
		return result;
	}	
}