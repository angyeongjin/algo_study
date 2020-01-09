import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의갯수 {
	static int[][] field;
	static boolean[][] visited;
	static int[] dy = {0,0,1,-1,-1,1,-1,1};
	static int[] dx = {1,-1,0,0,-1,-1,1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break; // 0 0 들어오면 종료
			
			field = new int[h][w];
			int result = 0;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
 			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (field[i][j] == 1) {
						bfs(i,j);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}

	private static void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		field[y][x] = 0;
		q.offer(new int[] {y, x});
		
		while(!q.isEmpty()) {
			int[] idx = q.poll();
			for (int i = 0; i < 8; i++) {
				int ty = idx[0] + dy[i];
				int tx = idx[1] + dx[i];
				if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
					if (field[ty][tx] == 1) {
						field[ty][tx] = 0;
						q.offer(new int[] {ty, tx});
					}
				}
			}
		}
	}
}
