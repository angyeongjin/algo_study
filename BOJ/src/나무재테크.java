import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 나무재테크 {
	static int[][] field;
	static List<Tree>[][] trees;
	static int[][] fert; // 양분
	static int[] dy = {0,0,1,-1,-1,1,-1,1};
	static int[] dx = {1,-1,0,0,-1,-1,1,1};
	static int cnt;
	static List<int[]> deadTrees = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // field크기
		int m = Integer.parseInt(st.nextToken()); // 나무수
		int k = Integer.parseInt(st.nextToken()); // 년수
		field = new int[n][n];
		trees = new LinkedList[n][n];
		cnt = m;
		fert = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				fert[i][j] = Integer.parseInt(st.nextToken());
				field[i][j] = 5;
				trees[i][j] = new LinkedList<>();
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			trees[y][x].add(new Tree(Integer.parseInt(st.nextToken())));
		}
		for (int i = 0; i < k; i++) {
			deadTrees.clear();
			spring();
			summer();
			fall();
			winter();
			for (int[] t : field)
				System.out.println(Arrays.toString(t));
			System.out.println();
		}
		System.out.println(cnt);
	}
	private static void winter() {
		for (int i = 0; i < trees.length; i++) {
			for (int j = 0; j < trees[0].length; j++) {
				field[i][j] += fert[i][j];
			}
		}
	}
	private static void fall() {
		List<int[]> idxs = new LinkedList<>();
		for (int i = 0; i < trees.length; i++) {
			for (int j = 0; j < trees[0].length; j++) {
				for (Tree t : trees[i][j]) {
					if (t.age % 5 == 0) {
						idxs.add(new int[] {i, j});
					}
				}
			}
		}
		for (int[] idx : idxs) {
			for (int k = 0; k < 8; k++) {
				int ty = idx[0] + dy[k];
				int tx = idx[1] + dx[k];
				if (0 <= ty && ty < field.length && 0 <= tx && tx < field[0].length) {
					trees[ty][tx].add(0, new Tree(1));
					cnt++;
				}
			}
		}
	}
	private static void summer() {
		for (int i = 0; i < deadTrees.size(); i++) {
			int[] idx = deadTrees.get(i);
			field[idx[0]][idx[1]] += idx[2]/2;
			cnt--;
		}
	}
	private static void spring() {
		for (int i = 0; i < trees.length; i++) {
			for (int j = 0; j < trees[0].length; j++) {
				Iterator<Tree> it = trees[i][j].iterator();
				while (it.hasNext()) {
					Tree t = it.next();
					if (field[i][j] >= t.age) { // spring
						field[i][j] -= t.age;
						t.age++;
					} else { // summer
						deadTrees.add(new int[] {i, j, t.age});
						it.remove();
					}
				}
			}
		}
	}
	static class Tree {
		int age;
		public Tree(int age) {
			this.age = age;
		}
	}
}
