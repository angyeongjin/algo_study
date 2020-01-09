import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 조만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		for (int ti = 1; ti <= t; ti++) {
			double n = s.nextFloat();
			double k = s.nextFloat();
			int[] arr = new int[(int)k];
			double average;

			System.out.print("#" + ti + " ");

			if (n%2==0) {
				average = ((n*k+1)/2)*n;
				for (int i = 0; i < k; i++)
					System.out.print((int)average + " ");
			}
			else {
				average = (((n-1)*k+1)/2)*(n-1);
				Arrays.fill(arr, (int) average);
				int rank = (int) (n*k-k);
				for (int i = 0; i < arr.length; i++) {
					arr[i] += ++rank;
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
	}
}

