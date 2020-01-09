import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토1 {
	static int[][] tomato;
	static int[] dy = {0, 0, 1, -1}; // 왼쪽, 오른쪽, 앞, 뒤 (좌우하상)
	static int[] dx = {-1, 1, 0, 0};
	static boolean isMature;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] c = s.nextLine().split(" ");
		int m = Integer.parseInt(c[0]);
		int n = Integer.parseInt(c[1]);

		tomato = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tomato[i][j] = s.nextInt();
			}
		}

		System.out.println(dateToRipe());
	}


	private static int dateToRipe() {
		Queue<Idx> q = new LinkedList<Idx>();
		int days = -1; // = level
		int ty;	int tx;

		// 처음 익은 토마토를 찾아내어 큐에 넣는 작업
		for (int i = 0; i < tomato.length; i++) {
			for (int j = 0; j < tomato[0].length; j++) {
				if (tomato[i][j] == 1) {
					q.offer(new Idx(i,j));
				}
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Idx idx = q.poll();
				for (int j = 0; j < 4; j++) { // 왼쪽,오른쪽,앞,뒤 4방향 탐색
					ty = idx.y + dy[j];
					tx = idx.x + dx[j];

					// 범위 벗어나는지 확인
					if (0 <= ty && ty < tomato.length && 0 <= tx && tx < tomato[0].length) {
						if (tomato[ty][tx] == 0) { // 안익은 토마토 발견하면 큐에넣고 익은토마토로 바꿈
							q.offer(new Idx(ty, tx));
							tomato[ty][tx] = 1;
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
				if (tomato[i][j] == 0) {
					return -1;
				}
			}
		}
		return days;
	}
}

class Idx {
	int y;
	int x;

	public Idx(int y, int x) { this.y = y; this.x = x; }
}