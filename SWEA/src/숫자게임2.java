import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 숫자게임2 {
	static int maxCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int ti = 1; ti <= t; ti++) {
			String str = br.readLine();
			maxCnt = 0;
			
			if (str.length() >= 2)
				slice(new ArrayList<String>(), str, 1);
			System.out.println("#" + ti + " " + maxCnt);
		}
	}

	private static void slice(ArrayList<String> subStr, String str, int cnt) {
		for (int i = 1; i <= str.length(); i++) {
			String sub = str.substring(0, i);
			subStr.add(sub);
			if (i != str.length())
				slice(subStr, str.substring(i), cnt);
			else if (subStr.size() > 1) {
				int mul = 1;
				for (String s : subStr)
					mul *= Integer.parseInt(s);
				if (mul >= 10) {
					slice(new ArrayList<String>(), String.valueOf(mul), cnt+1);
				}
				else { maxCnt = Math.max(maxCnt, cnt); subStr.remove(sub); return; }
			}
			subStr.remove(sub);
		}
	}
}
