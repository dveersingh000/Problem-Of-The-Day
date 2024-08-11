class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Sort jobs in descending order of profit
        Arrays.sort(arr, new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j2.profit - j1.profit;
            }
        });

        // Find the maximum deadline
        int maxDeadline = 0;
        for (Job job : arr) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Create an array to keep track of free time slots
        boolean[] slot = new boolean[maxDeadline + 1];
        int maxProfit = 0;
        int countJobs = 0;

        // Iterate through all jobs
        for (Job job : arr) {
            // Find a free slot for this job (we check from the last possible slot)
            for (int j = Math.min(maxDeadline, job.deadline); j > 0; j--) {
                if (!slot[j]) {
                    // Assign this job to this slot
                    slot[j] = true;
                    maxProfit += job.profit;
                    countJobs++;
                    break;
                }
            }
        }

        return new int[]{countJobs, maxProfit};
    }
}
