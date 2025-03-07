public class SegmentTrees {
    static int tree[];

    public static void init(int n) {
        tree = new int[4*n];
    }

    public static int buildST(int arr[], int sti, int si, int ei) { //O(n)
        if (si == ei) {
            return tree[sti] = arr[si];
        }
        int mid = (si+ei)/2;
        int l = buildST(arr, 2*sti+1, si, mid);
        int r = buildST(arr, 2*sti+2, mid+1, ei);
        return tree[sti] = l+r;
    }

    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {   //O(logn)
        if (qj <= si || qi >= sj) { //non overlapping
            return 0;
        } else if(si >= qi && sj <= qj) {   //complete overlap
            return tree[i];
        } else {    //partial overlap
            int mid = (si+sj)/2;
            int left = getSumUtil(2*i+1, si, mid, qi, qj);
            int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }

    public static int getSum(int arr[], int qi, int qj) {   
        int n = arr.length;
        return getSumUtil(0, 0, n-1, qi, qj);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int diff) {   //O(logn)
        if (idx < si || idx > sj) {
            return;
        }
        tree[i] += diff;
        if (si != sj) { //non-leaf
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }

    public static void update(int arr[], int newValue, int idx) {   
        int n = arr.length;
        int diff = newValue - arr[idx];
        arr[idx] = newValue;
        updateUtil(0, 0, n-1, idx, diff);
    }

    public static int buildST2(int arr[], int sti, int si, int ei) { //O(n)
        if (si == ei) {
            return tree[sti] = arr[si];
        }
        int mid = (si+ei)/2;
        int l = buildST2(arr, 2*sti+1, si, mid);
        int r = buildST2(arr, 2*sti+2, mid+1, ei);
        return tree[sti] = Math.max(l, r);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {   //O(logn)
        if (qj <= si || qi >= sj) { //non overlapping
            return Integer.MIN_VALUE;
        } else if(si >= qi && sj <= qj) {   //complete overlap
            return tree[i];
        } else {    //partial overlap
            int mid = (si+sj)/2;
            int left = getMaxUtil(2*i+1, si, mid, qi, qj);
            int right = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(left, right);
        }
    }

    public static int getMax(int arr[], int qi, int qj) {   
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }

    public static void updateUtil2(int i, int si, int sj, int idx, int newValue) {   //O(logn)
        if (idx < si || idx > sj) {
            return;
        }
        if (si == sj) {
            tree[i] = newValue;
            return;
        }
        if (si != sj) { //non-leaf
            int mid = (si+sj)/2;
            updateUtil2(2*i+1, si, mid, idx, newValue);
            updateUtil2(2*i+2, mid+1, sj, idx, newValue);
            tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
        }
    }

    public static void update2(int arr[], int newValue, int idx) {   
        int n = arr.length;
        arr[idx] = newValue;
        updateUtil2(0, 0, n-1, idx, newValue);
    }

    public static void main(String[] args) {
        // int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        // int n = arr.length;

        // init(n);
        // System.out.println(buildST(arr, 0, 0, n-1));

        // for (int i = 0; i < 2*n-1; i++) {
        //     System.out.print(tree[i]+" ");
        // }
        // System.out.println();

        // System.out.println(getSum(arr, 2, 5));

        // update(arr, 2, 2);

        // for (int i = 0; i < tree.length; i++) {
        //     System.out.print(tree[i]+" ");
        // }
        // System.out.println();

        // System.out.println(getSum(arr, 2, 5));

        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;
        init(n);
        System.out.println(buildST2(arr, 0, 0, n-1));

        for (int i = 0; i < 2*n-1; i++) {
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        System.out.println(getMax(arr, 5, 8));

        update2(arr, 0, 4);
        for (int i = 0; i < 2*n-1; i++) {
            System.out.print(tree[i]+" ");
        }
        System.out.println();
    }
}
