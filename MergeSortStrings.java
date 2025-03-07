public class MergeSortStrings {
    public static void divide(String[] arr, int si, int ei) {
        if (si>=ei) {
            return;
        }
        int mid = si + ((ei-si)/2);
        divide(arr, si, mid);
        divide(arr, mid+1, ei);
        merge(arr,si,ei,mid);
    }
    public static void merge(String[] arr, int si, int ei, int mid) {
        String[] temp = new String[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        while (i<=mid && j<=ei) {
            if (arr[i].compareTo(arr[j])<0) {
                temp[k++] = arr[i++]; 
            }
            else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for ( k = 0, i=si; k < temp.length; k++,i++) {
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        String[] arr = {"sun", "earth", "mars", "mercury"};
        divide(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
