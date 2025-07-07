package heapPriorityQueue;

import javax.print.attribute.standard.Media;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> smallHeap = new PriorityQueue<>((a,b)->b-a); //maxHeapify
    PriorityQueue<Integer> largeHeap = new PriorityQueue<>((a,b)->a-b); //minHeapify

    public void addNum(int num){
        smallHeap.add(num);
        if((smallHeap.size()> largeHeap.size()+1) || ( !largeHeap.isEmpty() && smallHeap.peek()>largeHeap.peek())){
            largeHeap.add(smallHeap.poll());
        }
        if(largeHeap.size()>smallHeap.size()+1){
            smallHeap.offer(largeHeap.poll());
        }
    }

    public void findMedian(){
        if(smallHeap.size()==largeHeap.size()){
            System.out.println((smallHeap.peek()+ largeHeap.peek())/2);
        } else if (smallHeap.size()>largeHeap.size()){
            System.out.println(smallHeap.peek());
        }else{
            System.out.println(largeHeap.peek());
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.findMedian();
        medianFinder.addNum(3);
        medianFinder.addNum(2);
        medianFinder.addNum(9);
        medianFinder.addNum(4);
        medianFinder.addNum(7);
        medianFinder.addNum(8);
        medianFinder.findMedian();
    }
}
