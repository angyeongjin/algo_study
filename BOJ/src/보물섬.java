import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 보물섬 {
	static int maxTime;
	static int[] dy = {0, 1, 0, -1}; // 우하좌상
	static int[] dx = {1, 0, -1, 0};
	static char[][] field;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read1 = br.readLine().split(" ");
		char[] read2;
		int n = Integer.parseInt(read1[0]);
		int m = Integer.parseInt(read1[1]);
		field = new char[n][m];

		for (int i = 0; i < n; i++) {
			read2 = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				field[i][j] = read2[j];
			}
		}

		// temp 배열 만들어서 탐색, 기존 필드가 바뀌면 안되니까 temp에서 표시해줄거임
		char[][] temp = new char[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (field[i][j] == 'L') {
					for (int k = 0; k < n; k++) {
						for (int l = 0; l < m; l++)
							temp[k][l] = field[k][l];
					}
					cntMaxTime(temp, i, j);
				}
			}
		}
		System.out.println(maxTime);
	}

	private static void cntMaxTime(char[][] arr, int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		int time = 0;
		q.offer(new int[]{y, x});
		arr[y][x] = 'V';

		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] idx = q.poll(); // yx[0] = y, yx[1] = x
				for (int j = 0; j < 4; j++) { // 4방향 탐색
					int ty = idx[0] + dy[j];
					int tx = idx[1] + dx[j];

					if (0 <= ty && ty < arr.length && 0 <= tx && tx < arr[0].length) {
						if (arr[ty][tx] == 'L') {
							arr[ty][tx] = 'V'; // visited, 방문표시
							q.offer(new int[]{ty, tx});
						}
					}
				}
			}
			if (!q.isEmpty())
				time++;
		}

		if (maxTime < time)
			maxTime = time;
	}
}
