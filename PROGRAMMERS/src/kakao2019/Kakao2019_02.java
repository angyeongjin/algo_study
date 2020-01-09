package kakao2019;
import java.util.Scanner;

public class Kakao2019_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(solution(s));
	}

	static String solution(String p) {
        String answer = "";
        if (isUprightStr(p)) return p;
        if (p.equals("")) return p;
        
        String u = "";
        String v = "";
        
        int bracket = 0;
		if (p.charAt(0) == '(') bracket++;
		else bracket--;
        u += p.charAt(0);
        int idx = 1;
        while (bracket != 0) {
    		if (p.charAt(idx) == '(') bracket++;
    		else bracket--;
            u += p.charAt(idx++);
        }
        if (idx < p.length()) v = p.substring(idx);
        if (isUprightStr(u)) answer = u + solution(v);
        else {
        	answer += "(" + solution(v) + ")";
        	String temp = u.substring(1, u.length()-1);
        	String conv = "";
        	for (int i = 0; i < temp.length(); i++) {
        		if (temp.charAt(i) == '(') conv+= ')';
        		else conv += '(';
        	}
        	answer += conv;
        }
        return answer;
	}
	
	static boolean isUprightStr(String p) {
		int bracket = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') bracket++;
			else bracket--;
			if (bracket < 0) return false;
		}
		return true;
	}
}
