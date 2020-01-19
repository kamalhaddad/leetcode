class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                sum[i + 1][j + 1] = sum[i+1][j] + sum[i][j+1] - sum[i][j] + mat[i][j];
            }
        }
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                ans[i][j] = sum[Math.min(m, i+K+1)][Math.min(n, j+K+1)] - sum[Math.max(0, i-K)][Math.min(n, j + K+ 1)] - sum[Math.min(m, i+K+1)][Math.max(0, j-K)] + sum[Math.max(0, i-K)][Math.max(0, j - K)];

            
            }
        }
        return ans;
    }
}