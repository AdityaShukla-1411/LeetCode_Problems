class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;  // Pointer to keep track of elements not equal to val
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {  // If current element is not equal to val
                nums[k] = nums[i];  // Place it in the correct position
                k++;  // Increment the position for the next unique element
            }
        }
        
        return k;  // Return the count of elements that are not equal to val
    }
}
