class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueIndex = 1;  // Pointer to track the unique position in the array

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {  // If current element is different from previous
                nums[uniqueIndex] = nums[i];  // Place it at the unique index
                uniqueIndex++;  // Move the pointer forward
            }
        }

        return uniqueIndex;  // The count of unique elements
    }
}
