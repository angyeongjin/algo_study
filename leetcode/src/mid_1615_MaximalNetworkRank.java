import java.util.*;

class mid_1615_MaximalNetworkRank {

    public static void main(String[] args) {
        int n = 6;
        int[][] roads = {{0,1}, {0,3},{1,2},{1,3},{2,3},{2,4}};
        System.out.println(maximalNetworkRank(n, roads));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        int answer = 0;
        boolean[][] graph = new boolean[n][n];
        int[] arr = new int[n];

        for (int[] road : roads) {
            arr[road[0]]++;
            arr[road[1]]++;

            graph[road[0]][road[1]] = true;
            graph[road[1]][road[0]] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int rank = arr[i] + arr[j] + (graph[i][j] ? -1 : 0);
                answer = Math.max(answer, rank);
            }
        }

        return answer;
    }
}
