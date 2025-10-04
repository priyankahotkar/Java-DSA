class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;

        Map<Integer, Set<Integer>> setBits = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 20; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    setBits.putIfAbsent(j, new HashSet<>());

                    for (Integer idx : setBits.get(j)) {
                        map.putIfAbsent(i, new HashSet<>());
                        map.putIfAbsent(idx, new HashSet<>());
                        map.get(i).add(idx);
                        map.get(idx).add(i);
                    }

                    setBits.get(j).add(i);
                }
            }
        }

        long maxProduct = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!map.getOrDefault(i, new HashSet<>()).contains(j)) {
                    maxProduct = Math.max(maxProduct, 1L * nums[i] * nums[j]);
                }
            }
        }

        return maxProduct;
    }
}
