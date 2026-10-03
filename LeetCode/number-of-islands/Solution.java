class Solution {

    int[] dy = {0, 0, -1, 1};
    int[] dx = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    dfs(i, j, m, n, grid);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(int y, int x, int m, int n, char[][] grid) {
        grid[y][x] = '2';
        for (int i = 0; i < 4; ++i) {
            int ty = y + dy[i];
            int tx = x + dx[i];
            if (ty < 0 || ty >= m || tx < 0 || tx >= n) continue;
            if (grid[ty][tx] == '1') dfs(ty, tx, m, n, grid);
        }
    }
}
