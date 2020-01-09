import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의배틀필드 {
	static char[][] field;
	static int[] dy = {-1, 1, 0, 0}; // 상하좌우
	static int[] dx = {0, 0, -1, 1};
	static char[] dir = {'^', 'v', '<', '>'}; 
	static int y; // 전차의 위치
	static int x;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char[] read;
		int t = Integer.parseInt(br.readLine());

		for (int ti = 1; ti <= t; ti++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			field = new char[n][m];

			for (int i = 0; i < n; i++) {
				read = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					field[i][j] = read[j];
					if (read[j] == '^' || read[j] == 'v' || read[j] == '<' || read[j] == '>') {
						y = i;
						x = j;
					}
				}
			}

			int c = Integer.parseInt(br.readLine()); // command
			read = br.readLine().toCharArray();

			for (int i = 0; i < c; i++) {
				switch(read[i]) {
				case 'U':
					move(0);
					break;
				case 'D':
					move(1);
					break;
				case 'L':
					move(2);
					break;
				case 'R':
					move(3);
					break;
				case 'S':
					int by = y;
					int bx = x;
					boolean isOutField = false; // 총알이 필드를 나갔는가
					
					w:do {
						for (int j = 0; j < 4; j++) {
							if (field[y][x] == dir[j]) {
								by += dy[j];
								bx += dx[j];
								if (0 > by || by >= field.length || 0 > bx || bx >= field[0].length) {
									isOutField = true;
									break w;
								}
								break;
							}
						}
					} while (field[by][bx]=='.' || field[by][bx]=='-');
					
					if (!isOutField && field[by][bx] == '*') {
						field[by][bx] = '.';
					}
					break;
				}
			}
			
			System.out.print("#" + ti + " ");
			for (char[] f : field) 
				System.out.println(f);
		}
	}

	private static void move(int command) {
		// 전차의 방향을 바꾼다
		field[y][x] = dir[command]; 

		int ty = y + dy[command];
		int tx = x + dx[command];

		if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
			if (field[ty][tx] == '.') {
				field[ty][tx] = field[y][x];
				field[y][x] = '.';
				y = ty;
				x = tx;
			}
		}
	}
}
