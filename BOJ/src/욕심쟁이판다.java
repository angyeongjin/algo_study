import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 욕심쟁이판다 {
	static int[][] field;
	static int[][] memo;
	static int[] dy = {0, 1, 0, -1}; // 우하좌상
	static int[] dx = {1, 0, -1, 0};
	static int maxDayToLive = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		field = new int[n][n];
		memo = new int[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(memo[i], 1);

		StringTokenizer st;

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				field[i][j] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int depth = dayToLive(i, j);
				memo[i][j] = depth;
				
				if (maxDayToLive < depth) {
					maxDayToLive = depth;
				}
			}
		}

		System.out.println(maxDayToLive);
	}

	private static int dayToLive(int y, int x) {
		int depth = 1;
		boolean isExistField = false;
	 	
		if (memo[y][x] != 1) {
			depth = memo[y][x];
			isExistField = true;
		}
		else {
			int temp = depth;
			for (int j = 0; j < 4; j++) {
				int ty = y + dy[j];
				int tx = x + dx[j];

				if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
					if (field[ty][tx] > field[y][x]) {
						isExistField = true;
						int d = temp + dayToLive(ty, tx);
						if (depth < d) {
							depth = d;
							memo[y][x] = depth;
						}
					}
				}
			}
		}

		if (!isExistField)
			return 1;
		else
			return depth;
	}
}
