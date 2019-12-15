class Solution {
    
    int[][][] dp;
    public static int[][] dir = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {
        dp = new int[grid.length + 1][grid[0].length + 1][k + 1];
        for(int i = 0; i <= grid.length; ++i)
            for(int j = 0; j <= grid[0].length; ++j)
                for(int x = 0; x <= k; ++x)
                    dp[i][j][x] = -1;
        dp[0][0][k] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, k));
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int i = current.i;
            int j = current.j;
            int curr_k = current.k;
            if(i == grid.length - 1 && j == grid[0].length - 1) return dp[i][j][curr_k];
            for(int f = 0; f < dir.length; ++f) {
                int dx = i + dir[f][0];
                int dy = j + dir[f][1];
                if(dx < 0 || dx >= grid.length || dy >= grid[0].length || dy < 0) continue;
                int dk = curr_k - grid[dx][dy];
                if(dk < 0) continue;
                if(dp[dx][dy][dk] >= 0) continue;
                dp[dx][dy][dk] = 1 + dp[i][j][curr_k];
                queue.add(new Node(dx, dy, dk));
            }            
        }
        return -1;
    }
    
    private class Node {
        
        public int i;
        public int j;
        public int k;
        
        public Node(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

}