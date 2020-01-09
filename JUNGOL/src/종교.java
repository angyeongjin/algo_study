import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 종교 {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		makeSet();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			unionSet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int cnt = 0;
		for (int i = 1; i < parent.length; i++) {
			if (parent[i] == i) cnt++;
		}
		
		System.out.println(cnt);
	}

	private static void makeSet() {
		for (int i = 1; i < parent.length; i++)
			parent[i] = i;
	}

	private static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if (x!=y)
			parent[y] = x;
	}

	private static int findSet(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = findSet(parent[x]);
	}
}
