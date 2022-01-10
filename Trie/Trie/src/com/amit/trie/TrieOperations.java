package com.amit.trie;

public class TrieOperations {

	TrieNode root;
	
	public TrieOperations() {
		root= new TrieNode();
	}
	
	private int getIndex(char x)
	{
		return x-'a';
	}
	
	public void insertWord(String word) {
		TrieNode node = root;
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			int index = getIndex(word.charAt(i));
			if (node.children[index] == null) {
				node.children[index] = new TrieNode();
			}
			node = node.children[index];
		}
		node.setAsLeaf();
	}
	
	public boolean searchWord(String word) {
		if (root == null || word == null || word.isBlank()) {
			System.out.println("either disctionary or word to be searched is null or blank");
			return false;
		}
		word= word.toLowerCase();
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			int index = getIndex(word.charAt(i));
			if (node.children[index] == null) {
				return false;
			}
			node = node.children[index];
		}
		return node.isLeaf();
	}
}
