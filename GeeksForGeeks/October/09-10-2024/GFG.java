lass Solution {
    static Node construct(int mat[][]) {
        int n = mat.length;
        if (n == 0) return null;
        
        // Create a 2D array to store the linked list nodes.
        Node[][] nodeMatrix = new Node[n][n];
        
        // Step 1: Initialize all nodes based on the matrix.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nodeMatrix[i][j] = new Node(mat[i][j]);
            }
        }
        
        // Step 2: Link the nodes with right and down pointers.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Link to the right node.
                if (j + 1 < n) {
                    nodeMatrix[i][j].right = nodeMatrix[i][j + 1];
                }
                
                // Link to the down node.
                if (i + 1 < n) {
                    nodeMatrix[i][j].down = nodeMatrix[i + 1][j];
                }
            }
        }
        
        // Step 3: Return the head of the linked list (top-left corner node).
        return nodeMatrix[0][0];
    }
}
