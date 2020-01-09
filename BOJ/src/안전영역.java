import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안전영역 {
	static int[][] field;
	static boolean[][] visited;
	static int height;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		field = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int maxCnt = 0;
		height = 0;
		while(true) {
			for (int i = 0; i < n; i++)
				Arrays.fill(visited[i], false);
			int cnt = 0;
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (field[i][j] > height && !visited[i][j]) {
						visited[i][j] = true;
						dfs(i, j);
						cnt++;
						flag = true;
					}
				}
			}
			
			if (maxCnt < cnt)
				maxCnt = cnt;
			
			if (!flag)
				break;
			height++;
		}
		
		System.out.println(maxCnt);
	}

	private static void dfs(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			
			if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
				if (field[ty][tx] > height && !visited[ty][tx]) {
					visited[ty][tx] = true;
					dfs(ty, tx);
				}
			}
		}
	}
}
