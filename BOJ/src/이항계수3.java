import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 이항계수3 {
static final int p = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		long result = 0;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		if (n==r || r==0) result = 1;
		else result = ((factorial(n) * div(factorial(r))) % p * div(factorial(n - r))) % p;

		bw.write(result + "\n");
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
