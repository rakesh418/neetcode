package dp;

public class TargetSum {
    public static void solution(int target,int[] nums){
        System.out.println(dfs(nums,target,0));
    }

    public static int dfs(int[] nums, int target, int index){
        if(target==0 && index==nums.length){
            return 1;
        }
        if(index>= nums.length){
            return 0;
        }

        int res=0;
        res = dfs(nums,target+nums[index],index+1);  // negative sign
        res += dfs(nums,target-nums[index],index+1);  // negative sign
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,2};
        int target = 2;
        solution(target,nums);
    }
}
