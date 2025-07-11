public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // Create a 2D DP array where dp[i][j] represents if s[0...i-1] matches p[0...j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Handle patterns with '*' that can match empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];  // '*' can match 0 of the preceding character
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current characters match or there's a '.', we can carry over the previous result
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If there's a '*' in the pattern
                else if (p.charAt(j - 1) == '*') {
                    // Case 1: Treat '*' as matching 0 of the preceding element
                    dp[i][j] = dp[i][j - 2];
                    // Case 2: Treat '*' as matching 1 or more of the preceding element
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        // The answer is whether the entire string s matches the entire pattern p
        return dp[m][n];
    }
}
