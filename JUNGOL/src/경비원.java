import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경비원 {
	static int[] dy = {0, -1, 0, 1};  // 좌상우하
	static int[] dx = {-1, 0, 1, 0};
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[][] field = new int[h+1][w+1];
		v = new boolean[h+1][w+1];
		int result = 0;
		int n = Integer.parseInt(br.readLine());
		int[][] idx = new int[n][];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());
			idx[i] = findIdx(dir, loc, h, w);
		}
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken());
		int loc = Integer.parseInt(st.nextToken());
		int[] dongGeun = findIdx(dir, loc, h, w);
		Queue<int[]> q = new LinkedList<>();
		field[dongGeun[0]][dongGeun[1]] = 1;
		v[dongGeun[0]][dongGeun[1]] = true;
		q.offer(dongGeun);
		while(!q.isEmpty()) {
			int[] qIdx = q.poll();
			for (int i = 0; i < 4; i++) {
				int ty = qIdx[0] + dy[i];
				int tx = qIdx[1] + dx[i];
				if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
					if (!v[ty][tx] && (ty == 0 || ty == h || tx == 0 || tx == w)) {
						v[ty][tx] = true;
						field[ty][tx] = field[qIdx[0]][qIdx[1]]+1;
						q.offer(new int[] {ty, tx});
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			result+=(field[idx[i][0]][idx[i][1]]-1);
		}
		System.out.println(result);
	}

	private static int[] findIdx(int dir, int loc, int h, int w) {
		int[] idx = new int[2];
		if (dir == 1) { idx[0] = 0; idx[1] = loc; }
		else if (dir == 2) { idx[0] = h; idx[1] = loc; }
		else if (dir == 3) { idx[0] = loc; idx[1] = 0; }
		else if (dir == 4) { idx[0] = loc; idx[1] = w; }
		return idx;
	}
}
