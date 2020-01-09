import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 색종이붙이기미완 {
	static char[][] field;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] paperCnt = {5,5,5,5,5};
		field = new char[10][10];
		int cnt = 0;
		int minCnt = Integer.MAX_VALUE;
		boolean flag = false;

		for (int i = 0; i < 10; i++) {
			field[i] = br.readLine().replaceAll(" ", "").toCharArray();
		}

		char [][] temp = new char[10][10];
		for(int i = 0; i < 10; i++)
			temp[i] = field[i].clone();

		for (int n = 5; n > 0; n--) {
			Arrays.fill(paperCnt, 5);
			cnt = 0;
			boolean isCoverable = true;

			for(int i = 0; i < 10; i++)
				field[i] = temp[i].clone();
			for (int i = n; i >= 1; i--) {
				for (int j = 0; j < 10-i+1; j++) {
					for (int k = 0; k < 10; k++) {

						if (field[j][k] == '1') {
							boolean isISize = true;
							f:for (int l = j; l < j+i; l++) {
								for (int m = k; m < k+i; m++) { 
									if ( l < 10 && m < 10) {
										if (field[l][m] != '1') {isISize = false; break f;}
									}
									else {
										isISize = false; break f;
									}
								}
							}

							if (isISize) {
								deletePaper(i, j, k);
								paperCnt[i-1]--;
								cnt++;
							}
						}
					}
				}
			}

			for (int i = 0; i < paperCnt.length; i++) {
				if (paperCnt[i] < 0)
					isCoverable = false;
			}

			if (isCoverable) {
				if (minCnt > cnt)
					minCnt = cnt;
				flag = true;
			}
		}

		if (flag)
			System.out.println(minCnt);
		else
			System.out.println(-1);
	}

	private static void deletePaper(int n, int y, int x) {
		for (int i = y; i < y+n; i++) {
			for (int j = x; j < x+n; j++) {
				field[i][j] = '0';
			}
		}
	}
}
