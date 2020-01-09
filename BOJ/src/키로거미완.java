import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class 키로거미완 {

	public static void main(String[] args) {
		int t = 0;
		String printAnswer = "";
		Scanner s = new Scanner(System.in);
		t = s.nextInt();
		
		while(t > 0) {
			LinkedList linkedList = new LinkedList();
			ListIterator<Character> it = linkedList.listIterator();
			char[] keylogger = new char[1000000];
			int listLocation = 0;
			
			keylogger = s.next().toCharArray();

			for(int i = 0; i < keylogger.length; i++) {
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

			it = linkedList.listIterator();
			while(it.hasNext()) {
				printAnswer += it.next();
			}
			
			printAnswer += "\n";
			t--;
		}
		System.out.println(printAnswer);
	}
}