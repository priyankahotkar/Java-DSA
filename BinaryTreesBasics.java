import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesBasics {
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

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) { //preorder :- O(n)
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preorder(Node root) {    //O(n)
            if (root == null) {
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {    //O(n)
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        public static void postorder(Node root) {   //O(n)
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
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

        public static int heightOfTree(Node root) {     //O(n)
            if (root == null) {
                return 0;
            }
            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);
        
            return Math.max(leftHeight, rightHeight) + 1;
        }

        public static int countOfNodes(Node root) {     //O(n)
            if (root == null) {
                return 0;
            }
            int lcount = countOfNodes(root.left);
            int rcount = countOfNodes(root.right);
            return lcount+rcount+1;
        }

        public static int sumOfNodes(Node root) {     //O(n)
            if (root == null) {
                return 0;
            }
            int lsum = sumOfNodes(root.left);
            int rsum = sumOfNodes(root.right);
            return lsum + rsum + root.data;
        }

        public static int diameter(Node root) {     //O(n^2) 
            if (root == null) {
                return 0;
            }
            int ldiameter = diameter(root.left);
            int rdiameter = diameter(root.right);
            int lheight = heightOfTree(root.left);
            int rheight = heightOfTree(root.right);
            return Math.max(lheight+rheight+1, Math.max(ldiameter, rdiameter));
        }

        static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }
        public static Info diameter2(Node root) {   //O(n)
            if (root == null) {
                return new Info(0, 0);
            }

            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);

            int diam = Math.max(leftInfo.ht + rightInfo.ht + 1, Math.max(leftInfo.diam, rightInfo.diam));
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            Info info = new Info(diam, ht);

            return info;
        }

        public static boolean isIdentical(Node node, Node subRoot) {
            if (node == null && subRoot == null) {
                return true;
            } else if(node == null || subRoot == null || node.data != subRoot.data) {
                return false;
            }

            if (!isIdentical(node.left, subRoot.left)) {
                return false;
            }
            if (!isIdentical(node.right, subRoot.right)) {
                return false;
            }
            return true;
        }

        public static boolean isSubtree(Node root, Node subRoot) {
            if (root == null) {
                return false;
            }
            if (root.data == subRoot.data) {
                if(isIdentical(root, subRoot)) {
                    return true;
                }
            }

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        static class Infotopview {
            Node node;
            int hd;

            public Infotopview(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        public static void topView(Node root) {
            // Level Order
            Queue<Infotopview> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();

            int min = 0, max = 0;
            q.add(new Infotopview(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                Infotopview curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                }
                else {
                    if (!map.containsKey(curr.hd)) {    //first time my hd is occurring
                        map.put(curr.hd, curr.node);
                    }
    
                    if (curr.node.left != null) {
                        q.add(new Infotopview(curr.node.left, curr.hd-1));
                        min = Math.min(min, curr.hd-1);
                    }
                    if (curr.node.right != null) {
                        q.add(new Infotopview(curr.node.right, curr.hd+1));
                        max = Math.max(max, curr.hd+1);
                    }
                }
            }

            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data+" ");
            }
        }

        public static void kthLevel(Node root, int k, int level){   //O(n)
            if (root == null) {
                return;
            }
            if (level == k) {
                System.out.print(root.data+" ");
                return;
            }
            kthLevel(root.left, k, level+1);
            kthLevel(root.right, k, level+1);
        }

        public static boolean getPath(Node root, int n, ArrayList<Node> path) {
            if (root == null) {
                return false;
            }
            path.add(root);
            if (root.data == n) {
                return true;
            }

            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);
            if (foundLeft || foundRight) {
                return true;
            }
            
            path.remove(path.size()-1);
            return false;
        }

        public static Node lca(Node root, int n1, int n2) {     //O(n)
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();
            getPath(root, n1, path1);
            getPath(root, n2, path2);

            //last common anscestor
            int i = 0;
            for(; i<path1.size() && i<path2.size(); i++) {
                if (path1.get(i) != path2.get(i)) {
                    break;
                }
            }

            //last equal node -> i-1th
            Node lca = path1.get(i-1);
            return lca;
        }

        public static Node lca2(Node root, int n1, int n2) {    //O(n)
            if (root == null) {
                return null;
            }
            if (root.data == n1 || root.data == n2) {
                return root;
            }

            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);

            //leftLCA=val rightLCA = null
            if (rightLca == null) {
                return leftLca;
            }

            //rightLCA=val leftLCA = null
            if (leftLca == null) {
                return rightLca;
            }

            return root;
        }

        public static int getDistance(Node a, int n) {
            if (a == null) {
                return -1;
            }
            if (a.data == n) {
                return 0;
            }
            int leftDist = getDistance(a.left, n);
            int rightDist = getDistance(a.right, n);
            if (leftDist == -1 && rightDist == -1) {
                return -1;
            }
            else if (leftDist > -1 && rightDist == -1) {
                return leftDist+1;
            }
            else {
                return rightDist+1;
            }
        }

        public static int minDistance(Node root, int n1, int n2) {  //O(n)
            Node lca = lca2(root, n1, n2);
            int dist1 = getDistance(lca, n1);
            int dist2 = getDistance(lca, n2);
            return dist1+dist2;
        }

        public static int kthAncestor(Node root, int n, int k) {
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }
            int leftDist = kthAncestor(root.left, n, k);
            int rightDist = kthAncestor(root.right, n, k);
            if (leftDist == -1 && rightDist == -1) {
                return -1;
            }
            int max = Math.max(leftDist, rightDist);
            if (max+1 == k) {
                System.out.println(root.data);
            }
            return max+1;
        }

        public static int sumTree(Node root) {
            if (root == null) {
                return 0;
            }
            int leftsum = sumTree(root.left);
            int rightsum = sumTree(root.right);
            int data = root.data;
            root.data = leftsum + rightsum;
            return data + root.data;
        }

        public static boolean isUnivalued(Node root) {
            if (root == null) {
                return true;
            }
        
            if (root.left != null && root.left.data != root.data) {
                return false;
            }
        
            if (root.right != null && root.right.data != root.data) {
                return false;
            }
 
            return isUnivalued(root.left) && isUnivalued(root.right);
        }

        public static void mirrorOfBT(Node root) {
            if (root == null) {
                return;
            }
            if (root.left != null && root.right == null) {
                root.right = root.left;
                root.left = null;
            }
            else if (root.right != null && root.left == null) {
                root.left = root.right;
                root.right = null;
            }
            else {
                Node temp = root.left;
                root.left = root.right;
                root.right = temp;
                mirrorOfBT(root.left);
                mirrorOfBT(root.right);
            }
        }

        public static Node deleteWithTarget(Node root, int x) {
            if (root == null) {
                return null;
            }
        
            // Recursively process the left and right subtrees
            root.left = deleteWithTarget(root.left, x);
            root.right = deleteWithTarget(root.right, x);
        
            // If the current node is a leaf and its value is equal to x, delete it
            if (root.left == null && root.right == null && root.data == x) {
                return null;
            }
        
            return root; // Return the (possibly modified) root
        }

        public static boolean isIdentical2(Node node, Node subRoot) {
            if (node == null && subRoot == null) {
                return true;
            } else if(node == null || subRoot == null || node.data != subRoot.data) {
                return false;
            }

            if (!isIdentical2(node.left, subRoot.left)) {
                return false;
            }
            if (!isIdentical2(node.right, subRoot.right)) {
                return false;
            }
            return true;
        }
        
        public static Node isSubTreesduplicate(Node root) {
            if (root == null) {
                return null;
            }
            if (root.left != null && root.right != null) {
                if (isIdentical2(root.right, root.left)) {
                    return root.left;
                }
            }
            Node leftResult = isSubTreesduplicate(root.left);
            if (leftResult != null) {
                return leftResult;
            }
            return isSubTreesduplicate(root.right)
        }

        public static int maxPathSum(Node root, int max) {  //do it at last
            if (root == null) {
                return 0;
            }
            max = Math.max(max, root.data+max);
            return Math.max(maxPathSum(root.left, max), maxPathSum(root.right, max));
        }
    }
    public static void main(String[] args) {
        // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preorder(root);
        // tree.inorder(root);
        // tree.postorder(root);
        // tree.levelOrder(root);
        // System.out.println(tree.heightOfTree(root));
        // System.out.println(tree.countOfNodes(root));
        // System.out.println(tree.sumOfNodes(root));
        //

        BinaryTree tree = new BinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        tree.levelOrder(root);
        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // // subRoot.right = new Node(5);
        // System.out.println(tree.isSubtree(root, subRoot));
        // tree.topView(root);
        // tree.kthLevel(root, 3, 1);
        // System.err.println(tree.lca2(root, 4, 6).data);
        // System.out.println(tree.minDistance(root, 4, 6));
        // tree.kthAncestor(root, 6, 2);
        // tree.sumTree(root);
        // tree.levelOrder(root);
        // if (tree.isUnivalued(root)) {
        //     System.out.println("Yes");
        // }
        // else {
        //     System.out.println("No");
        // }
        // tree.mirrorOfBT(root);
        // tree.levelOrder(root);
        root = tree.deleteWithTarget(root, 3);
        tree.levelOrder(root);
    }
}
