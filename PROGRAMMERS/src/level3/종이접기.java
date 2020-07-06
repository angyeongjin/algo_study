package level3;

import java.util.Arrays;

public class 종이접기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2)));
    }

    public static int[] solution(int n) {
        int[] answer = new int[(int) Math.pow(2, n) - 1];
        fold(2, n, answer);
        return answer;
    }

    public static void fold(int d, int n, int[] answer) {
        if (d > n) return; // 종료조건
        int mid = ((int) Math.pow(2, d) - 1) / 2;
        answer[mid] = 0; // 중간idx에 0 (중간은 무조건 0으로접힘)
        int idx = mid - 1; // 중간에서 왼쪽 한칸
        for (int i = idx + 2; i < Math.pow(2, d) - 1; i++) {
            answer[i] = answer[idx] == 1 ? 0 : 1;
            idx--;
        }
        fold(d + 1, n, answer);
    }
}
