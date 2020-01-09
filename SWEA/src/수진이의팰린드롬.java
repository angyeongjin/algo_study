import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 수진이의팰린드롬 {
	static char[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= t; ti++) {
			arr = br.readLine().toCharArray();
			Arrays.sort(arr);
			int cnt = 0;
			String permStr = new String(arr);
			for (int i = 1; i <= permStr.length(); i++) {
				for (int j = 0; j < permStr.length()-i+1; j++) {
					String subStr = permStr.substring(j, j+i);
					boolean flag = false;
					for (int k = 0; k < subStr.length()/2; k++) {
						if (subStr.charAt(k) != subStr.charAt(subStr.length()-k-1)) {
							flag = true;
							break;
						}
					}
					if (!flag) cnt++;
				}
			}
			bw.write("#" + ti + " " + cnt + "\n");
		}
		bw.flush();
	}
}
