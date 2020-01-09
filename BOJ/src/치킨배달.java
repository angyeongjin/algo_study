import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치킨배달 {
	static int[][] field;
	static List<int[]> house = new LinkedList<>();
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		field = new int[n][n];
		result = Integer.MAX_VALUE;
		int chickenCnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if (field[i][j] == 2) chickenCnt++;
				else if (field[i][j] == 1) house.add(new int[] {i, j});
			}
		}
		select(0, chickenCnt-m, 0, 0);
		bw.write(String.valueOf(result));
		bw.flush();
	}
	
	private static void select(int selectCnt, int limit, int y, int x) {
		if (selectCnt == limit) {
			int cnt = 0;
//			for (int[] f : field)
//				System.out.println(Arrays.toString(f));
//			System.out.println();
//			for (int[] idx : house) {
//				cnt += CalcChickenDis(idx);
//			}
//			result = Math.min(result, cnt);
			return;
		}

		for (int i = y; i < field.length; i++) {
			int startX = 0;
			if (i == y) startX = x;
			for (int j = startX; j < field[0].length; j++) {
				if (field[i][j] == 2) {
					field[i][j] = 0;
					select(selectCnt+1, limit, i, j);
					field[i][j] = 2;
				}
			}
		}
	}

	private static int CalcChickenDis(int[] house) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[field.length][field[0].length];
		v[house[0]][house[1]] = true;
		q.offer(house);
		int cnt = 0;
		w:while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				int[] idx = q.poll();
				for (int j = 0; j < 4; j++) {
					int ty = idx[0] + dy[j];
					int tx = idx[1] + dx[j];
					if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
						if (field[ty][tx] == 2) break w;
						else {
							v[ty][tx] = true;
							q.offer(new int[] {ty, tx});
						}
					}
				}
			}
		}
		return cnt;
	}

}
