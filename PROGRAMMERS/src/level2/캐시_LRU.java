package level2;

import java.util.*;

public class 캐시_LRU {

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
        LRUCache cache = new LRUCache(cacheSize);
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            answer += cache.containsKey((city)) ? cacheHit : cacheMiss;
            cache.put(city, city);
        }

        return answer;
    }

    static class LRUCache extends LinkedHashMap<String, String> {
        final int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            return size() > capacity;
        }
    }
}
