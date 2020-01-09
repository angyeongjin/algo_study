import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 나이트의이동 {
	static int[][] field;
	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			field = new int[n][n];

			String[] str = br.readLine().split(" ");
			int y = Integer.parseInt(str[0]);
			int x = Integer.parseInt(str[1]);
			str = br.readLine().split(" ");
			field[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;

			catchJol(y, x);
		}
	}

	private static void catchJol(int y, int x) {
		int cnt = 0;
		if (field[y][x] == 1)
			System.out.println(cnt);
		
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] {y, x});
		field[y][x] = -1;

		w:while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				int[] idx = q.poll();
				for (int j = 0; j < 8; j++) {
					int ty = idx[0] + dy[j];
					int tx = idx[1] + dx[j];

					if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
						if (field[ty][tx] == 1) {	// 졸을 잡으면
							System.out.println(cnt);
							break w; // 잡으면 탐색할 필요 없으니까 아예 빠져나옴
						}
						else if (field[ty][tx] == 0) {	// 졸은 없지만 이동할 수 있을때
							field[ty][tx] = -1;
							q.offer(new int[] {ty, tx});
						}
					}
				}
			}
		}
	}
}
