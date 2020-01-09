import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 롤케이크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine()); // 롤케이크의 길이
		int n = Integer.parseInt(br.readLine()); // 방청객의 수
		int[] cake = new int[l+1];
		int[] audience = new int[n+1]; // 방청객이 실제로 받은 롤케이크를 저장하는 배열
		int maxWantCake = Integer.MIN_VALUE;
		int maxCake = Integer.MIN_VALUE;
		int maxWantCakeAudience = 0; // 가장 많은 조각을 받기를 원하는 방청객의 번호
		int maxCakeAudience = 0; // 실제로 가장 많은 조각을 받은 방청객의 번호

		StringTokenizer st;
		for (int i = 1; i < audience.length; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if (maxWantCake < k-p+1) {
				maxWantCake = k-p+1;
				maxWantCakeAudience = i;
			}

			for (int j = p; j <= k; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
				}
			}
		}

		for (int i = 1; i < cake.length; i++) {
			if (cake[i] != 0) {
				audience[cake[i]]++;
			}
		}
		
		for (int i = 1; i < audience.length; i++) {
			if (maxCake < audience[i]) {
				maxCake = audience[i];
				maxCakeAudience = i;
			}
		}

		System.out.print(maxWantCakeAudience + "\n" + maxCakeAudience);
	}
}
