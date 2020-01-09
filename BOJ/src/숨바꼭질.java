import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);

		System.out.println(findYoungerBrother(n, k));

	}

	static int findYoungerBrother(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[100_001];
		int fastFind = 0;
		q.add(n);
		visited[n] = true;

		int tx;

		while (true) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				tx = q.poll();
				if (tx == k)
					return fastFind;
				if (tx<k && tx<50_001) { // tx*2가 범위를 벗어나지 않을경우
					if (!visited[tx*2]) {
						q.add(tx*2);
						visited[tx*2] = true;
					}
				}
				if (tx<k && tx<100_000) { // tx+1가 범위를 벗어나지 않을경우
					if (!visited[tx+1]) {
						q.add(tx+1);
						visited[tx+1] = true;
					}
				}
				if (tx>0) {
					if (!visited[tx-1]) { // tx-1가 범위를 벗어나지 않을경우
						q.add(tx-1);
						visited[tx-1] = true;
					}
				}
			}
			fastFind++;
		}
	}
}
