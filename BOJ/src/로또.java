import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 로또 {
	static int[] arr;
	static int[] selectNumArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);

			if (n == 0) // 0이 들어오면 종료
				break;

			arr = new int[n];
			for (int i = 1; i < str.length; i++) {
				arr[i-1] = Integer.parseInt(str[i]);
			}

			selectNumArr = new int[6];
			lottoNumSelect(0, 0);
			System.out.println();
		}
	}
	private static void lottoNumSelect(int next, int cnt) {
		if (cnt == 6) {
			for (int num : selectNumArr)
				System.out.print(num + " ");
			System.out.println();
			return;
		}

		if (next < arr.length) {
			selectNumArr[cnt] = arr[next];
			lottoNumSelect(next+1, cnt+1);
			lottoNumSelect(next+1, cnt);
		}
	}
}
