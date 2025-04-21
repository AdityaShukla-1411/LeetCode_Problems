import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to handle duplicates
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for the 'i' position
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the 'left' and 'right' positions
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move the pointers
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // Need a larger sum, so move the left pointer to the right
                } else {
                    right--; // Need a smaller sum, so move the right pointer to the left
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[] {0, 1, 1}));
        System.out.println(solution.threeSum(new int[] {0, 0, 0}));
    }
}
