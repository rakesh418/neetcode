package slidingWindow;

import java.util.HashMap;

public class LongestRepetingChar {
    public static void main(String[] args) {
//        String s = "AAABABB";
        String s = "ABBDABBBBB";
        int l=0, r=0, k=2;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int maxFreq=0;
        while(r<s.length()){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq,map.get(ch));
            while(r-l+1-maxFreq>k){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
            maxLength = Math.max(r-l+1,maxLength);
            System.out.println(l+":"+r);
            r++;
        }
        System.out.println(maxLength);
    }
}
