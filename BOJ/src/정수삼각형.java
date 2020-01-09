import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수삼각형 {
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		dp =new int[n][];
		dp[0] = new int[] {Integer.parseInt(br.readLine())};
		for (int i = 1; i < n; i++) {
			dp[i] = new int[i+1];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (j == 0) dp[i][j] = dp[i-1][j] + temp; // 1
				else if (j == i) dp[i][j] = dp[i-1][j-1] + temp; // 마지막
				else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + temp;
			}
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[n-1][i]);
		}
		for (int[] d : dp)
			System.out.println(Arrays.toString(d));
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
