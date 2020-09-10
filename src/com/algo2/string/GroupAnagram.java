package com.algo2.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

		groupAnagrams(strs).forEach(ls -> System.out.print(ls));

	}

	public static List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String s : strs) {
			char[] charArr = s.toCharArray();
			Arrays.sort(charArr);
			String sortedString = String.valueOf(charArr);

			if (!map.containsKey(sortedString))
				map.put(sortedString, new ArrayList());
			map.get(sortedString).add(s);
		}
		return new ArrayList(map.values());
	}

	public List<List<String>> groupAnagrams1(String[] strs) {

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			String word = strs[i];
			char[] charArr = word.toCharArray();
			Arrays.sort(charArr);

			String sortedString = String.valueOf(charArr);

			if (map.containsKey(sortedString)) {
				map.get(sortedString).add(word);
			} else {
				List ls = new ArrayList<String>();
				ls.add(word);
				map.put(sortedString, ls);
				;
			}
		}

		List<List<String>> finalList = new ArrayList<List<String>>();
		Set<String> key = map.keySet();
		Iterator<String> itr = key.iterator();
		while (itr.hasNext()) {
			finalList.add(map.get(itr.next()));
		}

		return finalList;
	}

}
