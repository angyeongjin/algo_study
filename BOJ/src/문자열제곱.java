import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 문자열제곱 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			char[] str = br.readLine().toCharArray();
			if (str[0] == '.') break;
			int result = 1;
			int maxSize = 1; // 같은 문자열 최대 길이
			int idx = 0; // char 비교 idx
			for (int i = 1; i < str.length; i++) {
				if (str[i] == str[idx]) { // 같은char들어올경우
					idx++;
				} else { // 다른char들어올경우
					maxSize = i+1;
					idx = 0;
					result = 1;
				}
				if (idx >= maxSize) {idx = 0; result++;};
			}
			if (idx == 0) bw.write(result+"\n");
			else bw.write(1+"\n");
		}
		bw.flush();
	}
}
