import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class 조세퍼스문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read = br.readLine().split(" ");
		int n = Integer.parseInt(read[0]);
		int k = Integer.parseInt(read[1]);

		List<Integer> list = new LinkedList<>();
		for (int i = 1; i<= n; i++) {
			list.add(i);
		}

		int idx = 0;

		System.out.print("<");
		while (!list.isEmpty()) {
			for (int i = 0; i < k-1; i++)
				idx = idx+1 < list.size() ? idx+1 : 0;

			if (list.size() == 1)
				System.out.print(list.get(idx));
			else
				System.out.print(list.get(idx) + ", ");
			list.remove(idx);

			if (idx >= list.size())
				idx = 0;
		}
		System.out.print(">");
	}
}
