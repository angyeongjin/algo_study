import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 반장선출 {
	static boolean[] alpha;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			char[][] name = new char[n][];
			alpha = new boolean[26];
			int maxCnt = 0;
			char[] result = null;
			for (int i = 0; i < n; i++) {
				name[i] = br.readLine().toCharArray();
			}
			for (int i = 0; i < name.length; i++) {
				Arrays.fill(alpha, false);
				int cnt = 0;
				for (int j = 0; j < name[i].length; j++) {
					if ('A' <= name[i][j] && name[i][j] <= 'Z' && !alpha[name[i][j]-'A']) {
						alpha[name[i][j]-'A'] = true;
						cnt++;
					}
				}
				if (maxCnt < cnt) {
					maxCnt = cnt;
					result = name[i];
				}
				else if (maxCnt == cnt) {
					String s1 = String.valueOf(result);
					String s2 = String.valueOf(name[i]);
					result = s2.compareTo(s1)<0 ? name[i] : result;
				}
			}
			System.out.print("#" + ti + " ");
			System.out.println(result);
		}
	}
}
