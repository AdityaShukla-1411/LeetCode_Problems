class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Step 1: Preprocess the string
        StringBuilder sb = new StringBuilder();
        sb.append("^");  // Start sentinel
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        sb.append("#$");  // End sentinel
        String t = sb.toString();

        int n = t.length();
        int[] p = new int[n];  // Array to store radius of palindromes
        int center = 0, right = 0;

        // Step 2: Manacher's core algorithm
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Try to expand the palindrome centered at i
            //NAIVE APPROACH PART 
            while (t.charAt(i + (p[i] + 1)) == t.charAt(i - (p[i] + 1))) {
                p[i]++;
            }

            // Update center and right boundary if expanded beyond current right
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // Step 3: Find the longest palindrome in p[]
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        // Step 4: Extract the original substring
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}