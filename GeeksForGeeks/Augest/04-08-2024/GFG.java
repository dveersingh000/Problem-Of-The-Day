class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
           int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        
        // Sort meetings by end time
        Arrays.sort(meetings, new Comparator<int[]>() {
            public int compare(int[] m1, int[] m2) {
                return Integer.compare(m1[1], m2[1]);
            }
        });

        // Select meetings
        int count = 0;
        int lastEndTime = -1;
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] > lastEndTime) {
                count++;
                lastEndTime = meetings[i][1];
            }
        }

        return count;
    }
}
