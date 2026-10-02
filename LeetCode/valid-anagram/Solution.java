import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray(); Arrays.sort(sChars);
        char[] tChars = t.toCharArray(); Arrays.sort(tChars);
        String sortS = new String(sChars);
        String sortT = new String(tChars);

        if (sortS.equals(sortT)) return true;
        return false;
    }
}
