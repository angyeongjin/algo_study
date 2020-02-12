package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }

    static public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (!map.containsKey(participant[i])) map.put(participant[i], 1);
            else map.put(participant[i], map.get(participant[i])+1);
        }
        for (int i = 0; i < completion.length; i++) {
            if (map.containsKey(completion[i])) {
                if (map.get(completion[i]) == 1) map.remove(completion[i]);
                else map.put(participant[i], map.get(participant[i])-1);
            }
            else {
                answer = completion[i];
                break;
            }
        }
        return answer;
    }
}
