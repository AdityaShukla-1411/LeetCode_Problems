public class Solution {
    public String intToRoman(int num) {
        // Roman numeral symbols and their values in descending order
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder result = new StringBuilder();
        
        // Process the number by subtracting from the largest value
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);  // Append the Roman numeral symbol
                num -= values[i];           // Subtract the value from the number
            }
        }
        
        return result.toString();
    }
}
