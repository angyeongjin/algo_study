import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 러시아국기같은깃발 {
	static char[][] flag;
	static int[] slice;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= t; ti++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			result = Integer.MAX_VALUE;
			flag = new char[n][];
			slice = new int[2];
			for (int i = 0; i < n; i++) {
				flag[i] = br.readLine().toCharArray();
			}
			
			for (int i = 1; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					count(i, j);
				}
			} 
			bw.write("#" + ti + " " + result + "\n");
		}
		bw.flush();
	}

	private static void count(int slice1, int slice2) {
		int cnt = 0;
		for (int i = 0; i < slice1; i++) {
			for (int j = 0; j < flag[0].length; j++) {
				if (flag[i][j] != 'W') cnt++;
			}
		}
		
		for (int i = slice1; i < slice2; i++) {
			for (int j = 0; j < flag[0].length; j++) {
				if (flag[i][j] != 'B') cnt++;
			}
		}
		
		for (int i = slice2; i < flag.length; i++) {
			for (int j = 0; j < flag[0].length; j++) {
				if (flag[i][j] != 'R') cnt++;
			}
		}
		result = Math.min(result, cnt);
	}

}
