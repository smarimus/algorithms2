package com.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	      List<String> items  =Stream.of("1","2","3").collect(Collectors.toList());
	      String res = items.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining(","));
	      System.out.println(res);
	      
	      Collections.sort(items, Comparator.reverseOrder());
	      
	      Stream.of("foo", "test", "a")
	      .sorted(Comparator.comparingInt(String::length).reversed()); 
	      
	      String s = "";
	      char [] c = s.toCharArray();

	}

}
