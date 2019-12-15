class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length; int m = mat[0].length;
        int[][] prefixSum = new int[mat.length + 1][mat[0].length + 1];
        
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j] + mat[i][j];
            }
        }
        
        
        
        int max = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                for(int k = 1; k <= Math.min(n - i, m - j); ++k) {
                    int sum = prefixSum[i + k][j + k] - prefixSum[i + k][j] - prefixSum[i][j + k] + prefixSum[i][j];
                    if(sum <= threshold) max = Math.max(k, max);
                    if(sum > threshold) break;
                }
            }
        }
        return max;
    }
}