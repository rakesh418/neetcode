package arraysProb;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static  int[][] solution(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length;i++){
            int num = arr[i];
            int diff = target-num;
            if(map.containsKey(diff)){
                return new int[][]{{map.get(diff),i}};
            }
            map.put(num,i);
        }
        return new int[0][];
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,4};
        int target = 10;
        int [][] res= solution(arr, target);
        System.out.println(Arrays.deepToString(res));
    }
}
