import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 제로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int t = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= t; ti++) {
			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				int n = Integer.parseInt(br.readLine());
				if (n == 0) {
					if (!stack.isEmpty()) stack.pop();
				} else {
					stack.push(n);
				}
			}
			int answer = 0;
			while(!stack.isEmpty()) {
				answer += stack.pop();
			}
			bw.write("#" + ti + " " + answer + "\n");
		}
		bw.flush();
	}
}
