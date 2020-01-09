import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크 {
	static int[][] field;
	static int[] arr;
	static int[] team1;
	static int[] team2;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		field = new int[n][n];
		arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = i;
		int half = n/2;
		team1 = new int[half];
		team2 = new int[half];
		result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0, half);
		System.out.println(result);
	}

	static void comb(int select, int depth, int limit) {
		if (select >= limit) {
			int idx1 = 0;	int idx2 = 0;
			for (int i = 0; i < arr.length; i++) {
				if (idx1>=team1.length) {
					team2[idx2] = i;
					idx2++;
				} else {
					if (team1[idx1] != i) { 
						team2[idx2] = i;
						idx2++;
					} else {
						idx1++;
					}
				}
			}
			int team1Score = calcScore(team1);
			int team2Score = calcScore(team2);
			result = Math.min(result, Math.abs(team1Score-team2Score));
			return;
		}
		if (depth >= arr.length) return;
		team1[select] = arr[depth];
		comb(select+1, depth+1, limit);
		if (depth!=0)
			comb(select, depth+1, limit);
	}

	private static int calcScore(int[] team) {
		int score = 0;
		for (int i = 0; i < team.length; i++) {
			for (int j = 0; j < team.length; j++) {
				score += field[team[i]][team[j]];
			}
		}
		return score;
	}

}
