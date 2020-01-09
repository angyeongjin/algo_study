import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 색종이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] field = new int[102][102];
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			for (int j = 1; j <= 10; j++) {
				for (int k = 1; k <= 10; k++) {
					field[j+y][k+x] = 1;
				}
			}
		}
		
		for (int i = 1; i < field.length-1; i++) {
			for (int j = 1; j < field.length-1; j++) {
				if (field[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int ty = i + dy[k];
						int tx = j + dx[k];
						
						if (field[ty][tx] == 0)
							cnt++;
					}
				}
			}
		}
		
		for (int[] f : field)
			System.out.println(Arrays.toString(f));
		
		System.out.println(cnt);
	}
}
