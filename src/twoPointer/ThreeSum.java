package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        int k=0;
        List<int[]> res = new ArrayList<>();
        for(int i=0; i<nums.length-2;i++){
            if(i>1 && nums[i-1]==nums[i])
                continue;
            int target = k-nums[i];
            System.out.println(Arrays.toString(nums));
            int left=i+1;
            int right= nums.length-1;
            while(left<right){
                if((nums[left]+nums[right])>target){
                    right--;
                }else if((nums[left]+nums[right])<target) {
                    left++;
                }else{
                    res.add(new int[]{nums[i],nums[left],nums[right]});
                    left++;
                    right--;
                }
            }
        }
        System.out.println(res);
    }
}
