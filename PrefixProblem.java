public class PrefixProblem {
    static class Node {
        Node[] children = new Node[26]; //size of array = 26
        boolean endOfWord = false;
        int freq = 0;
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
            curr.children[idx].freq += 1;
            curr = curr.children[idx];
        }

        curr.endOfWord = true;
    }

    public static String search(String word) {
        String ans = "";
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {   //O(L)
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return "";
            }
            else {
                if(curr.children[idx].freq != 1) {
                    ans += word.charAt(level);
                    curr = curr.children[idx];
                } else {
                    ans += word.charAt(level);
                    return ans;
                }
            }
        }
        return ans;
    }

    //Or
    public static void findPrefix(Node root, String ans) {  //O(L)
        if (root == null) {
            return;
        }
    
        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }
    
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                findPrefix(root.children[i], ans + (char) (i + 'a'));
            }
        }
    }
    

    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.print(search(arr[j])+" ");
        }
        System.out.println();
        findPrefix(root, "");
    }
}
