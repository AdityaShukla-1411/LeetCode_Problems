import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        // Map for Roman numeral values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prev = 0;

        // Traverse the Roman string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = romanMap.get(s.charAt(i));
            
            // If current value is smaller than previous, subtract it
            if (curr < prev) {
                total -= curr;
            } else {
                total += curr;
            }

            prev = curr;
        }

        return total;
    }
}
