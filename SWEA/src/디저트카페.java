import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 디저트카페 {
	static int[][] field;
	static int[] dy = { -1, 1, 1, -1 };
	static int[] dx = { 1, 1, -1, -1 };
	static boolean[] vDir = new boolean[4]; // 1시, 5시, 7시, 11시 방향
	static boolean[] eatDessert = new boolean[101];
	static int[] start = new int[2];
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			Arrays.fill(eatDessert, false);
			field = new int[n][n];
			result = -1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if ((i == 0 && j == 0) || (i == 0 && j == n-1) || (i == n-1 && j == 0) || (i == n-1 && j == n-1)) continue;
					for (int k = 0; k < 2; k++) {
						Arrays.fill(vDir, false);
						start[0] = i;
						start[1] = j;
						bruteForce(i, j, k*2, 1);
					}
				}
			}
			bw.write("#" + ti + " " + result + "\n");
			bw.flush();
		}
	}

	private static void bruteForce(int y, int x, int dir, int cnt) {
		eatDessert[field[y][x]] = true;
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
				if ((!vDir[i] || i==dir) && !eatDessert[field[ty][tx]]) {
					if (dir != i) vDir[dir] = true;
					bruteForce(ty, tx, i, cnt+1);
					if (dir != i) vDir[dir] = false;
				}
				
				if (cnt > 2 && start[0] == ty && start[1] == tx) {
					result = Math.max(result, cnt);
					break;
				}
			}
		}
		eatDessert[field[y][x]] = false;
	}

}
