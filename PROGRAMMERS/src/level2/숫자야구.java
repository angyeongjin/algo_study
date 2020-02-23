package level2;

public class 숫자야구 {
    static int N = 3;

    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        System.out.println(solution(baseball));
    }

    public static int solution(int[][] baseball) {
        int answer = 0;
        for (int i = 100; i < 1000; i++) {
            if (String.valueOf(i).contains("0") || isOverlap(i))
                continue;
            for (int j = 0; j < baseball.length; j++) {
                int strike = countStrike(i, baseball[j][0]);
                int ball = countBall(i, baseball[j][0]) - strike;
                if (strike != baseball[j][1] || ball != baseball[j][2])
                    break;
                if (j == baseball.length-1) {
                    answer++;
                    System.out.println(i);
                }
            }
        }
        return answer;
    }

    public static boolean isOverlap(int num) {
        boolean[] arr = new boolean[10];
        for (int i = 0; i < N; i++) {
            if (arr[num % 10]) return true;
            arr[num % 10] = true;
            num = num / 10;
        }
        return false;
    }

    public static int countStrike(int num1, int num2) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += num1%10 == num2%10 ? 1 : 0;
            num1 = num1 / 10;
            num2 = num2 / 10;
        }
        return cnt;
    }

    public static int countBall(int num1, int num2) {
        int cnt = 0;
        String strNum1 = String.valueOf(num1);
        String strNum2 = String.valueOf(num2);
        for (int i = 0; i < N; i++) {
            if (strNum1.contains(String.valueOf(strNum2.charAt(i))))
                cnt++;
        }
        return cnt;
    }
}
