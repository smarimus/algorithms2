package com.algo2.string;

import java.util.ArrayList;
import java.util.List;

public class MnemonicForPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> result = phoneMnemonic("23");
		System.out.println(result.size());
		result.forEach(System.out::println);

	}
	
	public static List<String> phoneMnemonic(String phoneNumber){ 
		char[] partialMnemonic = new char[phoneNumber.length()]; List<String> mnemonics = new ArrayList<>(); 
		phoneMnemonicHelper(phoneNumber, 0, partialMnemonic, mnemonics); return mnemonics;
	}
	// The mapping from digit to corresponding characters. private static final
	// String[] MAPPING
	private static final String[] MAPPING = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

	private static void phoneMnemonicHelper(String phoneNumber, int digit, char[] partialMnemonic,
			List<String> mnemonics){
		if (digit == phoneNumber.length()){
			mnemonics.add(new String(partialMnemonic));
			return;
		}else{
			int currentChar = Character.getNumericValue(phoneNumber.charAt(digit));
			// Try all possible characters for this digit.
			for (int i = 0; i < MAPPING[currentChar].length();
					++i) {
				partialMnemonic[digit] = MAPPING[currentChar].charAt(i);
				phoneMnemonicHelper(phoneNumber, digit + 1, partialMnemonic, mnemonics);
			}
		}
	}
}
