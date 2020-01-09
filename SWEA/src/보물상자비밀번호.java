import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 보물상자비밀번호 {
	static char[] arr;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= t; ti++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken())-1; // 만들수 있는 수 중 k번째로 큰 수
			Set<String> set = new TreeSet<>(Collections.reverseOrder());
			arr = br.readLine().toCharArray();
			int sideSize = n / 4;
			for (int i = 0 ; i < sideSize; i++) { // 돌리기
				int idx = i;
				for (int j = 0; j < 4; j++) { // 돌린 후 비밀번호 세기
					String temp = "";
					for (int l = j*sideSize; l < j*sideSize+sideSize; l++) {
						if (idx >= n) idx = 0;
						temp += arr[idx];
						idx++;
					}
					set.add(temp);
				}
			}
			int idx = 0;
			for (String s : set) {
				if (idx == k) {
					result = Integer.parseInt(s, 16);
				}
				idx++;
			}
			bw.write("#" + ti + " " + result + "\n");
		}
		bw.flush();
	}

}
