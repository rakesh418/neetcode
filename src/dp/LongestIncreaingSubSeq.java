package dp;

import java.util.Arrays;
import java.util.HashMap;

public class LongestIncreaingSubSeq {
    public static void main(String[] args) {
        int[] nums = {9,1,4,2,3,3,7};
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS,1);
        System.out.println(Arrays.toString(LIS));

        for(int i= nums.length-2; i>=0;i--)
            for(int j= i+1; j< nums.length;j++){
                if(nums[i]<nums[j]){
                    LIS[i] = Math.max(LIS[i], 1+LIS[j]);
                }
            }
        System.out.println(Arrays.stream(LIS).max().getAsInt());
        HashMap<Character,Integer> s = new HashMap();
        s.put('c',1);
        System.out.println(s.size());
    }
}
