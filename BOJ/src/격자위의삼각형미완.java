import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 격자위의삼각형미완 {
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int ti = 1; ti <= t; ti++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			result = 0;
			
			if (isTriangle(x1, y1, x2, y2, x3, y3)) {
				// 세 점 사이의 길이를 각각 구한 후,
				// 세 변의 길이로 넓이를 구하고,
				// 세 변의 경계선 위의 점의 개수를 구하고,
				// result = (삼각형넓이) - (경계선위의점)/2 + 1 푼다.
				double side1 = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
				double side2 = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
				double side3 = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
				double area = areaCalc(side1, side2, side3); // 삼각형 넓이
				bw.write(area+"");
			}
			//bw.write(result);
		}
		bw.flush();
	}
	
	static double areaCalc(double a, double b, double c) {
		double s = (a + b + c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	
	static boolean isTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		if (x1 == x2 && x2 == x3) return false;
		if (y1 == y2 && y2 == y3) return false;
		return true;
	}

}
