package tree;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Phone List
 *
 */
public class PhoneList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();

            Trie trie = new Trie();
            boolean res = true;

            for(int j = 0; j < n; j++) {
                String str = scanner.nextLine();
                if(res && (trie.startsWith(str) || trie.prefixed(str))) {
                    res = false;
                }
                trie.insert(str);
            }

            System.out.println(res ? "YES" : "NO");
        }
    }
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			if (node.map.containsKey(word.charAt(i))) {
				node = node.map.get(word.charAt(i));
			} else {
				TrieNode n = new TrieNode();
				node.map.put(word.charAt(i), n);
				node = n;
			}
		}
		node.isWord = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			if (!node.map.containsKey(word.charAt(i)))
				return false;
			node = node.map.get(word.charAt(i));
		}
		return node.isWord;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			if (!node.map.containsKey(prefix.charAt(i)))
				return false;
			node = node.map.get(prefix.charAt(i));
		}
		return true;
	}

	/**
	 * Returns true if the word is prefixed by another word in the trie; false
	 * otherwise.
	 */
	public boolean prefixed(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			if (node.map.containsKey(word.charAt(i)))
				node = node.map.get(word.charAt(i));
			else
				break;
		}
		return node.isWord;
	}
}

class TrieNode {
	HashMap<Character, TrieNode> map;
    boolean isWord;

    public TrieNode() {
        map = new HashMap<>();
        isWord = false;    
    }
}
