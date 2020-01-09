import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 청소기 {
	static int[] dy = {-1, 0, 1, 0}; // 북동남서
	static int[] dx = {0, 1, 0, -1};
	static int[][] field;
	static int cnt = 1;
	static boolean isStop;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		field = new int[n][m];
		str = br.readLine().split(" ");
		int y = Integer.parseInt(str[0]);
		int x = Integer.parseInt(str[1]);
		int dir = Integer.parseInt(str[2]);

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				field[i][j] = Integer.parseInt(str[j]);
			}
		}
		field[y][x] = 2;
		moveRobot(y, x, dir);
		System.out.println(cnt);
	}

	private static void moveRobot(int y, int x, int dir) {
		if (isStop) return; // 청소기가 작동을 멈추면 return
		
		int ty = 0;
		int tx = 0;
		for (int i = 0; i < 4; i++) {
			if (isStop) return; // 재귀를 빠져나올 때 청소기가 멈추면 더이상 돌지않도록 return
			dir = dir-1 == -1 ?  3 : dir-1; // 방향을 왼쪽으로 튼다
			ty = y + dy[dir];
			tx = x + dx[dir];

			if (0<=ty && ty<field.length && 0<=tx && tx<field[0].length) {
				if (field[ty][tx] == 0) {
					field[ty][tx] = 2;
					cnt++;
					moveRobot(ty, tx, dir);
				}
			}
		}
		if (isStop) return; // 재귀를 빠져나올 때 청소기가 멈추면 더이상 돌지않도록 return
		
		/* 4방향 다 탐색 후 뒤가 벽이면 stop, 아니면 후진 */
		int back = dir-2 < 0 ?  4+(dir-2) : dir-2;
		int by = y + dy[back];
		int bx = x + dx[back];
		if (0<=by && by<field.length && 0<=bx && bx<field[0].length) { // 뒤가 벽이면 return
			if (field[by][bx] == 1) {
				isStop = true;
				return;
			}
			else
				moveRobot(by, bx, dir); // 뒤가 벽이 아니면 후진
		}
	}
}
