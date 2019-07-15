package trie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * @author ruihan
 *
 */

public class TrieDictionary {
	public static void main(String[] args) throws FileNotFoundException {
		TrieDictionary td = new TrieDictionary();
		Scanner data = new Scanner(new FileInputStream("dict.txt"));
		while (data.hasNext())
			td.insert(data.next());
		data.close();
		Scanner data2 = new Scanner(new FileInputStream("hw5.txt"));
		while (data2.hasNext())
			System.out.println(td.match(data2.next()));
		data2.close();
		
	}

	private class TrieNode {
		TrieNode[] children;
		boolean isLeaf;

		TrieNode() {
			children = new TrieNode[26];
			isLeaf = false;
		}
	}

	private TrieNode root;

	public TrieDictionary() {
		root = new TrieNode();
	}

	private void insert(String word) {
		insertTo(word);
	}

	public void insertTo(String word) {
		TrieNode node = root;

		for (char x : word.toCharArray()) {
			if (node.children[x - 'a'] == null)
				node.children[x - 'a'] = new TrieNode();
			node = node.children[x - 'a'];
		}
		node.isLeaf = true;
	}

	public boolean search(String word) {
		TrieNode node = root;

		for (char x : word.toCharArray()) {
			if (node.children[x - 'a'] == null)
				return false;
			else
				node = node.children[x - 'a'];
		}
		return node.isLeaf;
	}

	public boolean initializeWith(String prefix) {
		TrieNode node = root;

		for (char x : prefix.toCharArray()) {
			if (node.children[x - 'a'] == null)
				return false;
			else
				node = node.children[x - 'a'];
		}
		return true;
	}

	public boolean match(String word) {
		return match(root, 0, word);
	}

	private boolean match(TrieNode node, int k, String word) {
		if (node == null)
			return false;
		else if (k == word.length())
			return node.isLeaf;

		char c = word.charAt(k);

		if (c == '.') {
			for (TrieNode x : node.children)
				if (match(x, k + 1, word))
					return true;
			return false;
		} else {
			TrieNode x = node.children[c - 'a'];
			return match(x, k + 1, word);
		}
	}
}
