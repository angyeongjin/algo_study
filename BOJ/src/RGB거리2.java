import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RGB거리2 {
	static int[][] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		dp = new int[n][3];
		String[] read;
		int result = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			read = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(read[0]);
			arr[i][1] = Integer.parseInt(read[1]);
			arr[i][2] = Integer.parseInt(read[2]);
		}
		
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 3; i++) {
				if (i != k) {dp[0][i] = 10000000;} 
				else {dp[0][i] = arr[0][i];}
			}
			for (int i = 1; i < n; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+arr[i][2];
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 3; i++) {
				if (i != k) {
					if (min > dp[n-1][i]) {
						min = dp[n-1][i];
					}
				}
			}
			result = Math.min(result, min);
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
