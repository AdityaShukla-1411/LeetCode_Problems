public class Solution {
    public int myAtoi(String s) {
        // Define constants for 32-bit signed integer limits
        int INT_MIN = Integer.MIN_VALUE;
        int INT_MAX = Integer.MAX_VALUE;

        // Trim leading whitespaces
        s = s.trim();
        
        // If the string is empty after trimming, return 0
        if (s.isEmpty()) {
            return 0;
        }

        // Initialize the sign and result
        int sign = 1;
        int result = 0;
        int i = 0;

        // Check for optional sign
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Process the digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // Check for overflow/underflow
            if (result > (INT_MAX - digit) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }

            result = result * 10 + digit;
            i++;
        }

        // Apply the sign
        return sign * result;
    }
}
