import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class 말이되고픈원숭이미완 {
	static int[][] field;
	static int[][] memo;
	static int[][] dy = {{-2, -1, 1, 2, 2, 1, -1, -2}, {0, 0, 1, -1}};
	static int[][] dx = {{1, 2, 2, 1, -1, -2, -2, -1}, {1, -1, 0, 0}};
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		field = new int[H][W];
		memo = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int[] f : memo)
			Arrays.fill(f, -1);
		bfs(0, 0, K, H, W);
		System.out.println(result);
		
	}
	
	private static void bfs(int y, int x, int K, int H, int W) {
		PriorityQueue<Monkey> q = new PriorityQueue<>();
		memo[y][x] = 0;
		Monkey start = new Monkey(y, x, K, 0, new HashSet<>());
		start.set.add(y+","+x);
		q.offer(start);
		
		while(!q.isEmpty()) {
			Monkey m = q.poll();
			for (int i = 0; i < 2; i++) {
				if (m.k > 0) {
					for (int j = 0; j < 8; j++) {
						int ty = m.y + dy[0][j];
						int tx = m.x + dx[0][j];
						if (0 <= ty && ty < H && 0 <= tx && tx < W) {
							if (ty == H-1 && tx == W-1) {
								result = m.cnt+1;
								return;
							}
							if (field[ty][tx] != 1 && !m.set.contains(ty+","+tx)) {
								memo[ty][tx] = Math.min(memo[ty][tx], m.cnt+1);
								Monkey mm = new Monkey(ty, tx, m.k-1, m.cnt+1 , new HashSet<>(m.set));
								mm.set.add(ty+","+tx);
								q.offer(mm);
							}
						}
					}
				}
				for (int j = 0; j < 4; j++) {
					int ty = m.y + dy[1][j];
					int tx = m.x + dx[1][j];
					if (0 <= ty && ty < H && 0 <= tx && tx < W) {
						if (ty == H-1 && tx == W-1) {
							result = m.cnt+1;
							return;
						}
						if (field[ty][tx] != 1 && !m.set.contains(ty+","+tx)) {
							memo[ty][tx] = Math.min(memo[ty][tx], m.cnt+1);
							Monkey mm = new Monkey(ty, tx, m.k, m.cnt+1 , new HashSet<>(m.set));
							mm.set.add(ty+","+tx);
							q.offer(mm);
						}
					}
				}
			}
		}
        result = -1;
	}

	static class Monkey implements Comparable<Monkey> {
		int y;
		int x;
		int k;
		int cnt;
		Set<String> set;
		public Monkey(int y, int x, int k, int cnt, Set<String> set) {
			this.y = y;
			this.x = x;
			this.k = k;
			this.cnt = cnt;
			this.set = set;
		}
		@Override
		public int compareTo(Monkey o) {
			return this.cnt - o.cnt;
		}
	}
}
