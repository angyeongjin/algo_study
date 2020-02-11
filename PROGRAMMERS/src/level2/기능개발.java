import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {

	public static void main(String[] args) {
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] date = new int[progresses.length];
		for (int i = 0; i < progresses.length; i++) {
			date[i] = (int) Math.ceil((double)(100 - progresses[i]) / (double)speeds[i]);
		}
		List<Integer> list = new ArrayList<>();
		int maxDate = date[0];
		int cnt = 1;
		for (int i = 1; i < progresses.length; i++) {
			if (maxDate >= date[i]) {
				cnt++;
			} else {
				maxDate = date[i];
				list.add(cnt);
				cnt = 1;
			}
		}
		list.add(cnt);
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
