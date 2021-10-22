package level3;

import java.util.*;

public class 경주로건설 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int[][] dp = new int[board.length][board[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 10_000_000);
        }
        dp[0][0] = 0;
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        Queue<Road> q = new LinkedList<>();
        q.offer(new Road(0, 0, -1, 0));
        while(!q.isEmpty()) {
            Road r = q.poll();
            for (int i = 0; i < 4; i++) {
                int ty = r.y + dy[i];
                int tx = r.x + dx[i];
                if (0 > ty || ty >= board.length || 0 > tx || tx >= board[0].length) continue;
                if (board[ty][tx] == 1) continue;
                if (dp[ty][tx] + 500 < r.cost + 100+(i!=r.dir&&r.dir!=-1?500:0)) continue;
                if (dp[ty][tx] >= r.cost + 100+(i!=r.dir&&r.dir!=-1?500:0))
                    dp[ty][tx] = r.cost + 100+(i!=r.dir&&r.dir!=-1?500:0);
                q.offer(new Road(ty, tx, i, r.cost + 100+(i!=r.dir&&r.dir!=-1?500:0)));
            }

        }
        answer = dp[dp.length-1][dp[0].length-1];
        return answer;
    }

    static class Road {
        int y;
        int x;
        int dir;
        int cost;

        public Road(int y, int x, int dir, int cost) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cost = cost;
        }
    }
}
