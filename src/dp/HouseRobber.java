package dp;

import java.util.Arrays;

public class HouseRobber {
    private static int[] memo;
    public static void find(int[] nums){
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        System.out.println(Math.max(maxProfit(0, nums),maxProfit(1, nums)));
    }

    public static int  maxProfit(int index, int[] nums){
        if(index>=nums.length)
            return 0;
        if(memo[index]!=-1){
            return memo[index];
        }
        memo[index] = Math.max(maxProfit(index+1, nums), nums[index]+ maxProfit(index+2, nums));
        return memo[index];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,9,10,1,14};
        find(nums);
    }
}
