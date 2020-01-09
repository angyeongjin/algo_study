import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어공부 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpha = new int[26];
		char[] word = br.readLine().toUpperCase().toCharArray();
		for (int i = 0; i < word.length; i++) {
			alpha[word[i]-'A']++;
		}
		int cnt = 1;
		int result = 0;
		int resultIdx = 0;
		for(int i = 0; i < alpha.length; i++) {
			if (result < alpha[i]) {
				result = alpha[i];
				resultIdx = i;
				cnt = 1;
			} else if(result == alpha[i]) {
				cnt++;
			}
		}
		if (cnt > 1) System.out.println("?");
		else System.out.println((char) (resultIdx+'A'));
	}
}
