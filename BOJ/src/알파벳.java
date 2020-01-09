import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {
	static char[][] field;
	static boolean[] visited;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static int maxCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		field = new char[n][m];
		visited = new boolean[26];
		maxCnt = 0;
		for (int i = 0; i < n; i++) {
			field[i] = br.readLine().toCharArray();
		}
		dfs(0, 0, 1);
		System.out.println(maxCnt);
	}

	private static void dfs(int y, int x, int cnt) {
		visited[field[y][x]-'A'] = true;
		maxCnt = Math.max(maxCnt, cnt);
		if (maxCnt == 26) return; // 알파벳 개수가 26개니까 26이상 나올수가 없어서~
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
				if (!visited[field[ty][tx]-'A']) { // 본적 없는 명물이면
					dfs(ty, tx, cnt+1);
					visited[field[ty][tx]-'A'] = false;
				}
			}
		}
	}
}
