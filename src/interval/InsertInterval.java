package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{4,6}};
        int[] newInterval = {2,5};
        List<int[]> res = new ArrayList<>();
        for(int[] interval : intervals){
            if(newInterval == null || interval[1] < newInterval[0]){
                res.add(interval);
            }else if( interval[0] > newInterval[1]){
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            }else{
                newInterval[0]=Math.min(interval[0], newInterval[0]);
                newInterval[1]=Math.max(interval[1], newInterval[1]);
            }
        }
        if(newInterval!=null){
            res.add(newInterval);
        }

        List<List<Integer>> r = res.stream().map(arr-> Arrays.stream(arr).boxed().toList()).toList();
        System.out.println(r);
    }
}
