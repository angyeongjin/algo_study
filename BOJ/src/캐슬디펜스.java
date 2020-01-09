import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 캐슬디펜스 {
	static int[][] field; // -1: 확인한 장소 0:빈장소 1:적 2:궁수 3:성벽 4:확인한 적
	static int[] dy = {0, -1, 0}; // 왼쪽 먼저 확인
	static int[] dx = {-1, 0, 1};
	static boolean[][][] visited;
	static int dir;
	static int maxKillEnemy; // = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		field = new int[n+1][m];
		visited = new boolean[3][n+1][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(field[field.length-1], 3);
		// 궁수를 랜덤한 3개의 위치에 놓기 (조합)
		comb(0, 0);

	}

	private static void comb(int depth, int select) {
		if (depth > field[field.length-1].length) {
			System.out.println(depth);
			return;
		}
		
		if (select == 3) {
			// 게임 시작
			for (int i = 0; i < field.length-1; i++) {
				start();
				// 한번의 턴이 끝나면 field를 밑으로 한칸 땡겨준 후 재시작
				lowerField();
			}
			
			return;
		}
		
		for (int i = depth; i < field[0].length; i++) {
			field[field.length-1][i] = 2;
			comb(i+1, select+1);
			field[field.length-1][i] = 3;
		}
	}

	private static void lowerField() {
		// TODO Auto-generated method stub
		
	}

	private static void start() {
		// 게임 시작, 궁수로부터 떨어진 거리 1~dir 탐색, 발견하면 표시해주고 cnt++
		// 이미 표시되어있다면 카운트x
		// bfs로 작성할 경우 왼쪽, 위, 오른쪽 순서로 탐색하면 가장 왼쪽이 먼저 큐에 들어가므로
		// 굳이 확인해주지 않아도 가장 가까운 왼쪽 적을 제외할 수 있다
		Queue<int[]> q = new LinkedList<>();
		int dirCnt = 0;
		int killEnemy = 0;
		for (int i = 0; i < field[0].length; i++) {
			if (field[field.length-1][i] == 2)
				q.offer(new int[] {field.length-1, i});
		}
		
		while (!q.isEmpty() && dirCnt != dir) {
			dirCnt++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] idx = q.poll();
				for (int j = 0; j < 3; j++) {
					int ty = idx[0] + dy[j];
					int tx = idx[1] + dx[j];
					if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
						if (field[ty][tx] == 1) {
							field[ty][tx] = 4;
							killEnemy++;
						}
						else if (field[ty][tx] == 0) {
							field[ty][tx] = -1;
							q.offer(new int[] {ty, tx});
							
						}
					}
				}
			}
			
		}
	}
}
