import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두스티커 {
	static int n;
	static int m;
	static int[][] selectSticker;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static int maxArea;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		int[][] sticker = new int[k][2];
		selectSticker = new int[2][2];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			sticker[i][0] = Integer.parseInt(st.nextToken());
			sticker[i][1] = Integer.parseInt(st.nextToken());
		}
		comb(0, 0, sticker);
		
		System.out.println(maxArea);
	}

	private static void comb(int depth, int idx, int[][] sticker) {
		if (idx >= 2) {
			if (isStick()) {
				int area = selectSticker[0][0]*selectSticker[0][1]+selectSticker[1][0]*selectSticker[1][1];
				if (maxArea < area)
					maxArea = area;
			}
			return;
		}
		
		if (depth >= sticker.length)
			return;
		
		selectSticker[idx][0] = sticker[depth][0];
		selectSticker[idx][1] = sticker[depth][1];
		comb(depth+1, idx+1, sticker);
		comb(depth+1, idx, sticker);
	}

	private static boolean isStick() {
		// 그대로 붙여보고
		if (selectSticker[0][0] <= n  && selectSticker[0][1] <= m) {
			int y = selectSticker[0][0];
			int x = selectSticker[0][1];
			
			if (selectSticker[1][0] <= n-y && selectSticker[1][1] <= m)
				return true;
			else if (selectSticker[1][1] <= n-y && selectSticker[1][0] <= m)
				return true;
			else if (selectSticker[1][0] <= m-x && selectSticker[1][1] <= n)
				return true;
			else if (selectSticker[1][1] <= m-x && selectSticker[1][0] <= n)
				return true;
		}

		// 돌려서 붙여보고
		if (selectSticker[0][0] <= m  && selectSticker[0][1] <= n) {
			int y = selectSticker[0][1];
			int x = selectSticker[0][0];
			
			if (selectSticker[1][0] <= n-y && selectSticker[1][1] <= m)
				return true;
			else if (selectSticker[1][1] <= n-y && selectSticker[1][0] <= m)
				return true;
			else if (selectSticker[1][0] <= m-x && selectSticker[1][1] <= n)
				return true;
			else if (selectSticker[1][1] <= m-x && selectSticker[1][0] <= n)
				return true;
		}
		// 그래도 안되면 false return;
		return false;
	}
}
