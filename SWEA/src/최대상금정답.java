import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 최대상금정답 {
	static int maxScore = 0;
	static char[] score;
	static int limit;
	static int possibleMaxScore; // 최적화, 만들수있는 최대수
	static boolean isFindMaxScore; // 최대값을 찾았는가
	static boolean isSameNum; // 같은 숫자가 배열에 존재한가
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new FileReader("최대상금정답.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int ti = 1; ti <= t; ti++) {
			String[] str = br.readLine().split(" ");
			score = str[0].toCharArray();
			limit = Integer.parseInt(str[1]);
			maxScore = 0;
			isFindMaxScore = false;
			isSameNum = false;

			// 만들 수 있는 최대값 찾기
			char[] temp = score.clone();
			Arrays.sort(temp); // sort 해서
			for (int i = 0; i < temp.length/2; i++) {
				swap(temp, i, temp.length-1-i);
			} // 내림차순 정렬
			possibleMaxScore = Integer.parseInt(String.valueOf(temp));
			
			// 같은숫자가 들어있으면 isSameNum = true -> 같은숫자를 교환하면 교환이 일어나도 같은숫자가 될 수 있음
			boolean[] num = new boolean[10];
			for (int i = 0; i < score.length; i++) {
				if (!num[score[i]-'0'])
					num[score[i]-'0'] = true;
				else {
					isSameNum = true;
					break;
				}
			}
			
			searchMaxScore(0);
			System.out.println("#" + ti + " " + maxScore);
		}
	}

	private static void searchMaxScore(int swapCnt) {
		int createdScore = Integer.parseInt(String.valueOf(score));
		if (swapCnt == limit) {
			if (maxScore < createdScore) {
				maxScore = createdScore;
			}
			return;
		}

		if (possibleMaxScore == createdScore) { // 현재 값이 만들수있는 최대값이면
			isFindMaxScore = true;
			
			// 배열안에 같은 숫자가 없고 홀수면 -> 두번째 최대값을 저장 (가장 작은 오른쪽의 두 값을 교환)
			// 배열안에 같은 숫자가 있으면 -> 현재값을 최대값에 저장 (몇번 교환이 일어나든 최대값이 될수 있기 때문)
			// 배열안에 같은 숫자가 없고 짝수면 -> 현재값을 최대값에 저장 (같은 자리를 두번 교환하면 최대값이 될수 있기 때문)
			if ((limit-swapCnt)%2 == 1 && !isSameNum) {
				swap(score, score.length-2, score.length-1);
				maxScore = Integer.parseInt(String.valueOf(score));
				swap(score, score.length-2, score.length-1);
			}
			else {
				maxScore = createdScore;
			}
			return;
		}

		for (int i = 0; i < score.length; i++) {
			for (int j = i+1; j < score.length; j++) {
				if (isFindMaxScore) // 만약 최대값을 이미 찾았으면 return
					return;
				swap(score, i, j);
				searchMaxScore(swapCnt+1);
				swap(score, i, j);
			}
		}
	}

	private static void swap(char[] arr, int depth, int i) {
		char temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}
}