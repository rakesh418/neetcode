package arraysProb;

import java.util.*;

public class TopKFreqElemnt {
    public  static void solution(int[] input,  int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer ele: input){
            map.put(ele, map.getOrDefault(ele,0)+1);
        }

        List<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            list.add( new int[]{entry.getKey(), entry.getValue()});
        }
        list.sort((a,b)->b[1]-a[1]);
        List<Integer> res = new ArrayList<>();
        for(int i=0; i< k;i++){
            res.add(list.get(i)[0]);
        }
        System.out.println(res);

    }

    public  static void solution1(int[] input,  int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer ele: input){
            map.put(ele, map.getOrDefault(ele,0)+1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            queue.add(new int[]{entry.getValue(),entry.getKey()});
//            if(queue.size()>k){
//                queue.poll();
//            }
        }
        List<Integer> res = new ArrayList<>();
        int count=0;
        while(!queue.isEmpty() && count<k){
            res.add(queue.poll()[1]);
            count++;
        }
        System.out.println(res);

    }


    public static void main(String[] args) {
        int[] input = {11,1,1,1,1,1,2,2,3,3,3};
        int k = 2;
        solution(input, k);
        solution1(input, k);
    }
}