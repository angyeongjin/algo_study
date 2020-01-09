import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바이러스 {
	static int cnt = 0;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] computer = new int[n+1][n+1];
		visited = new boolean[n+1];
		int m = Integer.parseInt(br.readLine());

		String[] str;
		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int y = Integer.parseInt(str[0]);
			int x = Integer.parseInt(str[1]);
			computer[y][x] = 1;
			computer[x][y] = 1;
		}
		visited[1] = true;
		dfs(computer, 1);
		System.out.println(cnt);
	}

	private static void dfs(int[][] computer, int start) {
		for (int i = 1; i < computer[0].length; i++) {
			if (!visited[i] && computer[start][i] == 1) {
				visited[i] = true;
				cnt++;
				dfs(computer, i);
			}
		}
	}
}
