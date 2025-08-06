package bacmtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
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

        subset.add(nums[i]);
        dfs(nums, target - nums[i], subset, i + 1);
        while((i+1)<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        subset.remove(subset.size()-1);
        dfs(nums, target, subset, i+1);
    }

    public static void main(String[] args) {
        int[] nums = {9,2,2,4,6,1,5};
        Arrays.sort(nums);
        int target = 8;
        List<List<Integer>>  list = combinationSum(nums,target);
        System.out.println(list);
    }
}
