package com.amit.hashtable;

import java.util.Set;

public class Main {

	public static void main(String[] args) {
		CustomHashMap<String, String> map = new CustomHashMap<>();
		map.addElement("first name", "amit");
		map.addElement("last name", "kumar");
		map.addElement("age", "25");
		map.addElement("1", "one");
		map.addElement("2", "two");
		map.addElement("3", "three");
		map.addElement("4", "four");
		map.addElement("5", "five");
		System.out.println("first name: " + map.getElementValue("first name"));
		System.out.println("last name: " + map.getElementValue("last name"));
		System.out.println("designation: " + map.getElementValue("designation"));
		Set<String> keySet = map.getKeySet();
		System.out.println("=========== print all elements of map ===========");
		for (String s : keySet) {
			System.out.println("key: " + s + ", value: " + map.getElementValue(s));
		}
		map.removeElement("designation");
		map.removeElement("5");
		System.out.println("=========== elements after deletion ===========");
		Set<String> keySet1 = map.getKeySet();
		for (String s : keySet1) {
			System.out.println("key: " + s + ", value: " + map.getElementValue(s));
		}
	}
}
