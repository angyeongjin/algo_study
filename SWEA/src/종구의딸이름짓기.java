import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 종구의딸이름짓기 {
	static char[][] field;
	static int[] dy = { 0, 1 };
	static int[] dx = { 1, 0 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int ti = 1; ti <= t; ti++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			field = new char[n][];
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				field[i] = br.readLine().toCharArray();
			}
			bw.write("#"+ti+" "+bfs(0, 0)+"\n");
		}
		bw.flush();
	}

	private static String bfs(int y, int x) {
		Queue<Idx> q = new LinkedList<>();
		visited[y][x] = true;
		q.offer(new Idx(y, x, field[y][x]));
		char ch = field[y][x];
		String result = "";
		
		while (!q.isEmpty()) {
			int size = q.size();
			char next = 'z';
			result += ch;
			for (int i = 0; i < size; i++) {
				Idx idx = q.poll();
				if (ch == idx.alpha) {
					for (int k = 0; k < 2; k++) {
						int ty = idx.y + dy[k];
						int tx = idx.x + dx[k];
						if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length && !visited[ty][tx]) {
							visited[ty][tx] = true;
							if (field[ty][tx] < next) next = field[ty][tx];
							q.offer(new Idx(ty, tx, field[ty][tx]));
						}
					}
				}
			}
			ch = next;
		}
		return result;
	}

	static class Idx {
		int y;
		int x;
		char alpha;

		Idx(int y, int x, char alpha) {
			this.y = y;
			this.x = x;
			this.alpha = alpha;
		}
	}
}
