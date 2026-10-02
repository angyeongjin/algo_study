class Solution {
    public boolean isPalindrome(String s) {
        for (int sIdx = 0, eIdx = s.length()-1; sIdx < eIdx; ++sIdx, --eIdx) {
            while(sIdx < eIdx && !isAlphabeticOrNumber(s.charAt(sIdx))) sIdx++;
            while(eIdx > sIdx && !isAlphabeticOrNumber(s.charAt(eIdx))) eIdx--;
            if (sIdx >= eIdx) break;
            char preAlpha = Character.toLowerCase(s.charAt(sIdx));
            char postAlpha = Character.toLowerCase(s.charAt(eIdx));
            if (preAlpha != postAlpha) return false;
        }

        return true;
    }

    public boolean isAlphabeticOrNumber(char c) {
        return Character.isAlphabetic(c) || (c >= '0' && c <= '9');
    }
}
