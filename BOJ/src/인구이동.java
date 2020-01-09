import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 인구이동 {
	static int[][] field;
	static boolean[][] visited;
	static boolean[][] visited2;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int L;
	static int R;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		field = new int[n][n];
		visited = new boolean[n][n];
		visited2 = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean flag = false;
		int moveCnt = 0;
		while (true) {
			flag = false;
			for (int k = 0; k < n; k++)
				Arrays.fill(visited[k], false);
			for (int k = 0; k < n; k++)
				Arrays.fill(visited2[k], false);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (isShared(i, j) && !visited[i][j]) {
						flag = true;
						cnt = 0;
						int sum = dfs1(i, j, 0);
						int avg = sum / cnt;
						dfs2(i, j, avg);
					}
				}
			}
			if (!flag)
				break;
			moveCnt++;
		}
		System.out.println(moveCnt);
	}

	private static boolean isShared(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
				int diff = Math.abs(field[y][x] - field[ty][tx]);
				if (L <= diff && diff <= R && !visited[ty][tx]) {
					return true;
				}
			}
		}
		return false;
	}

	private static int dfs1(int y, int x, int sum) {
		visited[y][x] = true;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
				int diff = Math.abs(field[y][x] - field[ty][tx]);
				if (L <= diff && diff <= R && !visited[ty][tx]) {
					sum = dfs1(ty, tx, sum);
				}
			}
		}
		return sum += field[y][x];
	}

	private static void dfs2(int y, int x, int avg) {
		visited2[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
				int diff = Math.abs(field[y][x] - field[ty][tx]);
				if (L <= diff && diff <= R && !visited2[ty][tx]) {
					dfs2(ty, tx, avg);
				}
			}
		}
		field[y][x] = avg;
	}
}
