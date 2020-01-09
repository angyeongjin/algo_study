import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 수영장 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= t; ti++) {
			int[] prices = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			int[] monthlySchedule = new int[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				monthlySchedule[i] = Integer.parseInt(st.nextToken());
			}
			int[] dp = new int[12];
			dp[0] = Math.min(prices[0] * monthlySchedule[0], prices[1]);
			for (int i = 1; i < 12; i++) {
				int one = prices[0] * monthlySchedule[i];
				int month = prices[1];
				dp[i] = dp[i-1] + Math.min(one, month);
				if (i > 2) {
					dp[i] = Math.min(dp[i], dp[i-3]+prices[2]);
				} else if (i == 2) {
					dp[i] = Math.min(dp[i], prices[2]);
				}
			}
			bw.write("#" + ti + " " + Math.min(dp[11], prices[3]) + "\n");
		}
		bw.flush();
	}

}
