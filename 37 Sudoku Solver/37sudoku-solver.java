class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // If the current cell is empty
                if (board[i][j] == '.') {
                    // Try digits from '1' to '9'
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            // Place the number
                            board[i][j] = num;
                            // Recurse to the next cell
                            if (backtrack(board)) {
                                return true;
                            }
                            // Undo the move (backtrack)
                            board[i][j] = '.';
                        }
                    }
                    // If no valid number found, trigger backtracking
                    return false;
                }
            }
        }
        // If the entire board is filled successfully
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check row and column
        for (int index = 0; index < 9; index++) {
            if (board[row][index] == num || board[index][col] == num) {
                return false;
            }
        }

        // Check 3x3 sub-grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
