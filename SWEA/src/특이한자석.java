

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 특이한자석 {
	static int[][] gear = new int[4][8];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= t; ti++) {
			int K = Integer.parseInt(br.readLine()); // 톱니바퀴 회전 수
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					gear[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] idx = new int[4][3];
			for (int i = 0; i < 4; i++) {
				idx[i][0] = 0; // top index
				idx[i][1] = 2; // right index
				idx[i][2] = 6; // left index
			}
			boolean[] isRotate = new boolean[4];
			for (int i = 0; i < K; i++) {
				Arrays.fill(isRotate, false);
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken()) - 1; // 움직일 톱니바퀴 번호
				int d = Integer.parseInt(st.nextToken()); // 방향
				isRotate[n] = true;
				for (int j = n-1; j >= 0; j--) { // 시작 톱니바퀴의 왼쪽 검사
					if (gear[j][idx[j][1]] != gear[j+1][idx[j+1][2]]) {
						isRotate[j] = true;
					} else break; // 변동이 없으면 다음꺼도 변동 x
				}
				for (int j = n+1; j < 4; j++) { // 시작 톱니바퀴의 오른쪽 검사
					if (gear[j][idx[j][2]] != gear[j-1][idx[j-1][1]]) {
						isRotate[j] = true;
					} else break;
				}
				for (int j = 0; j < 4; j++) {
					if (isRotate[j]) {
						int dir = d;
						if (n%2 != j%2) dir = -dir;
						if (dir == 1) { // 시계방향
							for (int k = 0; k < 3; k++)
								idx[j][k] = idx[j][k] - dir != -1 ? idx[j][k] - dir : 7;
						}
						else if (dir == -1) { // 반시계방향
							for (int k = 0; k < 3; k++)
								idx[j][k] = idx[j][k] - dir != 8 ? idx[j][k] - dir : 0;
						}

					}
				}
			}
			int score = 0;
			for (int i = 0; i < 4; i++) { // 점수계산
				if (gear[i][idx[i][0]] == 1) {
					score += Math.pow(2, i);
				}
			}
			bw.write("#" + ti + " " + score + "\n");
		}
		bw.flush();
	}
 
}
