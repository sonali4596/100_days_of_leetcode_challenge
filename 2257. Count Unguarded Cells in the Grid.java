//2257. Count Unguarded Cells in the Grid

class Solution {
    int m, n;
    int[][] grid;
    boolean[][] seen;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        this.m = m; this.n = n;
        grid = new int[m][n];
        seen = new boolean[m][n];

        // 1 = wall, 2 = guard
        for (int[] w : walls)  grid[w[0]][w[1]] = 1;
        for (int[] g : guards) grid[g[0]][g[1]] = 2;

        // DFS from each guard in 4 straight directions
        for (int[] g : guards) {
            int r = g[0], c = g[1];
            for (int d = 0; d < 4; d++) {
                dfs(r, c, d);  // pass the direction
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0 && !seen[i][j])
                    ans++;

        return ans;
    }

    void dfs(int r, int c, int dir) {
        int nr = r + dr[dir];
        int nc = c + dc[dir];

        // Stop on boundaries, walls, or other guards
        if (nr < 0 || nr >= m || nc < 0 || nc >= n) return;
        if (grid[nr][nc] == 1 || grid[nr][nc] == 2) return;

        seen[nr][nc] = true;

        dfs(nr, nc, dir); // continue only in the same direction
    }
}
