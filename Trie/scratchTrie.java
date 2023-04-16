package Trie;

public class scratchTrie {
    static class Node {
        Node childern[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                childern[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String words) {
        Node cur = root;
        for (int i = 0; i < words.length(); i++) {
            int idx = words.charAt(i) - 'a';
            if (cur.childern[idx] == null) {
                cur.childern[idx] = new Node();
            }
            cur = cur.childern[idx];
        }

        cur.eow = true;
    }

    public static boolean search(String key) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (cur.childern[idx] == null) {
                return false;
            }
            cur = cur.childern[idx];
        }

        return cur.eow == true;
    }

    public static boolean breakword(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && breakword(key.substring(i))) {
                return true;
            }
        }
        return false;

    }

    public static void main(String args[]) {
        String words[] = { "i", "like", "sam", "samsung" };

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        String key = "ilike";
        System.out.println(breakword(key));
        breakword(key);
    }

}
