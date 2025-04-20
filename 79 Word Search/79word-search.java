import java.util.*;

class Solution {
    int m, n;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        m = board.length;      // Number of rows
        n = board[0].length;   // Number of columns

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && wordFound(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean wordFound(char[][] board, int i, int j, String word, int ptr) {
        // Goal state: all characters matched
        if (ptr >= word.length()) {
            return true;
        }

        // Out-of-bound or character mismatch
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(ptr)) {
            return false;
        }

        // Mark current cell as visited
        char temp = board[i][j];
        board[i][j] = '.';

        // Explore all 4 directions
        for (int[] d : dir) {
            int row = i + d[0];
            int col = j + d[1];

            if (wordFound(board, row, col, word, ptr + 1)) {
                return true;
            }
        }

        // Undo the visit
        board[i][j] = temp;
        return false;
    }
}
