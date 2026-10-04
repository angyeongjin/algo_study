import java.util.*;

class Solution {

    public int rob(int[] nums) {
        int[] money = new int[nums.length];
        Arrays.fill(money, -1);
        int result = 0;
        money[0] = pickHouse(0, money, nums);
        result = money[0];

        if (nums.length > 1) {
            money[1] = pickHouse(1, money, nums);
            result = Math.max(result, money[1]);
        }
        // System.out.println(Arrays.toString(money));
        return result;
    }

    public int pickHouse(int i, int[] money, int[] nums) {
        if (i+2 >= nums.length)
            return nums[i];

        int result = 0;
        money[i+2] = money[i+2] == -1 ? pickHouse(i+2, money, nums) : money[i+2];
        result = money[i+2];

        if (nums.length > i+3) {
            money[i+3] = money[i+3] == -1 ? pickHouse(i+3, money, nums) : money[i+3];
            result = Math.max(result, money[i+3]);
        }
        
        return nums[i] + result;
    }
}
