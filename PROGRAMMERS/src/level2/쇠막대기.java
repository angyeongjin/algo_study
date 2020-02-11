
public class 쇠막대기 {

	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));
	}
	
    public static int solution(String arrangement) {
        int answer = 0; 
        int rod = 0;
        for (int i = 0; i < arrangement.length(); i++) {
        	char c = arrangement.charAt(i);
        	if (c == '(') rod++; // 막대 시작
        	else if (arrangement.charAt(i-1) == '(') answer += --rod; // 레이저
        	else { // 막대 끝
    			answer++;
    			rod--;
        	}
        }
        return answer;
    }

}
