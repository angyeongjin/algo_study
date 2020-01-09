

import java.util.Arrays;
import java.util.Scanner;

public class 소수의연속합 {
	static boolean[] prime;
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		int sum = 0;
		long start = System.currentTimeMillis();
		makePrime(n);
        long end = System.currentTimeMillis();
        System.out.println("실행 시간 : " + (double)(end-start)/1000 + "(s)");
		//for (int i = 0; i <= n; i++)
		//	if (!prime[i]) System.out.print(i + " ");
		//System.out.println(Arrays.toString(prime));
		
//		int startIdx = 0;
//		while(true) {
//			sum = 0;
//			for (Integer p : prime) {
//				sum += p;
//				if (p == n) {
//					result++;
//					break;
//				}
//			}
//		}
	}
	
	static void makePrime(int n) {
		prime = new boolean[n+1];
		prime[0] = prime[1] = true;
		for (int i = 2; i <= n; i++) {
			if (prime[i]) continue;
			for (int j = i+1; j <= n; j++) {
				if (j % i == 0) prime[j] = true;
			}
		}
	}

	static boolean isPrimeNum(int n) {
		for (int i = 2; i < n; i++) {
			if (n%i==0) return false;
		}
		return true;
	}

}
