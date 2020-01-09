package skillCheck;

import java.util.Arrays;

public class skilCheckTest1 {

	public static void main(String[] args) {
		int[] arr = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		System.out.println(Arrays.toString(solution(arr,commands)));
	}
	
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
        	int[] arr = new int[commands[i][1]-commands[i][0]+1];
        	for (int j = 0; j <= commands[i][1]-commands[i][0]; j++) {
        		arr[j] = array[commands[i][0]+j-1];
        	}
        	Arrays.sort(arr);
        	answer[i] = arr[commands[i][2]-1];
        }
        return answer;
    }

}
