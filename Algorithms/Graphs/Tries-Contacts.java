package triesContacts;

import java.util.Scanner;

class TrieNode {
    private static final int CHARACTER_NUMBERS = 26;
    private TrieNode[] children;
    private int size;

    public TrieNode() {
        this.children = new TrieNode[CHARACTER_NUMBERS];
        this.size = 0;
    }

    public int findCount (String s, int index) {
        if (index == s.length()) {
            return size;
        }

        TrieNode child = getNode(s.charAt(index));
        if (child == null) {
            return 0;
        }
        return child.findCount(s, index + 1);
    }

    public void add(String s) {
        add(s, 0);
    }

    private void add(String s, int index) {
        size++;
        if (index == s.length()) {
            return;
        }

        char current = s.charAt(index);
        TrieNode child = getNode(current);
        if (child == null) {
            child = new TrieNode();
            setNode(current, child);
        }
        child.add(s, index + 1);
    }

    private TrieNode getNode(char c) {
        return children[getCharIndex(c)];
    }

    private void setNode(char c, TrieNode node) {
        children[getCharIndex(c)] = node;
    }

    private int getCharIndex(char c) {
        return c - 'a';
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        TrieNode trie = new TrieNode();
        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");
            String op = opContact[0];
            String contact = opContact[1];
            if ("add".equals(op)) {
                trie.add(contact);
            } else if ("find".equals(op)) {
                int count = trie.findCount(contact, 0);
                System.out.println(count);
            }
        }
    }
}
