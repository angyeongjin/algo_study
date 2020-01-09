import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 집합의표현 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		makeSet();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 0) {
				unionSet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			else {
				if (isSameGroup(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) bw.write("YES\n");
				else bw.write("NO\n");
			}
		}
		bw.flush();
	}

	private static void makeSet() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	private static int findSet(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = findSet(parent[x]);
	}

	private static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (x != y)
			parent[y] = x;
	}

	private static boolean isSameGroup(int x, int y) {
		return findSet(x) == findSet(y) ? true : false;
	}
}