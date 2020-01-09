import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 단지번호붙이기 {
	static int[][] arr;
	static int[] dy = {0, 1, 0, -1}; // 우하좌상
	static int[] dx = {1, 0, -1, 0};
	static int houseCnt = 0;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		char[] str;

		for (int i = 0; i < n; i++) {
			str = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str[j]-'0';
			}
		}

		List<Integer> houseCntList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					cnt++;
					houseCnt = 0;
					dfs(i, j);
					houseCntList.add(houseCnt);
				}
			}
		}
		Collections.sort(houseCntList);
		System.out.println(cnt);
		for (Integer houseCnt : houseCntList)
			System.out.println(houseCnt);
	}

	private static void dfs(int y, int x) {
		arr[y][x] = 0;
		houseCnt++;

		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];

			if (0<=ty && ty<arr.length && 0<=tx && tx<arr.length) {
				if (arr[ty][tx] == 1) {
					dfs(ty, tx);
				}
			}
		}
	}
}
