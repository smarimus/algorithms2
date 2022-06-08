package com.companies.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
We are working on a security system for a badged-access room in our company's building.

Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:

1. All employees who didn't use their badge while exiting the room - 
they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)

2. All employees who didn't use their badge while entering the room - 
they recorded an exit without a matching enter. (The room is empty when the log begins.)

Each collection should contain no duplicates, 
regardless of how many times a given employee matches the criteria for belonging to it.

badge_records_1 = [
  ["Martha",   "exit"],
  ["Paul",     "enter"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "enter"],
  ["Paul",     "enter"],
  ["Curtis",   "exit"],
  ["Curtis",   "enter"],
  ["Paul",     "exit"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "exit"],
  ["Paul",     "enter"],
  ["Paul",     "enter"],
  ["Martha",   "exit"],
]

Expected output: (no_exit) ["Curtis", "Paul"], (no_enter) ["Martha", "Curtis"]

Additional test cases:

badge_records_2 = [
  ["Paul", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
]

Expected output: ["Paul"], []

badge_records_3 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
]

Expected output: [], ["Paul"]

badge_records_4 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
  ["Paul", "enter"],
  ["Martha", "enter"],
  ["Martha", "exit"],
]

Expected output: ["Paul"], ["Paul"]

badge_records_5 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
]

Expected output: [], []

badge_records_6 = [
  ["Paul", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
]

Expected output: ["Paul"], ["Paul"]

n: length of the badge records array
*/

public class Peloton_2021 {
	public static void main(String[] argv) {
		String badgeRecords1[][] = new String[][] { { "Martha", "exit" }, // <employee_name>, <event_type>
				{ "Paul", "enter" }, { "Martha", "enter" }, { "Martha", "exit" }, { "Jennifer", "enter" },
				{ "Paul", "enter" }, { "Curtis", "exit" }, { "Curtis", "enter" }, { "Paul", "exit" },
				{ "Martha", "enter" }, { "Martha", "exit" }, { "Jennifer", "exit" }, { "Paul", "enter" },
				{ "Paul", "enter" }, { "Martha", "exit" }, };

		String badgeRecords2[][] = new String[][] { { "Paul", "enter" }, { "Paul", "enter" }, { "Paul", "exit" }, };

		String badgeRecords3[][] = new String[][] { { "Paul", "enter" }, { "Paul", "exit" }, { "Paul", "exit" }, };

		String badgeRecords4[][] = new String[][] { { "Paul", "enter" }, { "Paul", "exit" }, { "Paul", "exit" },
				{ "Paul", "enter" }, { "Martha", "enter" }, { "Martha", "exit" }, };

		String badgeRecords5[][] = new String[][] { { "Paul", "enter" }, { "Paul", "exit" }, };

		String badgeRecords6[][] = new String[][] { { "Paul", "enter" }, { "Paul", "enter" }, { "Paul", "exit" },
				{ "Paul", "exit" }, };

		System.out.println(seggregateNoExitAndNoEnter(badgeRecords1));
		System.out.println(seggregateNoExitAndNoEnter(badgeRecords2));
		System.out.println(seggregateNoExitAndNoEnter(badgeRecords3));
		System.out.println(seggregateNoExitAndNoEnter(badgeRecords4));
		System.out.println(seggregateNoExitAndNoEnter(badgeRecords5));
		System.out.println(seggregateNoExitAndNoEnter(badgeRecords6));

	}

	public static List<Set<String>> seggregateNoExitAndNoEnter(String[][] badgeRecords) {
		List<Set<String>> res = new ArrayList<>();
		Map<String, Integer> userMap = new HashMap<>();

		Set<String> noExit = new HashSet<>();
		Set<String> noEnter = new HashSet<>();

		for (String[] badgeRecord : badgeRecords) {
			String name = badgeRecord[0];
			String event = badgeRecord[1];

			int enterCount = userMap.getOrDefault(name, 0);
			if ("exit".equals(event) && enterCount <= 0) {
				if (!noEnter.contains(name)) {
					noEnter.add(name);
				}
			} else if ("exit".equals(event)) {
				userMap.put(name, --enterCount);
			}

			if ("enter".equals(event) && enterCount > 0) {
				noExit.add(name);
			} else if ("enter".equals(event)) {
				userMap.put(name, ++enterCount);
			}
		}
		userMap.entrySet().stream().forEach(e -> {
			String name = e.getKey();
			int count = e.getValue();
			if (count > 0) {
				if (!noExit.contains(name)) {
					noExit.add(name);
				}
			}
		});
		res.add(noExit);
		res.add(noEnter);

		return res;
	}

}
