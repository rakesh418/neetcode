package bacmtrack;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    public static void solution(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subsets = new ArrayList<>();
        backtrack(nums, result,subsets, 0);
        System.out.println(result);
    }

    public static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> subset, int i){
        if(i== nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(nums, result,subset, i+1);
        subset.remove(subset.size()-1);
        backtrack(nums, result,subset, i+1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        solution(nums);
    }
}
