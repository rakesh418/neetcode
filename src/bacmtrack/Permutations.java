package bacmtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    static List<List<Integer>> result = new ArrayList<>();

    public static void solution(int[] nums){
        int[] pick = new int[nums.length];
        Arrays.fill(pick,0);
        backTrack(nums, new ArrayList<>(), pick);
        System.out.println(result);
    }

    public static void backTrack(int[] nums, List<Integer> perm, int[] pick){
        if(perm.size()==nums.length){
            result.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0; i< nums.length;i++){
            if(pick[i]!=1){
                perm.add(nums[i]);
                pick[i]=1;
                backTrack(nums, perm, pick);
                perm.remove(perm.size()-1);
                pick[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        solution(nums);
    }
}
