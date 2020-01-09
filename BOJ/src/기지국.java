import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 기지국 {
	static char[][] field;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			field = new char[n][n];
			for (int i = 0; i < n; i++) {
				field[n] = br.readLine().toCharArray();
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (field[i][j] == 'A' || field[i][j] == 'B' || field[i][j] == 'C') {
						for (int k = 0; k < 4; k++) {
							int ty = i;
							int tx = j;
							for (int l = 0; l <= 'A'-field[i][j]; l++) {
								ty += dy[k];
								tx += dx[k];
								
							}
						}
					}
				}
			}
		}
	}
}
