import java.util.LinkedList;
import java.util.Queue;

class 문자열압축 {
    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = s.length();
        Queue<String> q = new LinkedList<>();
        for (int i = 1; i <=s.length()/2; i++) {
            for (int j = 0; j <= s.length(); j+=i) {
                if (j+i >= s.length()) q.add(s.substring(j));
                else q.add(s.substring(j, j+i));
            }
            int cnt = 1;
            String preStr = q.poll();
            String compStr = "";

            while(!q.isEmpty()){
                String str = q.poll();
                if (preStr.equals(str)) {
                    cnt++;
                } else {
                    compStr += (cnt != 1 ? cnt : "") + preStr;
                    cnt = 1;
                }
                preStr = str;
            }
            compStr += cnt != 1 ? cnt : "" + preStr;
            answer = Math.min(answer, compStr.length());
        }

        return answer;
    }
}