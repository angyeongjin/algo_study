import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 탈출 {
	static char[][] field;
	static int[] dy = {0, -1, 0, 1};  // 좌상우하
	static int[] dx = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read1 = br.readLine().split(" ");
		int n = Integer.parseInt(read1[0]);
		int m = Integer.parseInt(read1[1]);
		field = new char[n][m];

		int[] idx = null;
		List<int[]> fidxs = new ArrayList<>();

		// 필드정보를 읽으면서 고슴도치, 집, 물의 위치를 찾으면 인덱스에 저장
		for (int i = 0; i < n; i++) {
			char[] read2 = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				switch (read2[j]) {
				case 'S':
					idx = new int[] {i, j};
					break;
				case '*':
					fidxs.add(new int[] {i, j});
					break;
				}
				field[i][j] = read2[j];
			}
		}
		exit(idx, fidxs);
	}
	
	private static void exit(int[] startIdx, List<int[]> fidxs) {
		Queue<int[]> q = new LinkedList<>();  // 고슴도치의 이동경로
		Queue<int[]> fq = new LinkedList<>(); // 물의 이동경로
		boolean isExit = false; // 탈출가능한지 체크
		int time = 0; // 탈출에 걸린 시간
		q.offer(startIdx);
		field[startIdx[0]][startIdx[1]] = ',';
		for (int[] fidx : fidxs) 
			fq.offer(fidx);
		
		w:while (!q.isEmpty() || !fq.isEmpty()) {
			time++;
			int fsize = fq.size();
			for (int i = 0; i < fsize; i++) { // 물 먼저 다 퍼짐
				int[] idx = fq.poll();
				for (int j = 0; j < 4; j++) {
					int ty = idx[0] + dy[j];
					int tx = idx[1] + dx[j];
					if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
						if (field[ty][tx] == '.' || field[ty][tx] == ',') { // 길 or 고슴도치가 지나간길
							field[ty][tx] = '*';
							fq.offer(new int[] {ty, tx});
						}
					}
				}
			}
			int size = q.size();
			for (int i = 0; i < size; i++) { // 고슴도치 이동
				int[] idx = q.poll();
				for (int j = 0; j < 4; j++) {
					int ty = idx[0] + dy[j];
					int tx = idx[1] + dx[j];
					if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
						if (field[ty][tx] == '.') {
							field[ty][tx] = ',';
							q.offer(new int[] {ty, tx});
						}
						else if (field[ty][tx] == 'D') {
							isExit = true;
							break w; // 탈출하면 더이상 탐색할 필요 없으니까 while문 탈출
						}
					}
				}
			}
		}
		
		if (isExit)
			System.out.println(time);
		else
			System.out.println("KAKTUS");
	}
}
