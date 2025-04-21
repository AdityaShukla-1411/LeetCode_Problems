class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Initialize a set to store characters in the current window
        Set<Character> set = new HashSet<>();
        
        int left = 0;  // Left pointer of the window
        int maxLength = 0;  // Variable to store the maximum length of the substring
        
        // Iterate over the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            // If the character at 'right' is in the set, shrink the window from the left
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Add the character at 'right' to the set
            set.add(s.charAt(right));
            
            // Update the max length of the substring without duplicate characters
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
