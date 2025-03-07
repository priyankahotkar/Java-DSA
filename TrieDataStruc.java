public class TrieDataStruc {
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
    
    public static boolean wordBreakProblem(String key) {    //O(L)
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if(search(key.substring(0, i)) && wordBreakProblem(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean startsWith(String prefix) {   //O(L)
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            else {
                curr = curr.children[idx];
            }
        }
        return true;
    }

    public static int countUniqueSubstrings(String str) {
        //step 1 : find all suffix of string
        // String[] subStrings = new String[str.length()];
        // for (int i = 0; i < str.length(); i++) {
        //     subStrings[i] = str.substring(i);
        // }

        //step 2 : create trie for suffixes
        // for (int i = 0; i < subStrings.length; i++) {
        //     insert(subStrings[i]);
        // }

        // Both step 1& 2 :
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        //step 3 : no. of unique substrings = no. of nodes of trie
        //count nodes of trie
        return countNodes(root);
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count+1;
    }

    public static String ans = "";
    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].endOfWord) {
                char ch = (char)(i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                //backtrack
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        // String words[] = {"the", "a", "there", "their", "any", "thee"};
        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }
        // System.out.println(search("any"));
        // System.out.println(search("an"));

        // String arr[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        // for (int i = 0; i < arr.length; i++) {
        //     insert(arr[i]);
        // }
        // String key = "ilikesung";
        // System.out.println(wordBreakProblem(key));

        // String[] words = {"apple", "app", "mango", "man", "woman"};
        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }
        // System.out.println(startsWith("app"));
        // System.out.println(startsWith("moon"));
        // System.out.println(startsWith("man"));
        // System.out.println(startsWith("apn"));

        // String str = "ababa";
        // System.out.println(countUniqueSubstrings(str));

        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
