package arraysProb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    public static List<List<String>> solution(String[] input){
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: input){
            char[] chars = str.toCharArray();
            int[] freq = new int[26];
            for(char ch: chars){
                freq[ch-'a'] += 1;
            }
            map.putIfAbsent(Arrays.toString(freq), new ArrayList<>());
            map.get(Arrays.toString(freq)).add(str);
        }
        System.out.println(map.values());
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input = {"act","pots","tops","cat","stop","hat"};
        List<List<String>>  res= solution(input);
        System.out.println(res);
    }
}
