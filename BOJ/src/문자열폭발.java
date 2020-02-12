import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class 문자열폭발 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] str = br.readLine().toCharArray();
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }
        char[] bomb = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        int bIdx = 0;
        ListIterator<Character> it = list.listIterator();
        while (it.hasNext()) {
            char ch = it.next();
            if (bIdx != 0 && ch == bomb[0]) {
                stack.push(bIdx);
                bIdx = 0;
            }
            if (ch == bomb[bIdx]) {
                bIdx++;
            } else {
                bIdx = 0;
            }
            if (bIdx == bomb.length) { // 여기서 터지는 거 짜면됨
                for (int j = 0; j < bomb.length; j++) {
                    it.previous();
                }
                for (int j = 0; j < bomb.length; j++) {
                    it.remove();
                    if (j!=bomb.length-1)it.next();
                }
                // 검사하던게 남아있으면 스택에서 꺼냄
                if (!stack.isEmpty()) bIdx = stack.pop();
                else bIdx = 0;
            }
        }
        if (list.size() == 0)
            bw.write("FRULA");
        else {
            for (int i = 0; i < list.size(); i++)
                bw.write(list.get(i));
        }
        bw.flush();
    }
}
