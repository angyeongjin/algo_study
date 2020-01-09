import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 자기방으로돌아가기미완 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<int[]> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}

			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) return o1[0] - o1[0];
					else return o1[1] - o2[1];
				}
			});
			
			ArrayList<int[]> deleteList = new ArrayList<>();
			int cnt = 0;
			
			while (!list.isEmpty()) {
				cnt++;
				
				int start = 1;
				deleteList.clear();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i)[0] >= start) {
						start = list.get(i)[1];
						deleteList.add(list.get(i));
					}
				}
				
				for (int i = 0; i < deleteList.size(); i++) {
					list.remove(deleteList.get(i));
				}
			}
			
			System.out.println("#" + ti + " " + cnt);
		}
	}
}
