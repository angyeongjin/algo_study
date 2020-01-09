import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 현주가좋아하는제곱근놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		int result = 0;
		
		for (int ti = 1; ti <= t; ti++) {
			long n = Long.parseLong(br.readLine());
			result = 0;
			while (n != 2) {
				int temp = (int) Math.sqrt(n);
				System.out.println(temp);
				if (Math.sqrt(n) != temp) {
					result += Math.pow(temp+1, 2) - n + 1;
					n = temp + 1;
				} else {
					result++;
					n = temp;
				}
			}
			bw.write("#" + ti + " " + result + "\n");
		}
		bw.flush();
	}
}
