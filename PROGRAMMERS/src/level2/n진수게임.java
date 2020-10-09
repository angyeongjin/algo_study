package level2;

import java.util.ArrayList;
import java.util.List;

public class n진수게임
{

    public static void main(String[] args) {
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 1;
        System.out.println(solution(n, t, m, p));
    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuffer sbf = new StringBuffer();
        int cnt = 0;
        int order = 1;
        int idx = 0;
        List<Integer> numList = new ArrayList<>();
        numList.add(0);
        while (cnt < t) {
            System.out.println(numList);
            System.out.println(order);
            System.out.println(idx);
            if (order == p) {
                sbf.append(numToAlpha(numList.get(idx)));
                cnt++;
            }

            order = order < m ? order+1 : 1;

            if (idx > 0) {
                idx -= 1;
                continue;
            }

            numList.set(0, numList.get(0)+1);
            for (int i = 0; i < numList.size(); i++) {
                if (numList.get(i) == n) {
                    numList.set(i, 0);
                    if (numList.size()-1 == i) numList.add(1);
                    else numList.set(i+1, numList.get(i+1)+1);
                }
            }
            idx = numList.size()-1;
        }
        answer = sbf.toString();
        return answer;
    }

    public static String numToAlpha(int n) {
        if (n < 10) return String.valueOf(n);
        return String.valueOf((char) ('A' + (n-10)));
    }
}
