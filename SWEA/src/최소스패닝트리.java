import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 최소스패닝트리 {
	static int[] parent;
	static long result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		List<Edge> Edges = new ArrayList<>();
		
		for (int ti = 1; ti <= t; ti++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			Edges.clear();
			result = 0;
			parent = new int[n+1];
			makeSet();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				Edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Collections.sort(Edges);
			for (Edge e : Edges) {
				unionSet(e);
			}
			System.out.println("#" + ti + " " + result);
		}
	}
	
	private static void unionSet(Edge e) {
		int x = findSet(e.x);
		int y = findSet(e.y);
		if (x != y) {
			parent[y] = x;
			result += e.weight;
		}
	}

	private static int findSet(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = findSet(parent[x]);
	}

	private static void makeSet() {
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	static class Edge implements Comparable<Edge> {
		int x;
		int y;
		int weight; // 가중치
		
		Edge (int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
}
