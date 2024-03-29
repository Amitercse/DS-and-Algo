package com.amit.trie;

public class TrieNode {

	boolean isEndWord;
	TrieNode[] children;
	int size = 26;

	public TrieNode() {
		children = new TrieNode[size];
		isEndWord = false;
	}
	
	public boolean isLeaf()
	{
		return isEndWord;
	}

	public void setAsLeaf() {
		isEndWord = true;
	}

	public void unsetAsLeaf() {
		isEndWord = false;
	}
	
	public boolean hasNoChildren() {
		for (int i = 0; i < size; i++) {
			if (children[i] != null) {
				return false;
			}
		}
		return true;
	}
}
