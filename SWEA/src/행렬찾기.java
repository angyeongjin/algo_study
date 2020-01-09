import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 행렬찾기 {
	static int[][] field;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		ArrayList<int[]> result = new ArrayList<>();
		
		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			field = new int[n][n];
			result.clear();
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (field[i][j] != 0) {
						int y = i;
						int x = j;
						int h = 1;
						int w = 1;
						while(y+1<n && field[y+1][x] != 0) {
							y++; h++;
						}
						while(x+1<n && field[y][x+1] != 0) {
							x++; w++;
						}
						result.add(new int[] {h, w});
						for (int k = i; k <= y; k++) {
							for (int l = j; l <= x; l++)
								field[k][l] = 0;
						}
					}
				}
			}
			Collections.sort(result, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]*o1[1] == o2[0]*o2[1] ? o1[0] - o2[0] : o1[0]*o1[1] - o2[0]*o2[1];
				}
			});
			
			System.out.print("#" + ti + " " + result.size() + " ");
			for (int[] r : result)
				System.out.print(r[0] + " " + r[1] + " ");
			System.out.println();
		}
	}
}
