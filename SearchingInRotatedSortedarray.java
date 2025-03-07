public class SearchingInRotatedSortedarray {
    public static int searchElement(int[] arr, int si, int ei, int target) {
        if (si > ei) {
            return -1;
        }
        int mid = si + ((ei - si) / 2);
        if (target==arr[mid]) {
            return mid;
        }
        if (arr[mid]>arr[si]) {
            if (arr[si]<=target && target<arr[mid]) {
                return searchElement(arr, si, mid-1, target);
            }
            else {
                return searchElement(arr, mid+1, ei, target);
            }
        }
        else {
            if (arr[mid]<target && target<=arr[ei]) {
                return searchElement(arr, mid+1, ei, target);
            }
            else {
                return searchElement(arr, si, mid-1, target);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int tarIdx = searchElement(arr, 0, arr.length-1, 0);
        System.out.println(tarIdx);
    }
}
