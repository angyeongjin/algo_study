package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        makeSet(str1, list1);
        makeSet(str2, list2);

        Collections.sort(list1);
        Collections.sort(list2);

        System.out.println(list1);
        System.out.println(list2);

        answer = calculateJacquardSimilarity(list1, list2);

        return answer;
    }

    private static int calculateJacquardSimilarity(List<String> list1, List<String> list2) {
        int idx1 = 0, idx2 = 0;
        double intersectionCnt = 0, unionCnt = 0;
        while (idx1 < list1.size() && idx2 < list2.size()) {
            if (list1.get(idx1).equals(list2.get(idx2))) {
                intersectionCnt++;
                unionCnt++;
                idx1++; idx2++;
            } else {
                System.out.println(list1.get(idx1) + ", " + list2.get(idx2));
                if (list1.get(idx1).compareTo(list2.get(idx2)) < 0) {
                    idx1++;
                } else {
                    idx2++;
                }
                unionCnt++;
            }
        }
        System.out.println(idx1 + ", " + idx2);
        unionCnt += checkRemainder(list1, idx1);
        unionCnt += checkRemainder(list2, idx2);

        System.out.println(intersectionCnt + "," + unionCnt);
        if (intersectionCnt == unionCnt) return 65536;
        return (int) (intersectionCnt / unionCnt * 65536);
    }

    private static int checkRemainder(List<String> list, int idx) {
        int unionCnt = 0;
        if (idx < list.size()) {
            while (idx < list.size()) {
                unionCnt++;
                idx++;
            }
        }
        return unionCnt++;
    }

    private static void makeSet(String str, List<String> list) {
        for (int i = 0; i < str.length()-1; i++) {
            String split = str.substring(i, i+2);
            if (isAlphabet(split)) {
                list.add(split);
            }
        }
    }

    private static boolean isAlphabet(String split) {
        if ('A' > split.charAt(0) || 'Z' < split.charAt(0))
            return false;
        if ('A' > split.charAt(1) || 'Z' < split.charAt(1))
            return false;
        return true;
    }
}
