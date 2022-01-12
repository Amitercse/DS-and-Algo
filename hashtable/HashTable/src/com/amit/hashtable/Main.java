package com.amit.hashtable;

import java.util.Set;

public class Main {

	public static void main(String[] args) {
		CustomHashMap<String, String> map = new CustomHashMap<>();
		map.addElement("first name", "amit");
		map.addElement("last name", "kumar");
		map.addElement("age", "25");
		System.out.println("first name: " + map.getElementValue("first name"));
		System.out.println("last name: " + map.getElementValue("last name"));
		System.out.println("designation: " + map.getElementValue("designation"));
		Set<String> keySet = map.getKeySet();
		for (String s : keySet) {
			System.out.println("key: " + s + ", value: " + map.getElementValue(s));
		}
	}
}
