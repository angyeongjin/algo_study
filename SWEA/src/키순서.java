import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 키순서 {
	static Node[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			arr = new Node[n+1];
			int cnt = 0;
			
			for (int i = 1; i <= n; i++)
				arr[i] = new Node(i);
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); // a가 b보다 작다
				int b = Integer.parseInt(st.nextToken());
				arr[a].upper.add(arr[b]);
				arr[b].lower.add(arr[a]);
			}
			
			visited = new boolean[n+1];
			for (int i = 1; i <= n; i++) {
				Arrays.fill(visited, false);
				int lowerCnt = countLower(arr[i]);
				int upperCnt = countUpper(arr[i]);
				//System.out.println(lowerCnt + " " + upperCnt);
				if (lowerCnt+upperCnt == n-1)
					cnt++;
				//System.out.println();
			}
			System.out.println("#" + ti + " " + cnt);
		}

	}
	private static int countUpper(Node curr) {
		visited[curr.data] = true;
		//System.out.println(curr.data);
		if (curr.upper.isEmpty()) return 0;
		int cnt = 0;
		for (int i = 0; i < curr.upper.size(); i++) {
			if (!visited[curr.upper.get(i).data])
				cnt += countUpper(curr.upper.get(i))+1;
		}
		return cnt;
	}
	private static int countLower(Node curr) {
		visited[curr.data] = true;
		//System.out.println(curr.data);
		if (curr.lower.isEmpty()) return 0;
		int cnt = 0;
		for (int i = 0; i < curr.lower.size(); i++) {
			if (!visited[curr.lower.get(i).data])
				cnt += countLower(curr.lower.get(i))+1;
		}
		return cnt;
	}
	static class Node {
		List<Node> lower = new ArrayList<>();
		List<Node> upper = new ArrayList<>();
		int data;
		public Node(int data) {
			this.data = data;
		}
	}
}


