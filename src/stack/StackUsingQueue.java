package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> queue;
    StackUsingQueue(){
        queue=new LinkedList<>();
    }

    public void push(int ele){
        int size = queue.size();
        queue.offer(ele);
        while(size>0){
            queue.offer(queue.poll());
            size--;
        }
    }

    public void pop(){
        System.out.println(queue.poll());
    }

    public void top(){
        System.out.println(queue.peek());
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(4);
        stack.push(2);
        stack.top();
        stack.push(3);
        stack.top();
        stack.pop();
        stack.pop();
        stack.push(7);
        stack.top();
    }
}
