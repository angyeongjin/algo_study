package level2;

public class _124나라의숫자 {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }
    public static String solution(int n) {
        int ternary = Integer.parseInt(String.valueOf(n), 3);
        String ternaryStr = String.valueOf(ternary);
        System.out.println(ternary);
        String answer = ternaryStr.contains("3") ? ternaryStr.replaceAll("3", "4") : ternaryStr;
        return answer;
    }
}
