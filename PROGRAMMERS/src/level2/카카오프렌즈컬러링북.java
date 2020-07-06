package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        for (int i = 0; i < picture.length; i++) {
            System.out.println(Arrays.toString(picture[i]));
        }
        System.out.println(Arrays.toString(solution(6, 4, picture)));
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) { // 영역이 있을 때
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(m, n, i, j, picture, visited));
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static int bfs(int m, int n, int startY, int startX, int[][] picture, boolean[][] visited) {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        int data = picture[startY][startX];
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        visited[startY][startX] = true;
        q.offer(new int[] {startY, startX});
        while(!q.isEmpty()) {
            int[] idx = q.poll();
            for (int i = 0; i < 4; i++) {
                int ty = idx[0] + dy[i];
                int tx = idx[1] + dx[i];
                if (0 > ty || ty >= m || 0 > tx || tx >= n) continue;
                if (visited[ty][tx]) continue;
                if (picture[ty][tx] == 0) continue;
                if (picture[ty][tx] != data) continue;
                // 로직
                cnt++;
                visited[ty][tx] = true;
                q.offer(new int[] {ty, tx});
            }
        }
        return cnt;
    }

}
