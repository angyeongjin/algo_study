package level1;

import java.util.*;

public class 실패율 {
    public static void main(String[] args) {
        int N = 1;
        int[] stages = {2,2,2,2,2,2,2};
        int[] result = solution(N, stages);
        System.out.println(Arrays.toString(result));
    }

    static public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Stage> calStages = new ArrayList<>();
        Arrays.sort(stages);
        int idx = 1;
        double child = 0;
        double parent = stages.length;
        for (int i = 1; i < stages.length; i++) {
            child++;
            while (stages[i-1] != idx) {
                calStages.add(new Stage(idx, 0));
                idx++;
            }
            if (stages[i-1] != stages[i]) {
                System.out.println(child + "/" + parent);
                calStages.add(new Stage(idx, child/parent));
                parent -= child;
                child = 0;
                idx++;
            }
        }
        if (parent > 0) {
            System.out.println(child + "/" + parent);
            calStages.add(new Stage(idx, child/parent));
            idx++;
        }

        while (idx <= N) {
            calStages.add(new Stage(idx, 0));
            idx++;
        }
        Collections.sort(calStages);
        for (int i = 0; i < N; i++) {
            answer[i] = calStages.get(i).num;
        }
        return answer;
    }

    static class Stage implements Comparable<Stage> {
        int num;
        double failureRate;

        public Stage(int num, double failureRate) {
            this.num = num;
            this.failureRate = failureRate;
        }

        @Override
        public int compareTo(Stage stage) {
            if (this.failureRate == stage.failureRate) return this.num - stage.num;;
            return stage.failureRate - this.failureRate < 0 ? -1 : 1;
        }
    }
}
