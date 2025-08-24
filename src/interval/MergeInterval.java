package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals = {{7,8}, {1,5},{1,6},{7,8}};
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        List<int[]> res = new ArrayList<>();
        for(int[] interval : intervals){
            if(res.isEmpty()){
                res.add(interval);
            }else{
                int[] lastElement = res.getLast();
                if(lastElement[1]<interval[0]){
                    res.add(interval);
                }else if(lastElement[0]>interval[1]){
                    res.removeLast();
                    res.add(interval);
                    res.add(lastElement);
                }else{
                    lastElement[0]= Math.min(lastElement[0], interval[0]);
                    lastElement[1]= Math.max(lastElement[1], interval[1]);
                    res.removeLast();
                    res.add(lastElement);
                }
            }
        }

        List<List<Integer>> r = res.stream().map(arr-> Arrays.stream(arr).boxed().toList()).toList();
        System.out.println(r);
    }
}
