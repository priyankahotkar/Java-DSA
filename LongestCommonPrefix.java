public class LongestCommonPrefix {
    static class Node {
        Node[] children = new Node[26]; //size of array = 26
        boolean endOfWord = false;
        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {    //O(L) L->length of longest word
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.endOfWord = true;
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        for(String str : strs) {
            insert(str);
        }
        StringBuilder lcp = new StringBuilder();
        Node curr = root;
    
        while(true) {
            int childCount = 0;
            int childIndex = -1;
            for(int i = 0; i < 26; i++) {
                if(curr.children[i] != null) {
                    childCount++;
                    childIndex = i;
                }
            }
            if(childCount != 1 || curr.endOfWord) {
                break;
            }
            lcp.append((char) (childIndex+'a'));
            curr = curr.children[childIndex];
        }
        return lcp.toString();
    }

    public static void main(String[] args) {
        String strs[] = {"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
    }
}