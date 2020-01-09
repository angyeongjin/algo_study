import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class RGB마을 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        String[] read;
        read = br.readLine().split(" ");
        dp[0][0] = Integer.parseInt(read[0]);
        dp[0][1] = Integer.parseInt(read[1]);
        dp[0][2] = Integer.parseInt(read[2]);
        for (int i = 1; i < n; i++) {
            read = br.readLine().split(" ");
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+Integer.parseInt(read[0]);
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+Integer.parseInt(read[1]);
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+Integer.parseInt(read[2]);
        }
        bw.write(String.valueOf(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2])));
        bw.flush();
    }
}