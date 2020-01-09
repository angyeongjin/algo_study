import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class 염라대왕의이름정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			Set<String> words = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() == o2.length())
						return o1.compareTo(o2);
					return o1.length() - o2.length();
				}
			});
			for (int i = 0; i < n; i++) {
				String word = br.readLine();
				words.add(word);
			}
			bw.write("#" + ti + "\n");
			for (String w : words)
				bw.write(w + "\n");
			bw.flush();
		}
	}
}
