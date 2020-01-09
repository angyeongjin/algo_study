import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 여행가자 {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		makeSet(n);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int conn = Integer.parseInt(st.nextToken());
				if (conn == 1)
					unionSet(i, j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		boolean flag = false;
		for (int i = 1; i < m; i++) {
			int next = Integer.parseInt(st.nextToken())-1;
			if (findSet(start) != findSet(next)) {
				flag = true; break;
			}
		}
		if (flag) bw.write("NO");
		else 	  bw.write("YES");
		bw.flush();
	}

	private static void makeSet(int n) {
		parent = new int[n];
		for (int i = 1; i < n; i++)
			parent[i] = i;
	}

	private static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (x != y)
			parent[y] = x;
	}

	private static int findSet(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = findSet(parent[x]);
	}

}
