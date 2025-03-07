class Solution {
    public int findKthLargest(int[] nums, int k) {
        int targetIdx = nums.length - k;
        return quickSelect(nums,0,nums.length-1,targetIdx);
    }
    public int quickSelect(int[] nums, int si, int ei, int targetIdx) {
        int pIdx = partition(nums,si,ei);
        if(targetIdx == pIdx) {
            return nums[pIdx];
        }
        else if(targetIdx < pIdx) {
            return quickSelect(nums,si,pIdx-1,targetIdx);
        }
        else {
            return quickSelect(nums,pIdx+1,ei,targetIdx);
        }
    }
    public int partition(int[] nums, int si,  int ei) {
        int pivot = nums[ei];
        int i = si-1; //to make place smaller than pivot
        for (int j = si; j < ei; j++) {
            if (nums[j] <= pivot) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        nums[ei] = nums[i];
        nums[i] = temp;
        return i;
    }
}