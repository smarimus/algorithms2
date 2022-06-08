package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// simple array
	      String[] strArray = new String[]{"Java", "Node", "Python", "Ruby"};
	      String strArrayCollect = Arrays.stream(strArray).collect(Collectors.joining(", "));
	      System.out.println(strArrayCollect);

	      // alternative
	      System.out.println(String.join(", ", strArray));

	      int[] intArray = {1, 3, 5, 7, 9};
	      String intArrayCollect = Arrays.stream(intArray)
	              .mapToObj(Integer::toString)
	              .collect(Collectors.joining(", "));
	      System.out.println(intArrayCollect);

	      //2d array
	      String[][] strArrayDeep = new String[][]{{"mkyong1", "mkyong2"}, {"mkyong3", "mkyong4"}};
	      String strArrayDeepCollect = Arrays.stream(strArrayDeep)
	              .flatMap(Arrays::stream)
	              .collect(Collectors.joining(", "));
	      System.out.println(strArrayDeepCollect);

	      int[][] intArrayDeep = new int[][]{{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}};
	      String intArrayDeepCollect = Arrays.stream(intArrayDeep).flatMapToInt(Arrays::stream)
	              .mapToObj(Integer::toString)
	              .collect(Collectors.joining(", "));

	      System.out.println(intArrayDeepCollect);

	}

}
