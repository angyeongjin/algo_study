package level2;

import java.util.Arrays;
import java.util.Stack;

public class 탑 {
    public static void main(String[] args) {
        int[] heights = {1,5,3,6,7,6,5};
        System.out.println(Arrays.toString(solution(heights)));
    }

    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<int[]> stack = new Stack<>();
        // 0 : 인덱스 1: 높이
        for (int i = heights.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek()[1] < heights[i]) {
                int[] pop = stack.pop();
                answer[pop[0]] = i+1;
            }
            stack.push(new int[] {i, heights[i]});
        }
        return answer;
    }
}
