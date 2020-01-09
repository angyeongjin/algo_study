import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 오목 {
	static int[][] field;
	static final int N = 19;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		field = new int[N][N];
		int winTeam = 0;
		int resultY = 0;
		int resultX = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		f:for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (field[i][j] == 1 && checkWin(i, j, 1)) {
					resultY = i+1;
					resultX = j+1;
					winTeam = 1;
					break f;
				}
				else if (field[i][j] == 2 && checkWin(i, j, 2)) {
					resultY = i+1;
					resultX = j+1;
					winTeam = 2;
					break f;
				}
			}
		}
		bw.write(winTeam + "\n");
		if (winTeam != 0) bw.write(resultY + " " + resultX);
		bw.flush();
	}

	private static boolean checkWin(int y, int x, int team) {
		// 오른쪽
		for (int i = x-1; i < x-1+7; i++) {
			if (i == x-1) { 
				if (i >= 0 && field[y][i] == team) break;
			} else if (i == x-1+6) {
				if (i >= N || field[y][i] != team)
					return true;
			}
			else if (i >= N || field[y][i] != team) break;
		}
		// 아래
		for (int i = y-1; i < y-1+7; i++) {
			if (i == y-1) {
				if (i >= 0 && field[i][x] == team) break;
			}
			else if (i == y-1+6) {
				if (i >= N || field[i][x] != team) return true;
			}
			else if (i >= N || field[i][x] != team) break;
		}
		// 대각선 1
		for (int i = y-1, j = x-1; i < y-1+7 ; i++, j++) {
			if (i == y-1 && j == x-1) {
				if (i >= 0 && j >= 0 && field[i][j] == team) break;
			}
			else if (i == y-1+6) {
				if (i >= N || j >= N || field[i][j] != team) return true;
			}
			else if (i >= N || j >= N || field[i][j] != team) break;
		}
		// 대각선 2
		for (int i = y+1, j = x-1; j < x-1+7 ; i--, j++) {
			if (i == y+1 && j == x-1) {
				if (i < N && j >= 0 && field[i][j] == team) break;
			}
			else if (j == x-1+6) {
				if (i < 0 || j >= N || field[i][j] != team) return true;
			}
			else if (i < 0 || j >= N || field[i][j] != team) break;
		}
		return false;
	}

}
