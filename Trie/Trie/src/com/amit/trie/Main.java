package com.amit.trie;

public class Main {

	public static void main(String[] args) {
		TrieOperations op= new TrieOperations();
		op.insertWord("there");
		op.insertWord("the");
		System.out.println("word found: "+op.searchWord("the"));
		System.out.println("word found: "+op.searchWord("there"));
		System.out.println("total words: "+ op.findTotalWords());
	}
}
