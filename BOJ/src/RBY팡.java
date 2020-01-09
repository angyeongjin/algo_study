import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RBY팡 {
	static ArrayList<Integer> arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		arr = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		

		for (int i = 0; i < n; i++) {
			ArrayList<Integer> temp1 = (ArrayList<Integer>) arr.clone();
			ArrayList<Integer> temp2 = (ArrayList<Integer>) arr.clone();
			int idx = temp1.get(i);
			idx = idx+1>=4 ? 1 : idx+1;
			temp1.set(i, idx);
			// 팡 하기
			pang(temp1);
			if (temp1.size() < min)
				min = temp1.size();
			idx = idx+1>=4 ? 1 : idx+1;
			temp2.set(i, idx);
			pang(temp2);
			if (temp2.size() < min)
				min = temp2.size();
		}
		
		System.out.println(min);
	}

	private static void pang(ArrayList<Integer> temp) {
		int cnt = 1;
		int i = 0;
		while (i < temp.size()-1) {
			if (temp.get(i) == temp.get(i+1)) cnt++;
			else {
				if (cnt >= 4) { // 삭제
					for (int j = 0; j < cnt; j++) {
						temp.remove(i-cnt+1);
					}
					i = -1;
				}
				cnt = 1;
			}
			i++;
		}
		if (cnt >= 4) { // 삭제
			for (int j = 0; j < cnt; j++) {
				temp.remove(i-cnt+1);
			}
		}
	}
}
