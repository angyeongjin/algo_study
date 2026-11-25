class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            if (prefixSum - k == 0) {
                result += 1;
            }
            if (map.containsKey(prefixSum - k)) {
                result += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}
