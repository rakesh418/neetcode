package test;

import java.util.*;

class Interval{
    int start, end;
    Interval(int start, int end){
        this.start=start;
        this.end=end;
    }
}
public class Test1 {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Integer[][] meeting = {{5,8},{9,1}};
        Collections.sort(intervals, (a,b)-> a.start-b.start);

        List<int[]> pairs = new ArrayList<int[]>();
//        Collections.sort(pairs, (a,b)-> )
        String a = "stringb";
        System.out.println(a.substring(0,1));
        int[] num = {1,3,4,2};
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));

    }
}
