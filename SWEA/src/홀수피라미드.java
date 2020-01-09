import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홀수피라미드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int ti = 1; ti <= t; ti++) {
			long n = Long.parseLong(br.readLine());
			System.out.println("#" + ti + " " + (f(n)-left(n))  + " " + f(n));
		}
	}

	private static long f(long n) {
		return (long) 2 * (n*n) - 1;
	}
	
	private static long left(long n) {
		return (long) 4 * n - 4;
	}
}
