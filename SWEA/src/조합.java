import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 조합 {
	static final int p = 1234567891;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		long result = 0;
		
		for (int ti = 1; ti <= t; ti++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			System.out.println("n! : " + factorial(n));
			System.out.println("r! : " + factorial(r));
			System.out.println("(n-r)! : " + factorial(n-r));
			long rdiv = div(factorial(r));
			long nrdiv = div(factorial(n-r));
			System.out.println(rdiv + " " + nrdiv);
			result = ((factorial(n) * div(factorial(r)))%p * div(factorial(n-r))) % p;
			
			bw.write("#" + ti + " " + result + "\n");
		}
		bw.flush();
	}
	
	private static long div(long n) {
		int k = p-2;
		long temp = 1;
		while (k > 1) {
			if (k % 2 == 1) {
				temp = (temp*n) % p;
			}
			k = (k/2);
			n = ((n * n) % p);
		}
		// 여기 더 처리해줘야해!
		
		return (temp * n) % p;
	}

	public static long factorial(int n) {
		long result = n;
		for (int i = n-1; i > 0; i--) {
			result = ( result * i ) % p ;
		}
		return result;
	}

}
