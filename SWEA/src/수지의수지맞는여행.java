import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 수지의수지맞는여행 {
	static char[][] field;
	static Set<Character> visited = new HashSet<>();
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static int maxCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int ti = 1; ti <= t; ti++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			field = new char[n][m];
			visited.clear();
			maxCnt = 0;
			for (int i = 0; i < n; i++) {
				field[i] = br.readLine().toCharArray();
			}
			dfs(0, 0);
			
			System.out.println("#" + ti + " " + maxCnt);
		}
	}

	private static void dfs(int y, int x) {
		visited.add(field[y][x]);
		if (maxCnt == 26) return; // 알파벳 개수가 26개니까 26이상 나올수가 없어서~
		boolean isNotEnd = false;
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
				if (!visited.contains(field[ty][tx])) { // 본적 없는 명물이면
					isNotEnd = true;
					dfs(ty, tx);
					visited.remove(field[ty][tx]);
				}
			}
		}
		
		if (!isNotEnd)
			maxCnt = Math.max(maxCnt, visited.size());
	}
}
