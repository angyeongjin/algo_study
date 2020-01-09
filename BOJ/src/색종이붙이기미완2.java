import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 색종이붙이기미완2 {
	static char[][] field;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] paperCnt = {5,5,5,5,5};
		field = new char[10][10];
		for (int i = 0; i < 10; i++) {
			field[i] = br.readLine().replaceAll(" ", "").toCharArray();
		}

	}
}
