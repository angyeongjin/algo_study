import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크_bit {
	static int[][] field;
	static int[] arr;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		field = new int[n][n];
		arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = i;
		int half = n/2;
		int team1 = 1;
		int team2 = 0;
		
		for (int i = 1; i < n; i++) {
			for (int j = i; j < n; j++) {
				team1 = (team1 | 1<<j); // 포함
				// 만약 half만큼 다 뽑았으면
				// 로직 시작
				
				//team1 = (team1 & ~(1<<j)); // 포함해제
			}
		}
		result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(result);
	}

}
