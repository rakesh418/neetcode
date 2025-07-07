package heapPriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void solution(int[] stones){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a); // maxHeap
        priorityQueue.addAll(Arrays.stream(stones).boxed().toList());
        System.out.println(priorityQueue);
        while(priorityQueue.size()>1){
            int rem=0;
            int e1 = priorityQueue.poll();
            int e2 = priorityQueue.poll();
            if(e1==e2)
                continue;
            else {//if(ele1!=ele2){
                rem=Math.abs(e1-e2);
            }
            priorityQueue.offer(rem);
        }
        System.out.println(priorityQueue.peek());
    }
    public static void main(String[] args) {
//        int[] stones = {2,3,6,2,4};
        int[] stones = {2,2};
        solution(stones);
    }
}
