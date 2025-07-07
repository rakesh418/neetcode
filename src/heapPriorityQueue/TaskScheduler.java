package heapPriorityQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public static void solution(char[] tasks, int n) {
        HashMap<Character, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(Character ch: tasks){
            freq.put(ch, freq.getOrDefault(ch,0)+1);
        }
        maxHeap.addAll(freq.values());

        int time = 0 ;
        Queue<int[]> queue = new LinkedList<>();
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int cnt= maxHeap.poll()-1;
                if(cnt>0) {
                    queue.add(new int[]{cnt, time + n});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1]==time){
                maxHeap.offer(queue.poll()[0]);
            }
        }
        System.out.println(time);

    }
    public static void main(String[] args) {
        char[] tasks = {'X','X','X','Y', 'Y','Y'};
        int n = 3;
        solution(tasks,n);
    }
}
