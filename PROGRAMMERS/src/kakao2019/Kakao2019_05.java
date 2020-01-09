package kakao2019;

import java.util.Arrays;

public class Kakao2019_05 {

	public static void main(String[] args) {
		int n = 5;
		int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		int[][] answer = solution(n, build_frame);
		for (int[] a : answer)
			System.out.println(Arrays.toString(a));
	}

    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        for (int i = 0; i < build_frame.length; i++) {
        	
        }
        return answer;
    }
    
    public void addPillar(int[][] build_frame, int x, int y) {
    	
    }
}
