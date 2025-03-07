import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTrees {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {  //O(H)
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        else if(key < root.data) {
            return search(root.left, key);
        }
        else {
            return search(root.right, key);
        }       
    }

    public static void levelOrder(Node root) {  //O(n)
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data+" ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

    public static Node delete(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.data < val) {
            root.right = delete(root.right, val);
        }
        else if(root.data > val) {
            root.left = delete(root.left, val);
        }
        else {
            if (root.left == null && root.right == null) {
                return null;
            }
            else if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            else {
                Node IS = findInorderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }
        return root;
    }
    
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }

        else if(root.data < k1) {
            printInRange(root.right, k1, k2);
        }
        else {
            printInRange(root.left, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path) {
        for (Integer integer : path) {
            System.out.print(integer+"->");
        }
        System.out.println("null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        else if(max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void mirrorOfBST(Node root) {
        if (root == null) {
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorOfBST(root.left);
        mirrorOfBST(root.right);
    }

    public static Node mirrorOfBST2(Node root) {
        if (root == null) {
            return null;
        }
        root.left = mirrorOfBST2(root.left);
        root.right = mirrorOfBST2(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static Node sortedArrayToBalancedBST(int[] arr, int si, int ei) {    //O(n)
        if (si > ei) {
            return null;
        }
        if (si == ei) {
            return new Node(arr[si]);
        }
        int mid = (ei-si)/2 + si;
        Node root = new Node(arr[mid]);
        root.left = sortedArrayToBalancedBST(arr, si, mid-1);
        root.right = sortedArrayToBalancedBST(arr, mid+1, ei);
        return root;
    }

    public static void inorderSeq(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderSeq(root.left, arr);
        arr.add(root.data);
        inorderSeq(root.right, arr);
    }

    public static Node convertBSTtoBalancedBST(Node root) { //O(n)
        ArrayList<Integer> arr = new ArrayList<>();
        inorderSeq(root, arr);
        int[] a = new int[arr.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = arr.get(i);
        }
        return sortedArrayToBalancedBST(a, 0, a.length-1);
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    public static Node constructBST(ArrayList<Integer> a, int si, int ei) {
        if (si > ei) {
            return null;
        }
        if (si == ei) {
            return new Node(a.get(si));
        }
        int mid = (ei-si)/2 + si;
        Node root = new Node(a.get(mid));
        root.left = constructBST(a, si, mid-1);
        root.right = constructBST(a, mid+1, ei);
        return root;
    }

    public static Node merge2BSTs(Node root1, Node root2) {  //O(n+m)
        ArrayList<Integer> a1 = new ArrayList<>();
        inorderSeq(root1, a1);
        ArrayList<Integer> a2 = new ArrayList<>();
        inorderSeq(root2, a2);
        ArrayList<Integer> a = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a1.size() && j < a2.size()) {
            if (a1.get(i) < a2.get(j)) {
                a.add(a1.get(i));
                i++;
            }
            else {
                a.add(a2.get(j));
                j++;
            }
        }
        while (i < a1.size()) {
            a.add(a1.get(i));
            i++;
        }
        while (j < a2.size()) {
            a.add(a2.get(j));
            j++;
        }
        Node root = constructBST(a, 0, a.size()-1);
        return root;
    }

    public static int rangeSum(Node root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (R < root.data) {
            return rangeSum(root.left, L, R);
        }
        if (L > root.data) {
            return rangeSum(root.right, L, R);
        }
        return rangeSum(root.left, L, R) + rangeSum(root.right, L, R) + root.data;
    }

    static class Info2 {
        Node node;
        int absDiff;
        public Info2(Node node, int absDiff) {
            this.node = node;
            this.absDiff = absDiff;
        }
    }
    public static Info2 closestNode(Node root, int K) {
        if (root == null) {
            return new Info2(null, Integer.MAX_VALUE);
        }
        int currDiff = Math.abs(root.data - K);
        Info2 closest = new Info2(root, currDiff);
        if (K < root.data) {
            Info2 leftRes = closestNode(root.left, K);
            if (closest.absDiff > leftRes.absDiff) {
                closest = leftRes;
            }
        }
        else {
            Info2 rightRes = closestNode(root.right, K);
            if(closest.absDiff > rightRes.absDiff) {
                closest = rightRes;
            }
        }
        return closest;
    }

    public static int kthSmallestElement(Node root, int K) {
        ArrayList<Integer> a = new ArrayList<>();
        inorderSeq(root, a);
        return a.get(K-1);
    }

    static int sum = 0;
    public static void greaterSumTree(Node root) {
        if (root == null) {
            return;
        }
        greaterSumTree(root.right);
        sum += root.data;
        root.data = sum - root.data;
        greaterSumTree(root.left);
    }

    static class Info3 {
        boolean isBST;
        int sum;
        int min;
        int max;
        public Info3(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxSum = 0;

    public static Info3 maxSumBST(Node root) {
        if (root == null) {
            return new Info3(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info3 leftInfo = maxSumBST(root.left);
        Info3 rightInfo = maxSumBST(root.right);

        int sum = leftInfo.sum + rightInfo.sum + root.data;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info3(false, sum, min, max);
        }
        if (leftInfo.isBST && rightInfo.isBST) {
            maxSum = Math.max(maxSum, sum);
            return new Info3(true, sum, min, max);
        }
        return new Info3(false, sum, min, max);
    }

    public static void main(String[] args) {
        // int values[] = {8, 5, 3, 6, 10, 11};
        // Node root = null;
        // for (int i = 0; i < values.length; i++) {
        //     root = insert(root, values[i]);
        // }
        // inorder(root);
        // Node root = new Node(8);
        // root.left = new Node(5);
        // root.left.left = new Node(3);
        // root.left.left.left = new Node(1);
        // root.left.left.right = new Node(4);
        // root.left.right = new Node(6);
        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(14);
        // System.out.println(search(root, 1));
        // inorder(root);
        // System.out.println();
        // root = delete(root, 5);
        // inorder(root);
        // printInRange(root, 5, 12);
        // printRoot2Leaf(root, new ArrayList<>());
        // if (isValidBST(root, null, null)) {
        //     System.out.println("Valid");
        // }
        // else {
        //     System.out.println("Not valid");
        // }
        // mirrorOfBST(root);
        // inorder(root);
        // System.out.println();
        // root = mirrorOfBST2(root);
        // inorder(root);
        // int arr[] = {3, 5, 6, 8, 10, 11, 12};
        // Node root = sortedArrayToBalancedBST(arr, 0, arr.length-1);
        // System.out.println(root.data);
        // inorder(root);
        // System.out.println();
        // levelOrder(root);

        // int values[] = {8, 6, 5, 3, 10, 11, 12};
        // Node root = null;
        // for (int i = 0; i < values.length; i++) {
        //     root = insert(root, values[i]);
        // }
        // levelOrder(root);
        // Node root2 = convertBSTtoBalancedBST(root);
        // levelOrder(root2);

        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);

        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(75);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        // Info info = largestBST(root);
        // System.out.println(maxBST);

        // Node root1 = new Node(2);
        // root1.left = new Node(1);
        // root1.right = new Node(4);
        // Node root2 = new Node(9);
        // root2.left = new Node(3);
        // root2.right = new Node(12);
        // Node root = merge2BSTs(root1, root2);
        // levelOrder(root);

        int values[] = {8, 5, 3, 6, 11, 20};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        levelOrder(root);
        // System.out.println(rangeSum(root, 5, 11));
        // System.out.println(closestNode(root, 19).node.data+" "+closestNode(root, 19).absDiff);
        // System.out.println(kthSmallestElement(root, 5));
        // greaterSumTree(root);
        // levelOrder(root);
        maxSumBST(root);
        System.out.println(maxSum);
    }
}
