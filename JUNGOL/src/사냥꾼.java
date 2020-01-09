import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 사냥꾼 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); // 사대의 수
		int n = Integer.parseInt(st.nextToken()); // 동물의 수
		int l = Integer.parseInt(st.nextToken()); // 사정거리
		int[] shootLocation = new int[m];
		ArrayList<Idx> animalLocation = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			shootLocation[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (y <= l)
				animalLocation.add(new Idx(y, x));
		}
		Arrays.sort(shootLocation);
		Collections.sort(animalLocation, new Comparator<Idx>() {
			@Override
			public int compare(Idx o1, Idx o2) {
				return o1.x-o2.x;
			}
		});
		int j = 0;
		int answer = 0;
		for (int i = 0; i < animalLocation.size(); i++) {
			while (j < shootLocation.length && shootLocation[j] < animalLocation.get(i).x)
				j++;
			boolean flag = false;
			if (j > 0 && animalLocation.get(i).x - shootLocation[j - 1] + animalLocation.get(i).y <= l)
				flag = true;
			if (j < shootLocation.length && shootLocation[j] - animalLocation.get(i).x + animalLocation.get(i).y <= l)
				flag = true;
			if (flag)
				answer++;
		}
		System.out.println(answer);
	}

	static class Idx {
		int y;
		int x;

		Idx(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
