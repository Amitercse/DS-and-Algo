package com.amit.array;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingInteger {

	public static void main(String[] args) {
		FirstNonRepeatingInteger nonRepeating= new FirstNonRepeatingInteger();
		int[] arr= {4,5,1,2,0,4};
		int number= nonRepeating.findFirstNonRepetitive(arr);
		System.out.println("first non repeating number: "+ number);
	}
	
	private int findFirstNonRepetitive(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int occurrence = map.get(arr[i]) + 1;
				map.put(arr[i], occurrence);
			} else {
				map.put(arr[i], 0);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) == 0) {
				return arr[i];
			}
		}
		return -1;
	}
}
