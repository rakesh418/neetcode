package bacmtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] nums, int target){
        List<Integer> subset = new ArrayList<>();
        dfs(nums, target, subset, 0);
        return res;
    }

    public static void dfs(int[] nums, int target, List<Integer> subset, int i){
        if(i==nums.length){
            if(target==0){
                res.add(new ArrayList<>(subset));
            }
        return;
        }

        if(target>=nums[i]){
            subset.add(nums[i]);
            dfs(nums, target-nums[i], subset, i);
            subset.remove(subset.size()-1);
        }
//        subset.add(nums[i]);
//        dfs(nums, target-nums[i], subset, i+1);
//        subset.remove(subset.size()-1);
        dfs(nums, target, subset, i+1);
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,9};
        int target = 9;
        List<List<Integer>>  list = combinationSum(nums,target);
        System.out.println(list);
    }
}
