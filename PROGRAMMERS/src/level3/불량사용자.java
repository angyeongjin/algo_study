package level3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 불량사용자 {
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] banned_id = {"fr*d*", "abc1**"};
        String[] banned_id = {"*rodo", "*rodo", "******"};
        System.out.println(solution(user_id, banned_id));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        boolean[] isUsed = new boolean[user_id.length];
        assume(0, user_id, banned_id, isUsed);
        return answer;
    }

    static int answer = 0;
    static Set<String> set = new HashSet<>();

    public static void assume (int k, String[] user_id, String[] banned_id, boolean[] isUsed) {
        if (k == banned_id.length) {
            if (!set.contains(Arrays.toString(isUsed))) {
                answer++;
                set.add(Arrays.toString(isUsed));
            }
            return;
        }
        for (int i = 0; i < user_id.length; i++) {
            System.out.println(k);
            if (isUsed[i]) continue;
            if (banned_id[k].length() != user_id[i].length()) continue;
            boolean flag = false;
            for (int j = 0; j < user_id[i].length(); j++) {
                if (banned_id[k].charAt(j) == '*') continue;
                if (banned_id[k].charAt(j) != user_id[i].charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                isUsed[i] = true;
                assume(k+1, user_id, banned_id, isUsed);
                isUsed[i] = false;
            }
        }
    }
}
