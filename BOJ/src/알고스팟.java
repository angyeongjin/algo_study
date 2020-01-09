import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 알고스팟 {
	static boolean[][] field;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static boolean[][] v;
	static int[][] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		field = new boolean[n][m];
		memo = new int[n][m];
		v = new boolean[n][m];
		char[] read;
		for (int i = 0; i < n; i++) {
			read = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (read[j]-'0' == 1) field[i][j] = true;
				else 				  field[i][j] = false;
			}
		}
		bfs(0, 0);
		System.out.println(memo[n-1][m-1]);
	}
	
	private static void bfs(int y, int x) {
		PriorityQueue<Idx> q = new PriorityQueue<>();
		v[y][x] = true;
		q.offer(new Idx(y, x, 0));

		w:while(!q.isEmpty()) {
			Idx idx = q.poll();
			for (int k = 0; k < 4; k++) {
				int ty = idx.y + dy[k];
				int tx = idx.x + dx[k];
				int data = idx.data;
				if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
					if (!v[ty][tx] || memo[ty][tx] > data) {
						memo[ty][tx] = data + (field[ty][tx] ? 1 : 0);
						if (ty == field.length && tx == field[0].length) break w;
						v[ty][tx] = true;
						boolean flag = false;
						for (Idx qq : q) {
							if (qq.y == ty && qq.x == tx) { qq.data = memo[ty][tx]; flag = true; break; } }
						if (!flag)q.offer(new Idx(ty, tx, memo[ty][tx]));
					}
				}
			}
		}
	}
	
	static class Idx implements Comparable<Idx> {
		int y;
		int x;
		int data;

		Idx(int y, int x, int data) {
			this.y = y;
			this.x = x;
			this.data = data;
		}

		@Override
		public int compareTo(Idx o) {
			return this.data - o.data;
		}
	}
}
