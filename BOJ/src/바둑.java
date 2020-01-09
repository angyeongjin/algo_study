import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 바둑 {
	static int[][] field;
	static boolean[][] visited;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	static int cnt;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		field = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0);
		System.out.println(result);
	}
	private static void comb(int select) {
		if (select >= 2) {
			visited = new boolean[field.length][field[0].length];
			int resultCnt = 0;
			for (int i = 0; i < field.length; i++) {
				for (int j = 0; j < field[0].length; j++) {
					cnt = 0;
					if (field[i][j] == 2 && !visited[i][j]) {
						if (!dfs(i, j, false))
							resultCnt += cnt;
					}
				}
 			}
			result = result < resultCnt ? resultCnt : result;
			return;
		}
		
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j] == 0) {
					field[i][j] = 1;
					comb(select+1);
					field[i][j] = 0;
				}
			}
		}
	}
	private static boolean dfs(int y, int x, boolean flag) {
		cnt++;
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
				if (!visited[ty][tx] && field[ty][tx] == 2) {
					if (flag)
						dfs(ty, tx, flag);
					else
						flag = dfs(ty, tx, flag);
				}
				else if (field[ty][tx] == 0) {
					flag = true;
				}
			}
		}
		return flag;
	}
}
