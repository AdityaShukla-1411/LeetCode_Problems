class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1); // Ensuring binary search on the smaller array
        }
        //apply B.S for array 1 by keeping array 1 with less no. of elements
        int low = 0, high = m;
        while (low <= high) {
            int partitionX = (low + high) / 2;// mid from array1
            int partitionY = (m + n + 1) / 2 - partitionX;//mid from array 2
            // left part array 1 and array 2 elements
            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            //right part array 1 and array 2 elements
            int minX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            int minY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxX <= minY && maxY <= minX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                } else {
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return -1.0; // Edge case, should never be reached in a valid input
    }
}