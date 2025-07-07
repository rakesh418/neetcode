package dp;

import java.util.Arrays;

public class HouseRobberII {
    public static void findII(int[] nums){
        System.out.println(Math.max(maxProfitII(0, nums,true),maxProfitII(1, nums, false)));
    }

    public static int  maxProfitII(int index, int[] nums, boolean flag){
        if(index>=nums.length || (flag && index >= nums.length-1)) {
                return 0;
        }

//        if(index==0){
//            return Math.max(maxProfitII(index + 1, nums, false), nums[index] + maxProfitII(index + 2, nums, true));
//        }else {
            return Math.max(maxProfitII(index + 1, nums, flag), nums[index] + maxProfitII(index + 2, nums, flag));
//        }
    }

    public static void main(String[] args) {
        int[] nums = {10,10,8,15,18};
        findII(nums);
    }
}
