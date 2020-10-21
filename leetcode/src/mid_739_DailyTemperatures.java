import java.util.Arrays;
import java.util.PriorityQueue;

public class mid_739_DailyTemperatures {

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] answer = dailyTemperatures(T);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] dailyTemperatures(int[] T) {
        PriorityQueue<Temperature> pq = new PriorityQueue<>();
        int[] answer = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!pq.isEmpty() && pq.peek().temp < T[i]) {
                int idx = pq.poll().index;
                answer[idx] = i - idx;
            }
            pq.offer(new Temperature(T[i], i));
        }
        return answer;
    }

    static class Temperature implements Comparable<Temperature> {
        int temp;
        int index;

        public Temperature(int temp, int index) {
            this.temp = temp;
            this.index = index;
        }

        @Override
        public int compareTo(Temperature o) {
            return this.temp - o.temp;
        }
    }

}
