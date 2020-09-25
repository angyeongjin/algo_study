package level2;

import java.util.*;

public class 압축 {

    public static void main(String[] args) {
        String msg = "ABABABABABABABAB";
        System.out.println(Arrays.toString(solution(msg)));
    }

    public static int[] solution(String msg) {
        List<Integer> answerList = new ArrayList<>();
        char[] alphas = msg.toCharArray();
        Map<String, Integer> dict = new HashMap<>();
        init(dict);
        StringBuffer sbf = new StringBuffer();
        int idx = 0;
        int dictIdx = 27;
        boolean flag = true;
        while (true) {
            while (idx < alphas.length && (dict.containsKey(sbf.toString()+alphas[idx]) || flag)) {
                sbf.append(alphas[idx]);
                idx++;
                flag = false;
            }
            answerList.add(dict.get(sbf.toString()));
            if (idx >= alphas.length) break;
            sbf.append(alphas[idx]);
            dict.put(sbf.toString(),dictIdx++);
            flag = true;
            sbf = new StringBuffer();
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void init(Map<String, Integer> map) {
        for (int i = 0; i < 26; i++) {
            String str = (char) (i + 'A') + "";
            map.put(str, i+1);
        }
    }
}

