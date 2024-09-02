class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int[][] cost = new int[n][n];
        
        // Directions array for 4 possible moves (right, left, down, up).
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        // Priority queue to store the cell with its cost, sorted by cost.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Initializing the cost array with maximum values.
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Starting from the top-left cell with its initial cost.
        cost[0][0] = grid[0][0];
        pq.offer(new int[]{grid[0][0], 0, 0}); // {cost, x, y}
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCost = current[0];
            int x = current[1];
            int y = current[2];
            
            // If we reached the bottom-right cell, return the cost.
            if (x == n - 1 && y == n - 1) {
                return currentCost;
            }
            
            // Explore all 4 possible directions.
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                // Check if new position is within the grid bounds.
                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    int newCost = currentCost + grid[newX][newY];
                    
                    // If a cheaper cost is found, update and add to the queue.
                    if (newCost < cost[newX][newY]) {
                        cost[newX][newY] = newCost;
                        pq.offer(new int[]{newCost, newX, newY});
                    }
                }
            }
        }
        
        // If for some reason the bottom-right cell is not reached, return -1.
        return -1;
    }
}
