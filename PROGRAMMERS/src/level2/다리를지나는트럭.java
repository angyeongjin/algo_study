package level2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int curr = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        int pass = 0;
        int idx = 0;
        while (pass != truck_weights.length) { // 트럭이 다 지나갈 때까지
        	if (q.size() == bridge_length) {
        		int poll = q.poll();
        		curr -= poll;
        		if (poll != 0) pass++;
        	}
        	if (idx < truck_weights.length && curr+truck_weights[idx] <= weight) {
        		curr += truck_weights[idx];
        		q.offer(truck_weights[idx++]);
        	}
        	else { // 트럭을 못넣을때 0 집어넣어서 시간 세는용으로 처리
        		q.offer(0);
        	}
        	answer++;
        }
        return answer;
    }
}
