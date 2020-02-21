package level2;

import java.util.*;

public class 가장큰수 {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        List<String> numbersList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            numbersList.add(String.valueOf(numbers[i]));
        }
        Collections.sort(numbersList, new Comparator<String>() {
            @Override
            public int compare(String num1, String num2) {
                return (num2 + num1).compareTo(num1 + num2);
            }
        });
        if (Integer.parseInt(numbersList.get(0)) != 0) {
            for (String number : numbersList) {
                answer.append(number);
            }
        } else {
            answer.append("0");
        }
        return answer.toString();
    }
}
