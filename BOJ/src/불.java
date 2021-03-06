import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 불 {
	static char[][] field;
	static int[] dy = {0, -1, 0, 1};  // 좌상우하
	static int[] dx = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int ti = 1; ti <= t; ti++) {
			String[] read1 = br.readLine().split(" ");
			int m = Integer.parseInt(read1[0]);
			int n = Integer.parseInt(read1[1]);
			field = new char[n][m];

			int[] idx = null;
			List<int[]> fidxs = new ArrayList<>();

			// 필드정보를 읽으면서 용사, 불의 위치를 찾으면 인덱스에 저장
			for (int i = 0; i < n; i++) {
				char[] read2 = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					switch (read2[j]) {
					case '@':
						idx = new int[] {i, j};
						break;
					case '*':
						fidxs.add(new int[] {i, j});
						break;
					}
					field[i][j] = read2[j];
				}
			}

			if (idx[0] == 0 || idx[0] == field.length-1 || idx[1] == 0 || idx[1] == field[0].length-1)
				System.out.println(1);
			else
				exitFire(idx, fidxs);
		}
	}

	private static void exitFire(int[] startIdx, List<int[]> fidxs) {
		Queue<int[]> q = new LinkedList<>();  // 용자의 이동경로
		Queue<int[]> fq = new LinkedList<>(); // 불의 이동경로
		boolean isExit = false; // 탈출가능한지 체크
		int time = 1; // 탈출에 걸린 시간
		q.offer(startIdx);
		field[startIdx[0]][startIdx[1]] = ',';
		for (int[] fidx : fidxs) 
			fq.offer(fidx);

		w:while (!q.isEmpty() || !fq.isEmpty()) {
			time++;
			int fsize = fq.size();
			for (int i = 0; i < fsize; i++) { // 불 먼저 다 붙음
				int[] idx = fq.poll();
				for (int j = 0; j < 4; j++) {
					int ty = idx[0] + dy[j];
					int tx = idx[1] + dx[j];
					if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
						if (field[ty][tx] == '.' || field[ty][tx] == ',') { // 길 or 용자가 지나간길
							field[ty][tx] = '*';
							fq.offer(new int[] {ty, tx});
						}
					}
				}
			}
			int size = q.size();
			for (int i = 0; i < size; i++) { // 용자 이동
				int[] idx = q.poll();
				for (int j = 0; j < 4; j++) {
					int ty = idx[0] + dy[j];
					int tx = idx[1] + dx[j];
					if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
						if (field[ty][tx] == '.') {
							if (ty == 0 || ty == field.length-1 || tx == 0 || tx == field[0].length-1) {
								isExit = true;
								break w; // 탈출하면 더이상 탐색할 필요 없으니까 while문 탈출
							}
							else {
								field[ty][tx] = ',';
								q.offer(new int[] {ty, tx});
							}
						}
					}
				}
			}
		}

		if (isExit)
			System.out.println(time);
		else
			System.out.println("IMPOSSIBLE");
	}
}
