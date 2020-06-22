package level1;

public class 다트게임 {

	public static void main(String[] args) {
		String dartResult = "1S*2T*3S";
		System.out.println(solution(dartResult));
	}

	static int solution(String dartResult) {
		int answer = 0;
		char[] command = dartResult.toCharArray();
		int[] score = new int[3];
		int idx = -1;
		for (int i = 0; i < command.length; i++) {
			
			// 숫자가 들어오는 경우
			if (Character.isDigit(command[i])) {
				idx++;
				if (command[i+1] == '0') {
					score[idx] = 10;
					i++;
				}
				else score[idx] = command[i] - '0';
			}
			
			// 보너스가 들어오는 경우
			if (command[i] == 'D') {
				score[idx] = score[idx] * score[idx];
			} else if (command[i] == 'T') {
				score[idx] = score[idx] * score[idx] * score[idx];
			}
			
			// 옵션이 들어오는 경우
			if (command[i] == '*') {
				score[idx] *= 2;
				if (idx > 0) score[idx-1] *= 2;
			} else if (command[i] == '#') {
				score[idx] = -score[idx];
			}
		}
		
		for (int i = 0; i < score.length; i++) {
			answer += score[i];
		}
		return answer;
	}

}
