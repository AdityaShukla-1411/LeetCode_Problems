class Solution {
    public String convert(String s, int numRows) {
        // If there's only one row or the string length is less than numRows, return the original string
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        
        // Initialize a list to hold the rows
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        
        int currentRow = 0;
        boolean goingDown = false;
        
        // Traverse the string
        for (char c : s.toCharArray()) {
            // Add character to the current row
            rows.get(currentRow).append(c);
            
            // Change direction if we reach the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move up or down to the next row
            currentRow += goingDown ? 1 : -1;
        }
        
        // Combine all rows into a single string and return
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}
