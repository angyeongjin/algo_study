import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 감시 {
	static List<CCTV> list = new ArrayList<>();
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int N;
	static int M;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] field = new int[N][M];
		list.clear();
		result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if (field[i][j] != 0 && field[i][j] != 6) {
					list.add(new CCTV(i, j, field[i][j]));
				}
			}
		}
		solution(0, field);
		bw.write(result+"");
		bw.flush();
	}

	private static void solution(int idx, int[][] field) {
		if (idx == list.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (field[i][j] == 0) cnt++;
				}
			}
			result = Math.min(result, cnt);
			return;
		}
		
		int[][] f = new int[N][];
		boolean[] dir;
		int y = list.get(idx).y;
		int x = list.get(idx).x;
		switch (list.get(idx).k) {
		case 1:
			dir = new boolean[] {true, false, false, false};
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < N; j++)
					f[j] = field[j].clone();
				cctvArea(y, x, dir, f);
				solution(idx+1, f);
				if (i == 3) continue;
				for (int j = 0; j < 4; j++) {
					if (dir[j]) {
						dir[j+1!=4?j+1:0] = true;
						dir[j] = false;
						break;
					}
				}
			}
			break;
		case 2:
			dir = new boolean[] {true, false, true, false};
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++)
					f[j] = field[j].clone();
				cctvArea(y, x, dir, f);
				solution(idx+1, f);
				if (i == 1) continue;
				for (int j = 0; j < 4; j++) {
					dir[j] = dir[j]?false:true;
				}
			}
			break;
		case 3:
			dir = new boolean[] {true, true, false, false};
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < N; j++)
					f[j] = field[j].clone();
				cctvArea(y, x, dir, f);
				solution(idx+1, f);
				if (i == 3) continue;
				for (int j = 0; j < 4; j++) {
					if (dir[j]) {
						if(!dir[j+1!=4?j+1:0]) {
							dir[j+1!=4?j+1:0] = true;
							break;
						} else dir[j]=false;
					} else {
						dir[j] = false;
					}
				}
			}
			break;
		case 4:
			dir = new boolean[] {true, true, true, false};
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < N; j++)
					f[j] = field[j].clone();
				cctvArea(y, x, dir, f);
				solution(idx+1, f);
				if (i == 3) continue;
				for (int j = 0; j < 4; j++) {
					if (!dir[j]) {
						dir[j+1!=4?j+1:0] = false;
						dir[j] = true;
						break;
					}
				}
			}
			break;
		case 5:
			f = field.clone();
			cctvArea(y, x, new boolean[] {true, true, true, true}, f);
			solution(idx+1, f);
			break;
		}
	}

	static void cctvArea(int y, int x, boolean[] dir, int[][] field) {
		for (int i = 0; i < 4; i++) {
			if (dir[i]) {
				int ty = y;
				int tx = x;
				while(true) {
					ty += dy[i];
					tx += dx[i];
					if (0 > ty || ty >= N || 0 > tx || tx >= M) break;
					if (field[ty][tx] == 6) break;
					if (field[ty][tx] != 0) continue;
					field[ty][tx] = -1;
				}
			}
		}
	}
	
	static class CCTV {
		int y;
		int x;
		int k; // cctv종류
		public CCTV(int y, int x, int k) {
			this.y = y;
			this.x = x;
			this.k = k;
		}
	}
}
