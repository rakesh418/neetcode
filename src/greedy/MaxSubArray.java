package greedy;

public class MaxSubArray {

    public static int findMaxSumSubArray(int[] nums){
        int sum=0;
        int l=0;
        int maxSum = 0;
        while(l<nums.length){
            sum = sum+nums[l];
            maxSum = Math.max(sum,maxSum);
            if(sum<0){
                sum=0;
            }
            l++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2,-3,4,-2,2,1,-1,4};
        System.out.println(findMaxSumSubArray(nums));
    }
}
