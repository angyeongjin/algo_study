import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 직사각형탈출 {
	static boolean[][] field;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		field = new boolean[n+1][m+1];
		visited = new boolean[n+1][m+1];

		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < m+1; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) field[i][j] = true;
			}
		}

		// 직사각형 크기, 시작좌표, 도착좌표
		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		Idx start = new Idx(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Idx end = new Idx(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		bfs(h, w, start, end);
	}

	private static void bfs(int h, int w, Idx start, Idx end) {
		Queue<Idx> q = new LinkedList<>();
		q.offer(start);
		visited[start.y][start.x] = true;
		int cnt = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			for (int j = 0; j < size; j++) {
				Idx idx = q.poll();
				// 도착하면
				if (idx.y == end.y && idx.x == end.x) {
					System.out.println(cnt);
					return;
				}
				//위
				boolean flag = false;
				if (1 <= idx.y-1) {
					for (int i = 0; i < w; i++) {
						if (field[idx.y-1][idx.x+i])
							flag = true;
					}
					if(!flag && !visited[idx.y-1][idx.x]) {
						visited[idx.y-1][idx.x] = true;
						q.offer(new Idx(idx.y-1, idx.x));
					}
				}
				// 아래
				if (idx.y+h < field.length) {
					flag = false;
					for (int i = 0; i < w; i++) {
						if (field[idx.y+h][idx.x+i])
							flag = true;
					}
					if(!flag && !visited[idx.y+1][idx.x]) {
						visited[idx.y+1][idx.x] = true;
						q.offer(new Idx(idx.y+1, idx.x));
					}
				}
				// 왼쪽
				if (1 <= idx.x-1) {
					flag = false;
					for (int i = 0; i < h; i++) {
						if (field[idx.y+i][idx.x-1])
							flag = true;
					}
					if(!flag && !visited[idx.y][idx.x-1]) {
						visited[idx.y][idx.x-1] = true;
						q.offer(new Idx(idx.y, idx.x-1));
					}
				}
				// 오른쪽
				if (idx.x+w < field[0].length) {
					flag = false;
					for (int i = 0; i < h; i++) {
						if (field[idx.y+i][idx.x+w])
							flag = true;
					}
					if(!flag && !visited[idx.y][idx.x+1]) {
						visited[idx.y][idx.x+1] = true;
						q.offer(new Idx(idx.y, idx.x+1));
					}
				}
			}
			cnt++;
		} 
		System.out.println(-1);
	}

	static class Idx {
		int y;
		int x;
		Idx(int y, int x) {this.y = y; this.x = x;}
	}
}
