import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 뿌요뿌요 {
	static char[][] field;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		field = new char[12][6];
		visited = new boolean[12][6];
		int result = 0;
		
		for (int i = 0; i < 12; i++) {
			st = new StringTokenizer(br.readLine());
			field[i] = st.nextToken().toCharArray();
		}

		while(true) {
			boolean flag = false;
			// visited 초기화
			for (int i = 0; i < visited.length; i++)
				Arrays.fill(visited[i], false);
			// 왼쪽아래부터 확인
			for (int i = field.length-1; i >= 0; i--) {
				for (int j = 0; j < field[0].length; j++) {
					if (field[i][j] != '.' && !visited[i][j]) {
						// 카운트세기
						visited[i][j] = true;
						int cnt = count(i, j, field[i][j]); 
						// 없애주기
						if (cnt >= 4) {
							pang(i, j, field[i][j]);
							flag = true;
						}
					}
				}
			}
			// 터진게 있으면 뿌요 아래로 당겨주기
			if (flag) {
				down();
				result++;
			}
			else
				break;
		}
		System.out.println(result);
	}

	private static void down() {
		for (int i = field.length-2; i >= 0; i--) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j] != '.') {
					int y = i;	int x = j;
					while (true) {
						if (y+1 < field.length && field[y+1][x] == '.')
							y++;
						else {
							break;
						}
					}

					if (y != i) {
						field[y][x] = field[i][j];
						field[i][j] = '.';
					}
				}
			}
		}
	}

	private static int count(int y, int x, char puyo) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
				if (field[ty][tx] == puyo && !visited[ty][tx]) {
					visited[ty][tx] = true;
					cnt += count(ty, tx, puyo);
				}
			}
		}
		return cnt+1;
	}

	private static void pang(int y, int x, char puyo) {
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
				if (field[ty][tx] == puyo) {
					field[ty][tx] = '.';
					pang(ty, tx, puyo);
				}
			}
		}
	}
}
