package dp;

public class PartitionEqualSubset {
    public static boolean canPartition(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
        return dfs(nums, 0,sum/2);
    }

    public static boolean dfs(int[] nums, int i, int target){
        if(i == nums.length){
            return false;
        }
        if(target< 0){
            return false;
        }

        if(target==0){
            return true;
        }

        return dfs(nums, i+1, target) || dfs(nums, i+1, target-nums[i]);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,8};
        System.out.println(canPartition(nums));
    }
}
