import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수 {
	static int[] fibo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			fibo = new int[n+1];
			fibo[0] = 0;
			if (n==0) System.out.println("1 0");
			if (n>0) { 
				fibo[1] = 1;
				fibonacci(n);
				System.out.println(fibo[n-1] + " " + fibo[n]);
			}
		}
	}

	static int fibonacci(int n) {
		if (fibo[n] != 0) return fibo[n];
		if (n == 0) return fibo[0];
		else if (n == 1) return fibo[1];
		return fibo[n] = fibonacci(n-1) + fibonacci(n-2);
	}
}
