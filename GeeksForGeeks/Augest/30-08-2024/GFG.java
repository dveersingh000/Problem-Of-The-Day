class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
         ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        int[] queens = new int[n]; // `queens[i]` is the row index of the queen in the i-th column.
        solveNQueens(0, n, queens, results);
        return results;
    }

    private void solveNQueens(int col, int n, int[] queens, ArrayList<ArrayList<Integer>> results) {
        if (col == n) {
            // All queens are placed, add the current solution to the results
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(queens[i] + 1); // Converting 0-based index to 1-based index
            }
            results.add(solution);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isValid(row, col, queens)) {
                queens[col] = row; // Place queen
                solveNQueens(col + 1, n, queens, results);
                // Backtrack: No need to explicitly remove the queen; the next iteration will overwrite
            }
        }
    }

    private boolean isValid(int row, int col, int[] queens) {
        for (int i = 0; i < col; i++) {
            // Check if a queen is in the same row or on the same diagonal
            if (queens[i] == row || Math.abs(queens[i] - row) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }
}
