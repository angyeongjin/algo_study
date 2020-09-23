package level2;

import java.util.*;

public class 후보키 {

    static int answer = 0;
    static String[][] gRelation;
    static List<Integer> candidateKeyList;
    static int colLen;

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"}, {"200","apeach","math","2"},
                {"300","tube","computer","3"},{"400","con","computer","4"},
                {"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(solution(relation));
    }

    public static int solution(String[][] relation) {
        gRelation = relation;
        candidateKeyList = new ArrayList<>();
        colLen = relation[0].length;
        for (int i = 1; i <= colLen; i++) {
            comb(0, 0, 0, i);
        }
        System.out.println(candidateKeyList);
        return answer;
    }

    // N개를 조합
    public static void comb(int cnt, int depth, int combBit, int N) {

        // 후보키를 뽑을 때 이미 뽑은 후보키의 부분집합을 뽑지 않기 위함 (최소성 만족 조건)
        for (int k : candidateKeyList) {
            if ((k & combBit) == k) return;
        }

        if (cnt == N) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < gRelation.length; i++) {
                StringBuffer sbf = new StringBuffer();
                for (int j = 0; j < colLen; j++) {
                    if (((1 << j) & combBit) == 0) continue;
                    sbf.append(gRelation[i][j] + ",");
                }
                sbf.delete(sbf.length()-1, sbf.length());
                String str = sbf.toString();
                if (set.contains(str)) return;
                set.add(sbf.toString());
            }

            System.out.println(set);
            System.out.println(combBit);
            candidateKeyList.add(combBit);
            answer++;
            return;
        }

        if (depth >= colLen) return;

        comb(cnt+1, depth + 1, (1 << depth) | combBit, N);
        comb(cnt, depth+1, combBit, N);
    }
}
