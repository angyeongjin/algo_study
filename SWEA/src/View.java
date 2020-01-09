
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = 10;
		
		for (int ti = 0; ti < t; ti++) {
			int n = s.nextInt();
			int[] arr = new int[n];
			int answer = 0;
			
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			
			int max = Integer.MIN_VALUE;	// 근처 
			
			for (int i = 2; i < n-2; i++) {
				max = Integer.MIN_VALUE;
				for (int j = -2; j <=2; j++ ) {
					if (j == 0)	continue;
					if (max < arr[i+j])	max = arr[i+j];
				}
				if (arr[i] - max > 0)	answer += arr[i] - max;
			}

			System.out.println("#" + (ti+1) + " " + answer);
		}
	}
}
