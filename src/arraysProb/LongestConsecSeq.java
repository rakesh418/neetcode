package arraysProb;

import java.util.HashSet;

public class LongestConsecSeq {
    public static void main(String[] args) {
        int [] nums = {2,20,4,10,3,4,5};
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longest = 0;
        for(int num: nums){
            int count=0;
            if(!set.contains(num-1)){
                while(set.contains(num)){
                    count++;
                    num=num+1;
                }
                longest = Math.max(longest,count);
            }
        }
        System.out.println(longest);
    }
}
