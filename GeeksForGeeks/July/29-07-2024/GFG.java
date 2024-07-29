class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return -1;
        }
        
        int n = arr.length;
        int m = arr[0].length;
        int maxRowIndex = -1;
        int maxCount = 0;
        
        // Start from the top-right corner
        int row = 0;
        int col = m - 1;
        
        while (row < n && col >= 0) {
            // Move left if current element is 1
            if (arr[row][col] == 1) {
                int count = m - col; // Number of 1s in this row
                if (count > maxCount) {
                    maxCount = count;
                    maxRowIndex = row;
                }
                col--; // Move left
            } else {
                row++; // Move down
            }
        }
        
        return maxRowIndex;
    }
}
