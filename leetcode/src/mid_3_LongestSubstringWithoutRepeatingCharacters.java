import java.util.*;

class mid_3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int answer = 3;
        if (lengthOfLongestSubstring(s) == (answer))
            System.out.println("Accepted!");
        else
            System.out.println("Wrong Answer");
    }

    static public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        Queue<Character> q = new LinkedList<>();
        int answer = 0;
        int len = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (set.contains(arr[i])) {
                char pollChar = q.poll();
                while(pollChar != arr[i]) {
                    set.remove(pollChar);
                    pollChar = q.poll();
                    len--;
                }
                q.offer(arr[i]);
            } else {
                set.add(arr[i]);
                q.offer(arr[i]);
                len++;
            }
            answer = Math.max(answer, len);
        }
        return answer;
    }
}