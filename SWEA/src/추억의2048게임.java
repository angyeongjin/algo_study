import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 추억의2048게임 {
	static int[][] field;
	static boolean[][] isJoin;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= t; ti++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String command = st.nextToken();
			field = new int[n][n];
			isJoin = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			switch (command) {
			case "left":
				for (int i = 0; i < n; i++) {
					for (int j = 1; j < n; j++) {
						int idx = j;
						while (idx > 0) {
							if (field[i][idx-1] == 0) {
								field[i][idx-1] = field[i][idx];
								field[i][idx] = 0;
							}
							else break;
							idx--;
						}
						if (idx > 0 && field[i][idx-1] == field[i][idx] && !isJoin[i][idx-1]) {
							field[i][idx-1] *= 2;
							isJoin[i][idx-1] = true;
							field[i][idx] = 0;
						}
					}
				}
				break;
			case "right":
				for (int i = 0; i < n; i++) {
					for (int j = n-2; j >= 0; j--) {
						int idx = j;
						while (idx < n-1) {
							if (field[i][idx+1] == 0) {
								field[i][idx+1] = field[i][idx];
								field[i][idx] = 0;
							}
							else break;
							idx++;
						}
						if (idx < n-1 && field[i][idx+1] == field[i][idx] && !isJoin[i][idx+1]) {
							field[i][idx+1] *= 2;
							isJoin[i][idx+1] = true;
							field[i][idx] = 0;
						}
					}
				}
				break;
			case "up":
				for (int i = 0; i < n; i++) {
					for (int j = 1; j < n; j++) {
						int idx = j;
						while (idx > 0) {
							if (field[idx-1][i] == 0) {
								field[idx-1][i] = field[idx][i];
								field[idx][i] = 0;
							}
							else break;
							idx--;
						}
						if (idx > 0 && field[idx-1][i] == field[idx][i] && !isJoin[idx-1][i]) {
							field[idx-1][i] *= 2;
							isJoin[idx-1][i] = true;
							field[idx][i] = 0;
						}
					}
				}
				break;
			case "down":
				for (int i = n-1; i >= 0; i--) {
					for (int j = n-2; j >= 0; j--) {
						int idx = j;
						while (idx < n-1) {
							if (field[idx+1][i] == 0) {
								field[idx+1][i] = field[idx][i];
								field[idx][i] = 0;
							}
							else break;
							idx++;
						}
						if (idx < n-1 && field[idx+1][i] == field[idx][i] && !isJoin[idx+1][i]) {
							field[idx+1][i] *= 2;
							isJoin[idx+1][i] = true;
							field[idx][i] = 0;
						}
					}
				}
				break;
			}
			
			bw.write("#" + ti + "\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					bw.write(field[i][j] + " ");
				}
				bw.write("\n");
			}
				
		}
		bw.flush();
	}

}
