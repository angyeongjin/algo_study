import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 창용마을무리의개수 {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int ti = 1; ti <= t; ti++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			makeSet();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				unionSet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Set<Integer> group = new HashSet<>();
			for (int i = 1; i < parent.length; i++) {
				group.add(findSet(i));
			}
			System.out.println("#" + ti + " " + group.size());
		}
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

	private static void makeSet() {
		for (int i = 1 ; i < parent.length; i++) {
			parent[i] = i;
		}
	}

}
