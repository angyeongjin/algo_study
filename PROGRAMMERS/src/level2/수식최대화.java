package level2;

import java.util.Arrays;
import java.util.Stack;

public class 수식최대화 {
    static int[] operatorPriority;
    static boolean[] v;
    static long answer;

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }

    public static long solution(String expression) {
        operatorPriority = new int[]{1,2,3};
        v = new boolean[3];
        priorityPerm(0, new int[]{1,2,3}, expression);
        return answer;
    }

    private static void priorityPerm(int depth, int[] arr, String expression) {
        if (depth >= 3) {
            String postFix = convToExpression(expression);
            long result = Math.abs(goalgorithm(postFix));
            answer = Math.max(answer, result);
        }

        for (int i = 0; i < operatorPriority.length; i++) {
            if (!v[i]) {
                v[i] = true;
                operatorPriority[depth] = arr[i];
                priorityPerm(depth+1, arr, expression);
                v[i] = false;
            }
        }
    }

    public static long goalgorithm(String postFix) {
        Stack<Long> stack = new Stack<>();
        String num = "";
        for (int i = 0; i < postFix.length(); i++) {
            char ch = postFix.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num += ch;
            } else if (ch == ',') {
                stack.push(Long.parseLong(num));
                num = "";
            } else {
                long op1 = stack.pop();
                long op2 = stack.pop();
                long ans = calculation(op2, op1, ch);
                stack.push(ans);
            }
        }
        return stack.pop();
    }

    public static int getOpPriority(String op) {
        switch (op) {
            case "+":
                return operatorPriority[0];
            case "-":
                return operatorPriority[1];
            case "*":
                return operatorPriority[2];
        }
        return -1;
    }

    public static String convToExpression(String exp) {
        Stack<String> stack = new Stack<>();
        int len = exp.length();
        String postFix = "";
        String num = "";

        for (int i = 0; i < len; i++) {
            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9') {
                num += ch;
            } else {
                postFix += num + ",";
                num = "";
                switch (ch) {
                    case '+':
                    case '-':
                    case '*':
                        while (!stack.isEmpty() && isProceed(stack.peek(), String.valueOf(ch)))
                            postFix += stack.pop();
                        stack.push(String.valueOf(ch));
                        break;
                }
            }
        }
        if (num != "") {
            postFix += num + ",";
        }
        while (!stack.isEmpty())
            postFix += stack.pop();
        return postFix;
    }

    public static boolean isProceed(String op1, String op2) {
        int op1Prec = getOpPriority(op1);
        int op2Prec = getOpPriority(op2);

        if (op1Prec >= op2Prec)
            return true;
        else
            return false;
    }

    public static long calculation(long op1, long op2, char ch) {
        switch(ch) {
            case '*':
                return op1 * op2;
            case '-':
                return op1 - op2;
            case '+':
                return op1 + op2;
        }
        return -1;
    }
}
