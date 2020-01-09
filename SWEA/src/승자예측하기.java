import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 승자예측하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long tmp, N, inc;
		for (int ti = 1; ti <= t; ti++) {
			inc = 4;
			tmp = 1;
			N = t;
			if(N == 1) {
				System.out.println("#"+t+" Bob");
			}else {
				while(tmp < N) {
					tmp += inc;
					if(N <= tmp) {
						System.out.println("#"+t+" Alice");
						break;
					}
					tmp += inc;
					if(N <= tmp) {
						System.out.println("#"+t+" Bob");
						break;
					}
					inc *= 4;
				}   
			}
		}
	}
}
