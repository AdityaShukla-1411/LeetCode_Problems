class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Find the middle index

            if (nums[mid] == target) {
                return mid;  // If target is found, return the index
            } else if (nums[mid] < target) {
                left = mid + 1;  // Move the left pointer to the right half
            } else {
                right = mid - 1;  // Move the right pointer to the left half
            }
        }

        // If target is not found, return the index where it should be inserted
        return left;
    }
}
