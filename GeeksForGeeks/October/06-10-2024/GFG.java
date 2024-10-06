class Solution {
    // Directions to move in 8 possible ways (up, down, left, right and diagonals)
    private static final int[] rowDirection = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colDirection = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int n = grid.length;    // number of rows
        int m = grid[0].length; // number of columns
        int islandCount = 0;    // to store the number of islands
        
        // Loop over every cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the cell is '1' (land), it's a part of an island
                if (grid[i][j] == '1') {
                    // Start DFS to visit all cells in this island iteratively
                    iterativeDFS(grid, i, j, n, m);
                    // After finishing DFS, we have found one island
                    islandCount++;
                }
            }
        }
        
        return islandCount;
    }
    
    // Iterative DFS to explore all connected land cells (1s)
    private void iterativeDFS(char[][] grid, int row, int col, int n, int m) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {row, col});
        
        // Mark the starting cell as visited by setting it to '0'
        grid[row][col] = '0';
        
        // Process the stack until it's empty
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int curRow = current[0];
            int curCol = current[1];
            
            // Explore all 8 possible directions
            for (int i = 0; i < 8; i++) {
                int newRow = curRow + rowDirection[i];
                int newCol = curCol + colDirection[i];
                
                // Check if the new cell is within bounds and is land ('1')
                if (isValid(newRow, newCol, n, m) && grid[newRow][newCol] == '1') {
                    // Mark the cell as visited and push it onto the stack
                    grid[newRow][newCol] = '0';
                    stack.push(new int[] {newRow, newCol});
                }
            }
        }
    }
    
    // Helper function to check if the cell is within the grid bounds
    private boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
