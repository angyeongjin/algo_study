import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 해밀턴순환회로 {
	static int[][] graph;
	static int[][] dp;
	static int MAX_INT = 100000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		dp = new int[n][1<<n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], -1);
		System.out.println(tsp(0, 1<<0));
	}

	private static int tsp(int curr, int bit) {
		if (dp[curr][bit] != -1) return dp[curr][bit];
		if (bit == (1<<graph.length)-1) {
			// 다 방문 했을 경우
			return dp[curr][bit] = graph[curr][0] != 0 ? graph[curr][0] : MAX_INT;
		}
		dp[curr][bit] = MAX_INT;
		for (int i = 0; i < graph.length; i++) {
			if (graph[curr][i] != 0 && (bit&(1<<i)) == 0) {
				dp[curr][bit] = Math.min(dp[curr][bit], graph[curr][i] + tsp(i, bit|(1<<i)));
			}
		}
		return dp[curr][bit];
	}
}
