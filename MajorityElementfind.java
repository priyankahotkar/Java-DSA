public class MajorityElementfind {
    public static int majorityElement(int[] arr, int si , int ei) {
        if (si==ei) {
           return arr[si]; 
        }
        int mid = si + ((ei-si)/2);
        int leftMajor = majorityElement(arr, si, mid);
        int rightMajor = majorityElement(arr, mid+1, ei);
        if (leftMajor == rightMajor) {
            return leftMajor;
        }
        else {
            int leftfreq = frequency(arr, si, ei, leftMajor);
            int rightfreq = frequency(arr, si, ei, rightMajor);
            if (leftfreq>rightfreq) {
                return leftMajor;
            }
            else{
                return rightMajor;
            }
        }
    }
    public static int frequency(int[] arr, int si, int ei, int ele) {
        int count = 0;
        for (int i = si; i <= ei; i++) {
            if (arr[i] == ele) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println(majorityElement(nums1, 0, nums1.length - 1));  // Output: 3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums2, 0, nums2.length - 1));  // Output: 2
    }
}
