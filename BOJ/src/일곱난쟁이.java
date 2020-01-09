import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이 {
	static int[] arr;
	static int[] selectArr;
	static boolean isFindArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		selectArr = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		comb(0, 0);
	}

	private static void comb(int depth, int n) {
		if (arr.length - depth < selectArr.length - n || isFindArr)
			return;
		
		if (n == selectArr.length) {
			int sum = 0;
			for (int i = 0; i < selectArr.length; i++) {
				sum += selectArr[i];
			}
			
			if (sum == 100) {
				isFindArr = true;
				for (int num : selectArr)
					System.out.println(num);
			}
			return;
		}
		
		selectArr[n] = arr[depth];
		comb(depth+1, n+1);
		comb(depth+1, n);
	}
}
