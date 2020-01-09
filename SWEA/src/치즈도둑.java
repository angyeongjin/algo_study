import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 치즈도둑 {
	public static int[][] cheese;
	public static int[][] temp;
	public static boolean isExistCheese;
	public static int[] dy = {0,1,0,-1};
	public static int[] dx = {1,0,-1,0};// 우, 하, 좌, 상
	public static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		int t = Integer.parseInt(br.readLine());

		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			int maxCheeseChunks = 1;
			int cnt;
			cheese = new int[n][n];
			temp = new int[n][n];
			for (int i = 0; i < n; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < str.length; j++) {
					cheese[i][j] = Integer.parseInt(str[j]);
				}
			}

			for (int i = 1; i <= 100; i++) { // 100일동안 먹기
				
				// 요정이 현재 일수의 치즈를 먹는다
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						if (cheese[j][k] == i) 
							cheese[j][k] = 0;
					}
				}

				// 덩어리 개수를 센다
				for (int j = 0; j < cheese.length; j++)
					temp[j] = cheese[j].clone();
				
				cnt = 0;
				for (int j = 0; j < n; j++) {  
					for (int k = 0; k < n; k++) {
						if (temp[j][k] != 0) {
							countCheeseChunks(j, k);
							isExistCheese = true;
							cnt++;
						}
					}
				}
				
				// 만약 덩어리가 없다면 (= 치즈를 다 먹었다면) 종료
				if (!isExistCheese)
					break;
				
				if (maxCheeseChunks < cnt)	// max가 현재 센 덩어리개수보다 작으면
					maxCheeseChunks = cnt;	// 현재 센 덩어리개수를 max에 넣어줌
			}
			
			System.out.println("#" + ti + " " + maxCheeseChunks);
		}
	}

	private static void countCheeseChunks(int y, int x) {
		Queue<Idx> q = new LinkedList<>();
		q.offer(new Idx(y, x));
		temp[y][x] = 0;	// 확인한 덩어리는 0으로 처리 (=visited)
		
		int ty;
		int tx;

		while(!q.isEmpty()) {
			Idx idx = q.poll();
			for (int i = 0; i < 4; i++) {
				ty = idx.y + dy[i];
				tx = idx.x + dx[i];
				if (0 <= ty && ty < temp.length && 0 <= tx && tx < temp.length) {
					if (temp[ty][tx] != 0) {
						q.offer(new Idx(ty, tx));
						temp[ty][tx] = 0;
					}
				}
			}
		}
	}
}

class Idx {
	int y;
	int x;

	public Idx(int y, int x) {this.y = y; this.x = x;}
}