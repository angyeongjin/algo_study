import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이차오른다가자 {
	static char[][] field;
	static boolean[][][] visited;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		field = new char[N][];
		visited = new boolean[1<<6][N][M]; // a ~ f 6가지 열쇠
		int[] start = new int[2];
		for (int i = 0; i < N; i++) {
			field[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (field[i][j] == '0') {
					start[0] = i; start[1] = j;
					field[i][j] = '.';
				}
			}
		}
		bw.write(bfs(start, N, M)+"");
		bw.flush();
	}

	private static int bfs(int[] start, int N, int M) {
		Queue<Minsik> q = new LinkedList<>();
		visited[0][start[0]][start[1]] = true;
		q.offer(new Minsik(start[0], start[1], 0));
		int cnt = 0;
		boolean flag = false;
		w:while(!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Minsik m = q.poll();
				for (int j = 0; j < 4; j++) {
					int ty = m.y + dy[j];
					int tx = m.x + dx[j];
					if (0 <= ty && ty < N && 0 <= tx && tx < M) {
						if (field[ty][tx] == '1') {
							flag = true;
							break w;
						}
						if (field[ty][tx] == '#') continue;
						if (!visited[m.key][ty][tx] && 'A' <= field[ty][tx] && field[ty][tx] <= 'F') { // 열쇠를 가지고 있나
							if (((1 << field[ty][tx]-'A') & m.key) > 0) { // 만약 열쇠를 가지고 있으면
								visited[m.key][ty][tx] = true;
								q.offer(new Minsik(ty, tx, m.key));
							}
						} else if (!visited[m.key][ty][tx] && 'a' <= field[ty][tx] && field[ty][tx] <= 'f') { // 열쇠를 먹을때
							visited[(1 << field[ty][tx]-'a') | m.key][ty][tx] = true;
							q.offer(new Minsik(ty, tx, (1 << field[ty][tx]-'a') | m.key));
						} else if (!visited[m.key][ty][tx] && field[ty][tx] == '.') { // 그냥 지나갈 수 있다
							visited[m.key][ty][tx] = true;
							q.offer(new Minsik(ty, tx, m.key));
						}
					}
				}
			}
		}
		if (!flag) cnt = -1;
		return cnt;
	}

	static class Minsik { // 민식이 클래스
		int y;
		int x;
		int key; // 가지고 있는 키
		public Minsik(int y, int x, int key) {
			this.y = y;
			this.x = x;
			this.key = key;
		}
	}
}
