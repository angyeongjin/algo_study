import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {
	static int[][] field;
	static int maxSaftyZone; // = 0
	static int[] dy = {0, 1, 0, -1}; // 우하좌상
	static int[] dx = {1, 0, -1, 0};
	static boolean[][] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		field = new int[n][m];
		temp = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		selectWall(0);
		System.out.println(maxSaftyZone);
	}

	/* 벽을 3개 선택하는 메소드 (완전탐색) */
	private static void selectWall(int selectCnt) {
		if (selectCnt == 3) {
			spreadVirus();
			return;
		}

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j] == 0) {
					field[i][j] = 1;
					selectWall(selectCnt+1);
					field[i][j] = 0;
				}
			}
		}
	}

	private static void spreadVirus() {
		int cnt = 0;

		/* 기존 필드를 수정하지 않고 복사해서 바이러스 확산 표시 */
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if (field[i][j] != 0) 
					temp[i][j] = true;
				else
					temp[i][j] = false;
			}
		}

		/* 초기 바이러스 위치를 찾아 dfs로 확산 */
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j] == 2) {
					dfs(i, j);
				}
			}
		}

		/* 바이러스가 다 퍼진 후 안전한 지역을 센다 */
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if (!temp[i][j]) {
					cnt++;
				}
			}
		}

		/* 센 안전지역이 max보다 클때 max에 저장 */
		if (maxSaftyZone < cnt) {
			maxSaftyZone = cnt;
		}
	}

	private static void dfs(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];

			if (0 <= ty && ty < temp.length && 0 <= tx && tx < temp[0].length) {
				if (!temp[ty][tx]) {
					temp[ty][tx] = true; // 바이러스 확산
					dfs(ty, tx);
				}
			}
		}
	}
}
