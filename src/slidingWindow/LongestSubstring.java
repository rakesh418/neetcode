package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "bxyaazxyt1z";
        Set<Character> set = new HashSet<>();
        int l =0, r=0, res=0;
        while(r<s.length()){
            while(l<r && set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res=Math.max(res,r-l+1);
            r++;
        }
        System.out.println("length: "+ res);
    }
}
