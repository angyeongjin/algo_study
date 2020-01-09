import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 나는개구리로소이다 {
	static List<Integer> frog = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for(int ti = 1; ti <= t; ti++) {
			char[] str = br.readLine().toCharArray();
			frog.clear();
			int result = -1;
			boolean flag = false;
			int max = 0;
			f:for (int i = 0; i < str.length; i++) {
				switch(str[i]) {
				case 'c':
					frog.add(1);
					break;
				case 'r':
					if (!addChar(2)) { flag = true; break f; }
					break;
				case 'o':
					if (!addChar(3)) { flag = true; break f; }
					break;
				case 'a':
					if (!addChar(4)) { flag = true; break f; }
					break;
				case 'k':
					if (!addChar(5)) { flag = true; break f; }
					break;
				}
				if (max < frog.size()) max = frog.size();
			}
			if (!flag && frog.size() == 0) {
				result = max;
			}
			bw.write("#" + ti + " " + result + "\n");
		}
		bw.flush();
	}

	private static boolean addChar(int x) {
		for (int i = 0; i < frog.size(); i++) {
			if (frog.get(i) == x-1) {
				if (x == 5) frog.remove(i);
				else frog.set(i, x);
				return true;
			}
		}
		return false;
	}
}
