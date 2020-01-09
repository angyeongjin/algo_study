import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기2 {
	static int[][] field;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		field = new int[n][m];
		int islandNo = 1;

		// 섬 입력받기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				field[i][j] = -Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬에 번호 붙이기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (field[i][j] == -1) {
					bfs(i, j, islandNo);
					islandNo++;
				}
			}
		}

		// 연결할 수 있는 다리 세기
		List<Bridge> bridge = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (field[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int len = 0;
						int ty = i;
						int tx = j;
						while (true) {
							ty = ty + dy[k];
							tx = tx + dx[k];
							if (0 > ty || ty >= n || 0 > tx || tx >= m || field[ty][tx] == field[i][j])
								break;
							if (field[ty][tx] != 0) {
								if (len >= 2)
									bridge.add(new Bridge(field[i][j], field[ty][tx], len));
								break;
							}
							len++;
						}
					}
				}
			}
		}
		
		int result = 0;
		makeSet(--islandNo);
		
		// 다리 길이가 작은 순으로 다리 연결 해보기
		Collections.sort(bridge);
		for (Bridge b : bridge) {
			if (unionSet(b.island1, b.island2)) result += b.len;
		}
		for (int i = 2; i < parent.length; i++) {
			if (findSet(i) != findSet(1)) {
				System.out.println(-1);
				break;
			}
			if ( i == parent.length-1)
				System.out.println(result);
		}
		
	}

	private static void bfs(int y, int x, int islandNo) {
		Queue<int[]> q = new LinkedList<>();
		field[y][x] = islandNo;
		q.offer(new int[] {y, x});
		
		while(!q.isEmpty()) {
			int[] idx = q.poll();
			for (int i = 0; i < 4; i++) {
				int ty = idx[0] + dy[i];
				int tx = idx[1] + dx[i];
				if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
					if (field[ty][tx] == -1) {
						field[ty][tx] = islandNo;
						q.offer(new int[] {ty, tx});
					}
				}
			}
		}
	}

	private static boolean unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (y != x) {
			parent[y] = x;
			return true;
		}
		return false;
	}

	private static int findSet(int x) {
		if (x == parent[x])
			return x;
		else return parent[x] = findSet(parent[x]);
	}

	private static void makeSet(int islandNo) {
		parent = new int[islandNo+1];
		for (int i = 1; i <= islandNo; i++) {
			parent[i] = i;
		}
	}

	static class Bridge implements Comparable<Bridge>{
		int island1;
		int island2;
		int len; // 다리길이

		public Bridge(int island1, int island2, int len) {
			super();
			this.island1 = island1;
			this.island2 = island2;
			this.len = len;
		}

		@Override
		public int compareTo(Bridge o) {
			return this.len - o.len;
		}
	}

}
