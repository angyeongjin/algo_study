package level2;

import java.util.HashSet;
import java.util.Set;

public class 캐시 {

    final static int cacheHit = 1;
    final static int cacheMiss = 5;

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA",
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        int cnt = 0;
        init(cities); // 모든 문자를 소문자로 변환
        for (int i = 0; i < cities.length; i++) {
            set.clear();
            cnt = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (cnt >= cacheSize) break;
                if (!set.contains(cities[j])) {
                    set.add(cities[j]);
                    cnt++;
                }
            }
            System.out.println(set);
            if (set.contains(cities[i])) {
                answer += cacheHit;
            } else {
                answer += cacheMiss;
            }
        }
        return answer;
    }

    public static void init(String[] cities) {
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
    }
}
