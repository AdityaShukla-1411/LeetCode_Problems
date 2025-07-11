class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        // Min-heap to store {height, {i, j}}
        PriorityQueue<int[]> boundaryCells = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        boolean[][] visited = new boolean[m][n];

        // Add boundary cells (left-most, right-most, top-most, bottom-most)
        for (int row = 0; row < m; row++) {
            boundaryCells.offer(new int[]{heightMap[row][0], row, 0});
            visited[row][0] = true;
            boundaryCells.offer(new int[]{heightMap[row][n - 1], row, n - 1});
            visited[row][n - 1] = true;
        }
        
        for (int col = 0; col < n; col++) {
            boundaryCells.offer(new int[]{heightMap[0][col], 0, col});
            visited[0][col] = true;
            boundaryCells.offer(new int[]{heightMap[m - 1][col], m - 1, col});
            visited[m - 1][col] = true;
        }

        int water = 0;
        // Directions for moving to neighbors (left, right, up, down)
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        // Process the boundary cells in the min-heap
        while (!boundaryCells.isEmpty()) {
            int[] cell = boundaryCells.poll();
            int height = cell[0];
            int r = cell[1];
            int c = cell[2];

            // Check all 4 neighbors
            for (int[] dir : directions) {
                int i = r + dir[0];
                int j = c + dir[1];

                if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                    water += Math.max(height - heightMap[i][j], 0);
                    boundaryCells.offer(new int[]{Math.max(height, heightMap[i][j]), i, j});
                    visited[i][j] = true;
                }
            }
        }

        return water;
    }
}