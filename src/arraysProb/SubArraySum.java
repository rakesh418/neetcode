package arraysProb;

import java.util.HashMap;

public class SubArraySum {
    public static void main(String[] args) {
        int[] nums={2,-1,1,2};
        int k=2;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        int res=0;
        for(int num: nums){
            sum=sum+num;
            int diff = sum-k;
            res+= map.getOrDefault(diff,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        System.out.println(map);
    }
}
