import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 블랙잭 {
	static int maxCardNum = 0;
	static int[] arr;
	static boolean[] flags;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		arr = new int[n];
		flags = new boolean[n];

		str = br.readLine().split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		maxCardNum(0, 0, m, 0);
		System.out.println(maxCardNum);

	}

	private static void maxCardNum(int next, int cnt, int m, int cardNum) {
		if (cnt == 3 && cardNum <= m) {
			if (maxCardNum < cardNum)
				maxCardNum = cardNum;
			return;
		} else if (cnt == 3 || cardNum > m)
			return;

		if (next < arr.length) {
			maxCardNum(next+1, cnt+1, m, cardNum+arr[next]); // 뽑는 경우
			maxCardNum(next+1, cnt, m, cardNum);		  // 뽑지 않는 경우
		}
	}
}
