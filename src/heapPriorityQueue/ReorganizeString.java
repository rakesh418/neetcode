package heapPriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringJoiner;

public class ReorganizeString {
    public static void main(String[] args) {
        String s = "xxyyyy";
        Map<Character, Integer> count = new HashMap<>();
        for(char c : s.toCharArray()){
            count.put(c, count.getOrDefault(c,0)+1);
        }

        StringBuilder res = new StringBuilder();

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a,b)->count.get(b)-count.get(a));
        priorityQueue.addAll(count.keySet());
        System.out.println(priorityQueue);
        while(!priorityQueue.isEmpty() && priorityQueue.size()>1){
            char c1 = priorityQueue.poll();
            char c2 = priorityQueue.poll();
            res.append(c1).append(c2);
            if(count.get(c1)>1){
                count.put(c1,count.get(c1)-1);
                priorityQueue.add(c1);
            }
            if(count.get(c2)>1){
                count.put(c2,count.get(c2)-1);
                priorityQueue.add(c2);
            }
        }
        if(!priorityQueue.isEmpty() && count.get(priorityQueue.peek())==1){
            res.append(priorityQueue.peek());
        }else if (!priorityQueue.isEmpty() && count.get(priorityQueue.peek())>1){
            res =new StringBuilder();
        }
        System.out.println(res.toString());
    }
}
