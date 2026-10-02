import java.util.*;

class Solution {

    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int freshOrangeCnt = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) freshOrangeCnt++;
                else if (grid[i][j] == 2) q.add(new int[] {i, j});
            }
        }

        int result = 0;

        while(!q.isEmpty()) {
            int k = q.size();
            for (int j = 0; j < k; ++j) {
                int[] dir = q.poll();
                for (int i = 0; i < 4; ++i) {
                    int ty = dir[0] + dy[i];
                    int tx = dir[1] + dx[i];
                    if (ty < 0 || ty >= m || tx < 0 || tx >= n) continue;
                    if (grid[ty][tx] == 1) {
                        freshOrangeCnt--;
                        grid[ty][tx] = 2;
                        q.add(new int[] {ty, tx});
                    }
                }
            }
            if (!q.isEmpty()) result++;
        }
        if (freshOrangeCnt != 0) return -1;
        return result;
    }
}
