public class InversionCount {
    public static int inversionCountOfArray(int[] arr, int si, int ei) {
        if (si >= ei) {
            return 0;
        }
        int mid = si + ((ei-si)/2);
        int leftinvcount = inversionCountOfArray(arr, si, mid);
        int rightinvcount = inversionCountOfArray(arr, mid+1, ei);
        int invcount = merge(arr, si, ei, mid);
        return leftinvcount + rightinvcount + invcount;
    }
    public static int merge(int[] arr, int si, int ei, int mid) {
        int i = si;
        int j = mid+1;
        int k = 0;
        int invcount = 0;
        int[] temp = new int[ei-si+1];
        while (i<=mid && j<=ei) {
            if (arr[i]<=arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
                invcount+= (mid-i+1);
            }
        }
        while (i<=mid) {
            temp[k++] = arr[i++];
        }
        while (j<=ei) {
            temp[k++] = arr[j++];
        }
        for ( i = si, k = 0; i <= ei; i++, k++) {
            arr[i] = temp[k];
        }
        return invcount;
    }
    public static void main(String[] args) {
        int[] arr = {1,20,6,4,5};
        int result = inversionCountOfArray(arr, 0, arr.length - 1);
        System.out.println("Number of inversions: " + result);
    }
}
