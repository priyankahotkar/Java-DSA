import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Integer, List<Integer>> invs = new HashMap<>();

    public long countInversions(int[] arr) {
        return divide(arr, 0, arr.length - 1);
    }

    public long divide(int[] arr, int start, int end) {
        if (start >= end)
            return 0;

        int mid = start + (end - start) / 2;
        long left = divide(arr, start, mid);
        long right = divide(arr, mid + 1, end);
        long mergeCount = merge(arr, start, mid, end);

        return left + right + mergeCount;
    }

    public long merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        long inversions = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                inversions += (mid - i + 1);
                for (int x = i; x <= mid; x++) {
                    invs.putIfAbsent(x, new ArrayList<>());
                    invs.get(x).add(j);
                }
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

        return inversions;
    }
}
