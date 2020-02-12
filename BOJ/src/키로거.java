import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class 키로거 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		LinkedList<Character> linkedList = new LinkedList<>();

		for (int ti = 1; ti <= t; ti++) {
			linkedList.clear();
			ListIterator<Character> it = linkedList.listIterator();
			char[] keylogger = br.readLine().toCharArray();
			String printAnswer = "";

			for (int i = 0; i < keylogger.length; i++) {
				if(keylogger[i] == '<') {
					if(it.hasPrevious()) it.previous();
				}
				else if(keylogger[i] == '>') {
					if(it.hasNext()) it.next();
				}
				else if(keylogger[i] == '-') {
					if(it.hasPrevious()) {
						it.previous();
						it.remove();
					}
				}
				else {
					it.add(keylogger[i]);
				}
			}
			printAnswer = String.valueOf(linkedList);
			printAnswer = printAnswer.substring(1, printAnswer.length()-1).replaceAll(", ", "");
			bw.write(printAnswer+"\n");
		}
		bw.flush();
	}
}