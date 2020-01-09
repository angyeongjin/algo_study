import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 보급로 {
	static int[][] field;
	static int[][] memo;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] read;
		int t = Integer.parseInt(br.readLine());

		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			field = new int[n][n];
			memo = new int[n][n];
			for (int i = 0; i < n; i++) {
				read = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					field[i][j] = read[j]-'0';
				}
			}
			for (int i = 0; i < n; i++)
				Arrays.fill(memo[i], -1);
			memo[n-1][n-1] = Integer.MAX_VALUE;
			memo[0][0] = 0;
			bfs(0, 0);
			System.out.println("#" + ti + " " + memo[n-1][n-1]);
			for (int[] m : memo)
				System.out.println(Arrays.toString(m));
		}
	}

	private static void bfs(int y, int x) {
		PriorityQueue<Idx> q = new PriorityQueue<>(); // 와 진짜 이거 생각한사람 존나 천재 ㄷㄷ;
		q.offer(new Idx(y, x, 0));

		while(!q.isEmpty()) {
			Idx idx = q.poll();
			for (int k = 0; k < 4; k++) {
				int ty = idx.y + dy[k];
				int tx = idx.x + dx[k];
				int time = idx.time;
				if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
					if (memo[ty][tx] == -1 || time + field[ty][tx] < memo[ty][tx]) {
						memo[ty][tx] = time+field[ty][tx];
						q.offer(new Idx(ty, tx, time+field[ty][tx]));
					}
				}
			}
		}
	}

	static class Idx implements Comparable<Idx> {
		int y;
		int x;
		int time;

		Idx(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}

		@Override
		public int compareTo(Idx o) {
			return this.time - o.time;
		}
	}
}
