import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기 {
	static int[][] field;
	static int[] dy = {0, 0, 0, -1, 1}; // 동서북남
	static int[] dx = {0, 1, -1, 0, 0};
	static int top = 0;
	static int bottom = 0;
	static int east = 0;
	static int north = 0;
	static int west = 0;
	static int south = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken()); // 문제에서는 x, y 로 입력받으나 나는 편의상 y, x로 명칭하겠음
		int k = Integer.parseInt(st.nextToken());
		field = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				field[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int command = Integer.parseInt(st.nextToken());
			int ty = y + dy[command];
			int tx = x + dx[command];
			int temp;
			// 범위 안일때만 명령실행
			if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
				switch (command) {
				case 1:
					temp = bottom;
					bottom = east;
					east = top;
					top = west;
					west = temp;
					break;
				case 2:
					temp = bottom;
					bottom = west;
					west = top;
					top = east;
					east = temp;
					break;
				case 3:
					temp = bottom;
					bottom = north;
					north = top;
					top = south;
					south = temp;
					break;
				case 4:
					temp = bottom;
					bottom = south;
					south = top;
					top = north;
					north = temp;
					break;
				}
				System.out.println(top);

				if (field[ty][tx] != 0) {
					bottom = field[ty][tx];
					field[ty][tx] = 0;
				} else {
					field[ty][tx] = bottom;
				}
				y = ty;
				x = tx;
			}
		}
	}
}
