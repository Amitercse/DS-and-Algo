package com.amit.hashtable;

import java.util.HashSet;
import java.util.Set;

public class CustomHashMap<K, V> {
	private Node<K, V>[] arr;
	private int size;
	private static final int DEFAULT_CAPACITY=16;
	
	public CustomHashMap() {
		arr= new Node[DEFAULT_CAPACITY];
		size=0;
	}
	
	public void addElement(K key, V value) {
		int index = ((arr.length-1) & key.hashCode());
		Node<K, V> node = new Node<K, V>(key, value);
		if (arr[index] == null) {
			arr[index] = node;
			size++;
			return;
		}
		Node<K, V> temp = arr[index];
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		size++;
	}
	
	public V getElementValue(K key) {
		int index = ((arr.length-1) & key.hashCode());
		Node<K, V> node = arr[index];
		if(node== null)
		{
			return null;
		}
		if (key.equals(node.key)) {
			return node.value;
		}
		node = node.next;
		while (node != null) {
			if (key.equals(node.key)) {
				return node.value;
			}
			node = node.next;
		}
		return null;
	}
	
	public Set<K> getKeySet() {
		Set<K> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			Node<K, V> node = arr[i];
			while (node != null) {
				set.add(node.key);
				node = node.next;
			}
		}
		return set;
	}
	
	static class Node<K, V> {
		K key;
		V value;
		Node<K, V> next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
}