import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If the complement exists in map, return indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store the number with its index
            map.put(nums[i], i);
        }

        // If no solution is found (problem guarantees one)
        return new int[] {};
    }
}
