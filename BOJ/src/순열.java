import java.util.Arrays;
import java.util.Scanner;

public class 순열 {
	public static int[] arr;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		arr = new int[n];
		makeArray(n);
		permutation(0);

	}

	private static void makeArray(int n) {
		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
	}

	private static void permutation(int depth) {
		if (depth == arr.length-1) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		
		for (int i = depth; i < arr.length; i++) {
			swap(i, depth);
			permutation(depth+1);
			swap(i, depth);
		}
	}

	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;	
	}
}
