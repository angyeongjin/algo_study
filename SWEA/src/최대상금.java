import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class 최대상금 {
	static int maxScore = 0;
	static char[] score;
	static int limit;
	
	static HashMap<Integer, Integer> visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("최대상금정답.txt"));
		int t = Integer.parseInt(br.readLine());

		for (int ti = 1; ti <= t; ti++) {
			visited = new HashMap<>();
			maxScore = 0;
			String[] str = br.readLine().split(" ");
			score = str[0].toCharArray();
			limit = Integer.parseInt(str[1]);
			
			searchMaxScore(0);
			System.out.println("#" + ti + " " + maxScore);
		}
	}

	private static void searchMaxScore(int swapCnt) {
		int createdScore = Integer.parseInt(String.valueOf(score));
//		System.out.println(createdScore);
		
		if (!visited.containsKey(createdScore) || visited.get(createdScore) > swapCnt) {
			visited.put(createdScore, swapCnt);
		}
		else {
			return;
		}
		
		if (swapCnt == limit) {
			if (maxScore < createdScore) {
				maxScore = createdScore;
			}
			return;
		}
		
		for (int i = 0; i < score.length; i++) {
			for (int j = i+1; j < score.length; j++) {
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