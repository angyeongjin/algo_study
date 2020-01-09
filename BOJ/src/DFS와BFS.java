import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DFS와BFS {
	static Graph graph;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int start = s.nextInt();
		graph = new Graph(n+1);
		visited = new boolean[n+1];
		
		for (int i = 0; i < m; i++) {
			int vertex = s.nextInt();
			int connVertex = s.nextInt();
			graph.addVer(vertex, connVertex);
		}
		
		for (int i = 0; i < n; i++) {
			graph.adj[i].sort(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});
		}
		
		dfs(start);
		System.out.println();
		bfs(start);
	}
	
	private static void dfs(int start) {
		Arrays.fill(visited, false);	// 방문 초기화
		Stack<Integer> stack = new Stack();
		stack.push(start);
		visited[start] = true;
		
		int idx = start;
		System.out.print(idx + " ");
		
		while(!stack.isEmpty()) {
			boolean isComp = true;
			for (Integer data : graph.adj[idx]) {
				if (!visited[data]) {
					System.out.print(data + " ");
					stack.push(data);
					visited[data] = true;
					idx = data;
					isComp = false;
					break;
				}
			}
			if (isComp)
				idx = stack.pop();
		}
	}
	
	private static void bfs(int start) {
		Arrays.fill(visited, false);	// 방문 초기화
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		
		int idx = start;
		System.out.print(idx + " ");
		
		while(!queue.isEmpty()) {
			for (Integer data : graph.adj[idx]) {
				if (!visited[data]) {
					queue.offer(data);
					System.out.print(data + " ");
					visited[data] = true;
				}
			}
			idx = queue.poll();
		}
	}
}

class Graph {
	int size;
	LinkedList<Integer>[] adj;

	public Graph() {}
	public Graph(int size) {
		this.size = size;
		adj = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addVer(int i, int j) {
		adj[i].add(j);
		adj[j].add(i);
	}
}

