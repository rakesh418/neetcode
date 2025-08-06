package bacmtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations1 {
    private static List<List<Integer>> res = new ArrayList<>();
    public static void permutation(int[] nums){
        backtrack(nums,0);
    }

    public static void backtrack(int[] nums, int idx){
        if(idx==nums.length){
            res.add(Arrays.stream(nums).boxed().toList());
        }
        for(int i=idx; i<nums.length; i++){
            swap(nums, i,idx);
            backtrack(nums,idx+1);
            swap(nums, i,idx);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[]  nums = {1,2,3};
        permutation(nums);
        System.out.println(res);
    }
}
