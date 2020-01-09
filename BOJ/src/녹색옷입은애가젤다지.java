import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지 {
	static int[][] field;
	static int[][] memo;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = 1;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break; 
			field = new int[n][n];
			memo = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < n; i++)
				Arrays.fill(memo[i], -1);
			memo[n-1][n-1] = Integer.MAX_VALUE;
			memo[0][0] = field[0][0];
			bfs(0, 0);
			bw.write("Problem " + t + ": " + memo[n-1][n-1] + "\n");
			t++;
		}
		bw.flush();
	}

	private static void bfs(int y, int x) {
		PriorityQueue<Idx> q = new PriorityQueue<>();
		q.offer(new Idx(y, x, field[0][0]));

		while(!q.isEmpty()) {
			Idx idx = q.poll();
			for (int k = 0; k < 4; k++) {
				int ty = idx.y + dy[k];
				int tx = idx.x + dx[k];
				int blackRupee = idx.blackRupee;
				if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
					if (memo[ty][tx] == -1 || blackRupee + field[ty][tx] < memo[ty][tx]) {
						memo[ty][tx] = blackRupee+field[ty][tx];
						q.offer(new Idx(ty, tx, blackRupee+field[ty][tx]));
					}
				}
			}
		}
	}

	static class Idx implements Comparable<Idx> {
		int y;
		int x;
		int blackRupee;

		Idx(int y, int x, int blackRupee) {
			this.y = y;
			this.x = x;
			this.blackRupee = blackRupee;
		}

		@Override
		public int compareTo(Idx o) {
			return this.blackRupee - o.blackRupee;
		}
	}
}
