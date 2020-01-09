import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 치즈2636 {
	static int[][] field;
	static int[][] temp;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		field = new int[n][m];
		temp = new int[n][m];
		boolean isExistCheese = false;
		int time = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int resultCnt = 0;
		while(!isExistCheese) {
			isExistCheese = true;
			for (int i = 0; i < n; i++)
				temp[i] = field[i].clone();

			dfs(0, 0);
			for (int[] c : temp)
				System.out.println(Arrays.toString(c));
			System.out.println();
			int cnt = 0;
			for (int i = 1; i < n-1; i++) {
				for (int j = 1; j < m-1; j++) {
					if(field[i][j] == 1) {
						isExistCheese = false;
						boolean flag = false;
						for (int k = 0; k < 4; k++) {
							int ty = i + dy[k];
							int tx = j + dx[k];

							if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
								if (temp[ty][tx] == -1) {
									flag = true;
								}
							}
						}
						if (flag) {
							field[i][j] = 0;
							cnt++;
						}
					}
				}
			}
			for (int[] c : field)
				System.out.println(Arrays.toString(c));
			System.out.println();
			if(!isExistCheese) {
				time++;
				resultCnt = cnt;
			}
		}
		
		System.out.println(time);
		System.out.println(resultCnt);
	}

	private static void dfs(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];

			if (0 <= ty && ty < temp.length && 0 <= tx && tx < temp[0].length) {
				if (temp[ty][tx] == 0) {
					temp[ty][tx] = -1;
					dfs(ty, tx);
				}
			}
		}
	}
}
