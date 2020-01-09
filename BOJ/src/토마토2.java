import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토2 {
	static int[][][] tomato;
	// 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
	static int[] dz = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 0, 0, 1, -1};
	static int[] dx = {0, 0, -1, 1, 0, 0};


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] c = s.nextLine().split(" ");
		int m = Integer.parseInt(c[0]);
		int n = Integer.parseInt(c[1]);
		int h = Integer.parseInt(c[2]);

		tomato = new int[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					tomato[i][j][k] = s.nextInt();
				}
			}
		}

		System.out.println(dateToRipe());
	}


	private static int dateToRipe() {
		Queue<Idx2> q = new LinkedList<Idx2>();
		int days = -1; // = level
		int tz; int ty;	int tx;

		// 처음 익은 토마토를 찾아내어 큐에 넣는 작업
		for (int i = 0; i < tomato.length; i++) {
			for (int j = 0; j < tomato[0].length; j++) {
				for (int k = 0; k < tomato[0][1].length; k++) {
					if (tomato[i][j][k] == 1) {
						q.offer(new Idx2(i,j,k));
					}
				}
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Idx2 idx = q.poll();
				for (int j = 0; j < 6; j++) { // 왼쪽,오른쪽,앞,뒤 4방향 탐색
					tz = idx.z + dz[j];
					ty = idx.y + dy[j];
					tx = idx.x + dx[j];

					// 범위 벗어나는지 확인
					if (0 <= tz && tz < tomato.length && 0 <= ty && ty < tomato[0].length && 0 <= tx && tx < tomato[0][0].length) {
						if (tomato[tz][ty][tx] == 0) { // 안익은 토마토 발견하면 큐에넣고 익은토마토로 바꿈
							q.offer(new Idx2(tz, ty, tx));
							tomato[tz][ty][tx] = 1;
						}
					}
				}
			}
			if (!q.isEmpty());
			days++;
		}

		// 작업을 완수했는데 안익은 토마토가 남아있으면 -1 리턴
		for (int i = 0; i < tomato.length; i++) {
			for (int j = 0; j < tomato[0].length; j++) {
				for (int k = 0; k < tomato[0][1].length; k++) {
					if (tomato[i][j][k] == 0) {
						return -1;
					}
				}
			}
		}
		return days;
	}
}

class Idx2 {
	int z;
	int y;
	int x;

	public Idx2(int z, int y, int x) { this.z = z; this.y = y; this.x = x; }
}
