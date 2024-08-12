class KthLargest {
    private PriorityQueue<Integer> minQ;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minQ = new PriorityQueue<>(k);
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        minQ.offer(val);
        if (minQ.size() > k) {
            minQ.poll();
        }
        return minQ.peek();
    }
}
