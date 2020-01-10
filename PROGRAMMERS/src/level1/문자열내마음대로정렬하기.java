package level1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        String[] answer = solution(strings,n);
        bw.write(Arrays.toString(answer));
        bw.flush();
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                else return s1.charAt(n) - s2.charAt(n);
            }
        });
        return strings;
    }

}
