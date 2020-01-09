import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 올해의조련사 {
	static char[] arr;
	static StringBuilder result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			arr = new char[n];
			result = new StringBuilder();
			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine().charAt(0);
			}
			int preIdx = 0;
			int postIdx = n - 1;
			while (preIdx < postIdx) {
				if (arr[preIdx] < arr[postIdx]) {
					result.append(arr[preIdx]);
					preIdx++;
				} else if (arr[preIdx] > arr[postIdx]) {
					result.append(arr[postIdx]);
					postIdx--;
				} else {
					int[] idx = findPriorityIdx(preIdx, postIdx);
					preIdx = idx[0];
					postIdx = idx[1];
				}
			}
			if (preIdx == postIdx)
				result.append(arr[preIdx]);
			bw.write("#" + ti + " " + result + "\n");
		}
		bw.flush();
	}

	private static int[] findPriorityIdx(int preIdx, int postIdx) {
		int[] idx = new int[] { preIdx, postIdx };
		while (arr[preIdx] == arr[postIdx] && preIdx < postIdx) {
			preIdx++;
			postIdx--;
		}
		if (arr[preIdx] < arr[postIdx]) {
			result.append(arr[idx[0]]);
			idx[0]++;

		} else {
			result.append(arr[idx[1]]);
			idx[1]--;
		}
		return idx;
	}

}
