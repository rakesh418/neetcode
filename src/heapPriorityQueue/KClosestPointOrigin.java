package heapPriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointOrigin {

    public static void findClosestPoint(int[][] points, int k){
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)-> (b[0]*b[0]+b[1]*b[1]) -(a[0]*a[0]+a[1]*a[1]));
        priorityQueue.addAll(Arrays.stream(points).toList());
        System.out.println(priorityQueue);
        while(priorityQueue.size()>k){
            priorityQueue.poll();
        }
        int[][] result = new int[k][2];
        int i=0;
        while(!priorityQueue.isEmpty()){
            result[i]=priorityQueue.poll();
            i++;
        }
        System.out.println(Arrays.deepToString(result));

    }

    public static void main(String[] args) {
        int[][] points = {{0,2},{2,0},{2,2},{0,1}};
        int k = 2;
        findClosestPoint(points, k);
    }
}
