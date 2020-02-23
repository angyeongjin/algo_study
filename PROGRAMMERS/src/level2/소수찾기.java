package level2;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    static boolean[] visited;
    static char[] permArr;
    static int answer = 0;
    static Set<Integer> overlap;

    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(solution(numbers));
    }
    public static int solution(String numbers) {
        visited = new boolean[numbers.length()];
        overlap = new HashSet<>();
        for (int i = 1; i <= numbers.length(); i++) {
            permArr = new char[i];
            perm(0, i, numbers);
        }
        return answer;
    }
    public static void perm(int depth, int limit, String numbers) {
        if (depth == limit) {
            int permNum = Integer.parseInt(String.valueOf(permArr));
            if (isPrime(permNum) && !overlap.contains(permNum)) answer++;
            overlap.add(permNum);
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permArr[depth] = numbers.charAt(i);
                perm(depth+1, limit, numbers);
                visited[i] = false;
            }
        }
    }
    public static boolean isPrime(int num) {
        if (num <= 2) return false;
        for (int i = 2; i < num; i++) {
            if (num % 2 == 0) return false;
        }
        return true;
    }
}
