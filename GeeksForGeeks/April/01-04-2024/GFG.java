class Solution {
    public int pairsViolatingBST(int n, Node root) {
        List<Integer> inorderTraversal = new ArrayList<>();
        inorder(root, inorderTraversal);
        int[] temp = new int[n];
        return mergeSort(0, n - 1, inorderTraversal, temp);
    }

    private void inorder(Node root, List<Integer> inorderTraversal) {
        if (root != null) {
            inorder(root.left, inorderTraversal);
            inorderTraversal.add(root.data);
            inorder(root.right, inorderTraversal);
        }
    }

    private int merge(int low, int mid, int high, List<Integer> arr, int[] output) {
        int i = low, j = mid + 1;
        int k = low;
        int inversions = 0;

        while (i <= mid && j <= high) {
            if (arr.get(i) <= arr.get(j))
                output[k++] = arr.get(i++);
            else {
                output[k++] = arr.get(j++);
                inversions += (mid - i + 1);
            }
        }

        while (i <= mid)
            output[k++] = arr.get(i++);
        while (j <= high)
            output[k++] = arr.get(j++);

        for (i = low; i <= high; ++i)
            arr.set(i, output[i]);

        return inversions;
    }

    private int mergeSort(int low, int high, List<Integer> arr, int[] output) {
        int inversions = 0;

        if (low < high) {
            int mid = (low + high) / 2;

            inversions += mergeSort(low, mid, arr, output);
            inversions += mergeSort(mid + 1, high, arr, output);
            inversions += merge(low, mid, high, arr, output);
        }

        return inversions;
    }
}
