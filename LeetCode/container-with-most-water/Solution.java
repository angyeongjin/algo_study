class Solution {
    public int maxArea(int[] height) {

        int result = 0;
        int sIdx = 0;
        int eIdx = height.length-1;

        while(sIdx < eIdx) {
            int size = (eIdx - sIdx) * (Math.min(height[sIdx], height[eIdx]));
            result = Math.max(size, result);
            if (height[sIdx] < height[eIdx]) sIdx++;
            else if (height[sIdx] > height[eIdx]) eIdx--;
            else {sIdx++; eIdx--;}
        }
        return result;
    }
}
