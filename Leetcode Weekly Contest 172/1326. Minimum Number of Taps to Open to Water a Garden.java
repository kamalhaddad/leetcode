class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] dp = new int[n + 1][2];
        for(int i = 0; i <= n; ++i) {
            dp[i][0] = Math.max(0, i - ranges[i]);
            dp[i][1] = Math.min(n, i + ranges[i]);
        }
        int res = 0;
        Arrays.sort(dp, (a,b) ->  a[0] - b[0]);
        
        for (int i = 0, st = 0, end = 0; st < n; st = end, ++res) {
            for (; i < dp.length && dp[i][0] <= st; ++i) {
                end = Math.max(end, dp[i][1]);
            }
            if (st == end) return -1;
        }
        return res;
            
    }
}