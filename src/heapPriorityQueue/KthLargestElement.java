package heapPriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    PriorityQueue<Integer> priorityQueue;
    int k;
    KthLargestElement(int k, int[] nums){
        this.k=k;
        this.priorityQueue= new PriorityQueue<>(Arrays.stream(nums).boxed().toList());  // minHeapProperty
        while(priorityQueue.size()>k){
            priorityQueue.poll();
        }
    }

    public void add(int num){
        priorityQueue.add(num);
        int element=-1;
        if(priorityQueue.size()>k){
            element = priorityQueue.poll();
        }
        System.out.println(priorityQueue.peek());
    }

    public static void main(String[] args) {
        KthLargestElement kthLargest = new KthLargestElement(3, new int[] {1, 2, 3, 3});
        System.out.println(kthLargest.priorityQueue);
//        kthLargest.priorityQueue.poll();
//        System.out.println(kthLargest.priorityQueue);
        kthLargest.add(3);   // return 3
        kthLargest.add(5);   // return 3
        kthLargest.add(6);   // return 3
        kthLargest.add(7);   // return 5
        kthLargest.add(8);   // return 6
    }
}
