import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 회전초밥 {
	static int[] arr;
	static int[] kinds;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		arr = new int[N];
		kinds = new int[d+1];
		int cnt = 0;
		for (int i = 0, j = 0; i < N; i++, j++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (j < k) {
				if (kinds[arr[i]]++ == 0) cnt++;
			}
		}
		int left = 0; int right = k;
		for (int i = 0; i < N; i++, left++, right++) {
			if (left == N) left = 0;
			if (right == N) right = 0;
			if (arr[left] != arr[right]) {
				// 삭제
				if (--kinds[arr[left]] == 0) cnt--;
				// 추가
				if (kinds[arr[right]]++ == 0) cnt++;
			}
			result = Math.max(result, kinds[c] == 0 ? cnt+1 : cnt);
		}
		bw.write(result+"");
		bw.flush();
	}

}
