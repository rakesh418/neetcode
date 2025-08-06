package bacmtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets1 {
    private static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> findSubsets(int [] nums){
        subset(nums, 0, new ArrayList<>());
        return result;
    }

    public static void subset(int[] nums, int i, List<Integer> subset){
        if(i==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        subset(nums, i+1, subset);
        subset.remove(subset.size()-1);
        subset(nums, i+1, subset);
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> subsetlist = findSubsets(nums);
        System.out.println(subsetlist);
    }
}
