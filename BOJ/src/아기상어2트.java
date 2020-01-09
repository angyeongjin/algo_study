import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어2트 {
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result = 0;
		int n = Integer.parseInt(br.readLine());
		int[][] field = new int[n][n];
		boolean[][] v = new boolean[n][n];
		Idx babyShark = null; // 아기상어 인덱스
		int babySharkSize = 2; // 아기상어 크기
		int eatFishCnt = 0; // 아기상어가 먹은 물고기 개수
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if (field[i][j] == 9)
					babyShark = new Idx(i, j);
			}
		}
		boolean isNotFish = false;
		Queue<Idx> q = new LinkedList<>();
		List<Idx> eatFish = new ArrayList<>();
		while(!isNotFish) {
			int time = 0;
			for (int i = 0; i < n; i++)
				Arrays.fill(v[i], false);
			eatFish.clear();
			v[babyShark.y][babyShark.x] = true;
			q.offer(new Idx(babyShark.y, babyShark.x));
			while(!q.isEmpty()) {
				boolean flag = false;
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Idx idx = q.poll();
					for (int j = 0; j < 4; j++) {
						int ty = idx.y + dy[j];
						int tx = idx.x + dx[j];
						if (0 <= ty && ty < n && 0 <= tx && tx < n) {
							// 0이면 집어넣고, 못먹는물고기면 집어넣지말고, 먹을수있는 물고기면 arr집어넣고 flag true
							// 크기가 같으면 지나갈 수만 있음
							if (v[ty][tx]) continue;
							if (field[ty][tx] == 0 || field[ty][tx] == babySharkSize) { // 집어넣고
								v[ty][tx] = true;
								q.offer(new Idx(ty, tx));
							} else if (field[ty][tx] < babySharkSize) {
								v[ty][tx] = true;
								eatFish.add(new Idx(ty, tx));
								flag = true;
							}
						}
					}
				}
				time++;
				if (flag) q.clear();
			}
			// 물고기 먹고 상어 위치바꿈
			if (eatFish.size() > 0) {
				result += time;
				Idx finalEatFish = eatFish.get(0);
				for (int i = 1; i < eatFish.size(); i++) {
					if (finalEatFish.y > eatFish.get(i).y) {
						finalEatFish = eatFish.get(i);
					} else if (finalEatFish.y == eatFish.get(i).y && finalEatFish.x > eatFish.get(i).x) {
						finalEatFish = eatFish.get(i);
					}
				}
				field[finalEatFish.y][finalEatFish.x] = 9;
				field[babyShark.y][babyShark.x] = 0;
				eatFishCnt++;
				babyShark.y = finalEatFish.y;
				babyShark.x = finalEatFish.x;
				if (eatFishCnt == babySharkSize) {
					eatFishCnt = 0;
					babySharkSize++;
				}
			} else {
				isNotFish = true;
			}
		}
		System.out.println(result);
	}
	
	static class Idx {
		int y;
		int x;
		public Idx(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
