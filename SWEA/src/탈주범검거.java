import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거 {
	static int[][] field;
	static boolean[][] visited;
	static int[] dy = { 0, 0, 1, -1 }; // 오른쪽왼쪽아래위
	static int[] dx = { 1, -1, 0, 0 };
	static Queue<Idx> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int ti = 1; ti <= t; ti++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			field = new int[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + ti + " " + bfs(R, C, L));
		}

	}

	private static int bfs(int r, int c, int l) {
		q.clear();
		int cnt = 1;
		visited[r][c] = true;
		q.offer(new Idx(r, c));

		for (int i = 1; i < l; i++) {
			if (q.isEmpty())
				break;
			int size = q.size();
			for (int j = 0; j < size; j++) {
				Idx idx = q.poll();
				for (int k = 0; k < 4; k++) {
					int ty = idx.y + dy[k];
					int tx = idx.x + dx[k];
					if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
						if (isGo(idx.y, idx.x, ty, tx, k) && !visited[ty][tx]) {
							visited[ty][tx] = true;
							q.offer(new Idx(ty, tx));
							cnt++;
						}
					}
				}
			}
		}
		return cnt;
	}

	private static boolean isGo(int y, int x, int ty, int tx, int dir) {
		switch (dir) {
		case 0: // 오른쪽
			if ((field[y][x] == 1 || field[y][x] == 3 || field[y][x] == 4 || field[y][x] == 5)
					&& (field[ty][tx] == 1 || field[ty][tx] == 3 || field[ty][tx] == 6 || field[ty][tx] == 7))
				return true;
			break;
		case 1: // 왼쪽
			if ((field[y][x] == 1 || field[y][x] == 3 || field[y][x] == 6 || field[y][x] == 7)
					&& (field[ty][tx] == 1 || field[ty][tx] == 3 || field[ty][tx] == 4 || field[ty][tx] == 5))
				return true;
			break;
		case 2: // 아래
			if ((field[y][x] == 1 || field[y][x] == 2 || field[y][x] == 5 || field[y][x] == 6)
					&& (field[ty][tx] == 1 || field[ty][tx] == 2 || field[ty][tx] == 4 || field[ty][tx] == 7))
				return true;
			break;
		case 3: // 위
			if ((field[y][x] == 1 || field[y][x] == 2 || field[y][x] == 4 || field[y][x] == 7)
					&& (field[ty][tx] == 1 || field[ty][tx] == 2 || field[ty][tx] == 5 || field[ty][tx] == 6))
				return true;
			break;
		}
		return false;
	}

	static class Idx {
		int y;
		int x;

		Idx(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
