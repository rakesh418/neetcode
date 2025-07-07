package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class WordBreak {
    public static void solution(String str, String[] wordDict){
        HashSet<String> wordSet = new HashSet<>(Arrays.stream(wordDict).toList());
        System.out.println(canSegmented(str, wordSet, 0));
    }

    public static boolean canSegmented(String str, HashSet<String> wordSet, int i){
        if(i==str.length()){
            return true;
        }
        int l=i;
        while(l<str.length()){
            if(wordSet.contains(str.substring(i,l+1))){
                if(canSegmented(str, wordSet, l+1)){
                    return true;
                }
            }
            l++;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "catsincar";
        String[] wordDict = {"cats","cat","sin","in","car"};
        solution(str, wordDict);
    }
}
