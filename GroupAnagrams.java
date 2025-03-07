import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    static class Node {
        Node[] children = new Node[26]; //size of array = 26
        boolean endOfWord = false;
        List<String> words = new ArrayList<>();
        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word, String original) {    //O(L) L->length of longest word
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.endOfWord = true;
        curr.words.add(original);
    }

    public static void collectAnagrams(Node node, List<List<String>> res) {
        if (node == null) {
            return;
        }
        if (!node.words.isEmpty()) {
            res.add(new ArrayList<>(node.words));
        }
        for (Node child : node.children) {
            collectAnagrams(child, res);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        root = new Node();
        for (String original : strs) {
            char[] temp = original.toCharArray();
            Arrays.sort(temp);
            insert(new String(temp), original);
        }
        List<List<String>> res = new ArrayList<>();
        collectAnagrams(root, res);
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {""};
        String[] strs3 = {"a"};

        System.out.println(groupAnagrams(strs1)); 
        System.out.println(groupAnagrams(strs2)); 
        System.out.println(groupAnagrams(strs3)); 
    }
}
