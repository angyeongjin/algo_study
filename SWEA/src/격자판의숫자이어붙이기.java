import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 격자판의숫자이어붙이기 {
	static String[][] field;
	static Map<String, String> map;
	static int[] dy = {0, 1, 0, -1}; // 우하좌상
	static int[] dx = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		int n = 4;

		for (int ti = 1; ti <= t; ti++) {
			field = new String[n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					if (st.hasMoreTokens()) {
						field[i][j] = st.nextToken();
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dfs(i, j, 0);
				}
			}
		}
	}
	
	private static void dfs(int y, int x, int depth) {
		if (depth == 7) {
			
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			
			if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
				
			}
		}
	}
}
