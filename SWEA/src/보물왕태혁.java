import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 보물왕태혁 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] arr;
		int result;
		String[] str;
		
		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			
			str = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Arrays.sort(arr);
			
			if (n % 2 == 1) { // 홀수인 경우
				result = arr[arr.length/2] * arr[arr.length/2];
			}
			else { // 짝수인 경우
				result = arr[0] * arr[arr.length-1];
			}
			System.out.println("#" + ti + " " + result);
		}
	}
}
