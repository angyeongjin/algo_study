import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 재관이의대량할인 {
	static int[] arr;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			result = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for (int i = 0; i < n%3; i++) {
				result+=arr[i];
			}
			int mod = n%3;
			for (int i = n%3; i < n; i++) {
				if ((i)%3!=mod) result+=arr[i];
			}
			bw.write("#" + ti + " " + result + "\n");
		}
		bw.flush();
	}

}
