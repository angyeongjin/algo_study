import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정사각형방 {
	static int[][] field;
	static int[][] visited;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static int maxCnt; // = 0;
	static int maxNumber; // = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			field = new int[n][n];
			visited = new int[n][n];
			for (int i = 0; i < n; i++)
				Arrays.fill(visited[i], 1);
			maxCnt = 0;
			maxNumber = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cnt = dfs(i, j);
					if (maxCnt < cnt) {
						maxCnt = cnt;
						maxNumber = field[i][j];
					}
					else if (maxCnt == cnt && maxNumber > field[i][j]) {
						maxNumber = field[i][j];
					}
				}
			}

			System.out.println("#" + ti + " " + maxNumber + " " + maxCnt);
		}
	}

	private static int dfs(int y, int x) {
		if (visited[y][x] == 1) {
			for (int i = 0; i < 4; i++) {
				int ty = y + dy[i];
				int tx = x + dx[i];
				if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
					if (field[ty][tx]-1 == field[y][x]) {
						int c = dfs(ty, tx) + 1;
						visited[y][x] = visited[y][x] < c ? c : visited[y][x];
					}
				}
			}
		}
		return visited[y][x];
	}
}
