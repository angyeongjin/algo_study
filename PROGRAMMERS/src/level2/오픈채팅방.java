package level2;

import java.util.*;

public class 오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<ChatLog> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] log = record[i].split(" ");
            String command = log[0];
            String id = log[1];
            String nickname = "";
            switch (command) {
                case "Enter":
                    nickname = log[2];
                    map.put(id, nickname);
                    list.add(new ChatLog("님이 들어왔습니다.", id));
                    break;
                case "Leave":
                    list.add(new ChatLog("님이 나갔습니다.", id));
                    break;
                case "Change":
                    nickname = log[2];
                    map.put(id, nickname);
                    break;
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = map.get(list.get(i).id) + list.get(i).command;
        }
        return result;
    }

    static class ChatLog {
        String command;
        String id;

        public ChatLog(String command, String id) {
            this.command = command;
            this.id = id;
        }
    }
}
