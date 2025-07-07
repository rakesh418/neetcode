package dp;

public class MaxProductSubArray {

    public static void solutionPrefixSuffix(int[] nums){

        int prefix = 1, suffix=1;
        int res=nums[0];
        for(int i=0; i<nums.length;i++){
            prefix = prefix*(i==0?1:nums[i]);
            suffix= suffix*(i==nums.length-1?1:nums[nums.length-1-i]);
            res= Math.max(res, Math.max(prefix,suffix));
        }
        System.out.println(res);
    }

    public static void solutionMinMax(int[] nums){
        int currMin =1, currMax=1;
        int res=nums[0];
        for(int num: nums){
            int temp= num*currMax;
            currMax=Math.max(Math.max(num*currMax,num*currMin),num);
            currMin=Math.min(Math.min(temp,num*currMin),num);
            res= Math.max(res,currMax);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,-3,-1,4,-1};
        solutionPrefixSuffix(nums);
        solutionMinMax(nums);
    }
}
