import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영식이와친구들 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		int idx = 0;
		int cnt = 0;

		while (true) {
			arr[idx]++;
			if (arr[idx] == m)
				break;
			if (arr[idx] % 2 == 1) {
				idx = (idx+l)%n;
			} else {
				idx = (idx-l+n)%n;
			}
			cnt++;
		}

		System.out.println(cnt);
	}
}
