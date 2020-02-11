
public class 스킬트리 {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
	}

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
        	int idx = 0;
        	boolean flag = false;
        	for (int i = 0; i < skill_tree.length(); i++) {
        		char s = skill_tree.charAt(i);
        		if (skill.substring(idx).contains(String.valueOf(s))) {
        			if (skill.charAt(idx) == s) {
        				idx++;
        			}
        			else {
        				flag = true;
        				break;
        			}
        		}
        	}
        	if (!flag) answer++;
        }
        return answer;
    }
}
