public class LongestWordinDict {
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

    public static boolean search(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {   //O(L)
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        if (curr.endOfWord == true) {
            return true;
        }
        return false;
    }

    public static String ans = "";
    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].endOfWord) {
                char c = (char)(i+'a');
                temp.append(c);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1); //backtrack
            }
        }
    }

    public static void main(String[] args) {
        String words[] = {"w","wo","wor","worl","world"};
        for (String string : words) {
            insert(string);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
