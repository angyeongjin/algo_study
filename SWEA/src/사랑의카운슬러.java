import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사랑의카운슬러 {
	static Idx[] worm;
	static Idx[] selectWorm;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			worm = new Idx[n];
			selectWorm = new Idx[n];
			visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				worm[i] = new Idx(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			perm(0, 0);
		}
	}

	private static void perm(int cnt, int depth) {
		if (cnt >= 2) {
			perm(2, depth);
		}
		
		for (int i = 0; i < worm.length; i++) {
			if (!visited[i]) {
				selectWorm[cnt] = worm[i];
				perm(cnt+1, depth+1);
			}
		}
	}

	static class Idx {
		int y;
		int x;
		Idx(int y, int x) {this.y = y; this.x = x;}
	}
}
